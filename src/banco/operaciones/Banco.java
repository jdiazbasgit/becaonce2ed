package banco.operaciones;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:59
 */

public class Banco {

	public  Map<Cuenta, List<Movimiento>> cuentas;
	
	private String nombreDelBanco; 

	public String getNombreDelBanco() {
		return nombreDelBanco;
	}
	public void setNombreDelBanco(String nombreDelBanco) {
		this.nombreDelBanco = nombreDelBanco;
	}
	public Banco(String nombreDelBanco) {
		setNombreDelBanco(nombreDelBanco);
	}



	public void crearCuenta() {

		System.out.println("Escribe el alias de la cuenta:");
		String alias = leerTecladoTexto();

		try {
			int ultimaCuenta = calcularNumeroDeCuenta();
			ultimaCuenta++;
			Cuenta cuenta = new Cuenta();
			cuenta.setNumeroCuenta(ultimaCuenta);
			cuenta.setAlias(alias);
			grabarCuenta(cuenta);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void listarCuentas() {
		try {
			Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("banco.cuentas");
			for (Cuenta cuenta : cuentas.keySet()) {
				System.err.println("numero de cuenta:" + cuenta.getNumeroCuenta() + " - alias:" + cuenta.getAlias());
			}
		} catch (Exception e) {
			System.out.println("no existen cuentas");
		}
	}

	public void ingresarDinero() {
		Cuenta cuentaElegida = seleccionarCuenta();
		int importe = escribirImporte();
		if (operar(cuentaElegida, importe))
			System.err.println("importe ingresado correctamentre");
		else
			System.err.println("El importe no se ha podido ingresar");
	}

	public boolean operar(Cuenta cuenta, int importe) {

		System.out.println("Importe obtenido es: " + importe);
		Movimiento movimiento = new Movimiento(new GregorianCalendar(), importe);
		getCuentas().get(cuenta).add(movimiento);
		try {
			grabaArchivo("banco.cuentas", getCuentas());
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}

	}

	public void sacarDinero() {
		System.out.println("Seleccione cuenta");
		Cuenta cuentaElegida = seleccionarCuenta();
		int saldo = consultarSaldo(cuentaElegida);
		System.out.println("indica el importe:");
		int importe = escribirImporte();
		if (importe > saldo) {
			System.out.println("no tienes dinero");
			return;
		}
		if (operar(cuentaElegida, importe * -1))
			System.err.println("importe reintegrado correctamentre");
		else
			System.err.println("El importe no se ha podido reintegrar");

	}

	public int consultarSaldo(Cuenta cuenta) {

		int saldo = 0;
		for (Movimiento movimiento : getCuentas().get(cuenta)) {
			saldo += movimiento.getImporte();

		}

		return saldo;

	}

	public void consultarMovimiento() {
		Cuenta cuentaElegida = seleccionarCuenta();
		for (Movimiento movimiento : getCuentas().get(cuentaElegida)) {

			Calendar a = movimiento.getFecha();
			System.out.println(a.get(Calendar.DAY_OF_MONTH) + "/"
					+ a.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + "/" + a.get(Calendar.YEAR)
					+ " - " + movimiento.getImporte());
		}

	}

	public Cuenta seleccionarCuenta() {
		listarCuentas();
		System.out.println("indica numero de cuenta:");
		int numeroCuenta = Integer.parseInt(leerTecladoTexto());
		Cuenta cuentaElegida = null;
		for (Cuenta cuenta : getCuentas().keySet()) {
			if (cuenta.getNumeroCuenta() == numeroCuenta) {
				cuentaElegida = cuenta;
				break;
			}

		}
		return cuentaElegida;
	}

	public int escribirImporte() {

		int importe = 0;
		System.out.println(" Escribir importe: ");

		try {
			importe = Integer.parseInt(leerTecladoTexto());
		} catch (NumberFormatException e) {
			System.err.println("Debes escribir un numero");
		}

		return importe;

	}

	@SuppressWarnings("unchecked")
	public int calcularNumeroDeCuenta() throws IOException {
		Map<Cuenta, List<Movimiento>> cuentas = null;
		try {
			cuentas = (Map<Cuenta, List<Movimiento>>) leerArchivo("banco.cuentas");
		} catch (Exception e1) {
			return 0;
		}
		int salida = 0;
		for (Cuenta cuenta : cuentas.keySet()) {
			if (cuenta.getNumeroCuenta() > salida)
				salida = cuenta.getNumeroCuenta();

		}
		return salida;
	}

	/**
	 * 
	 * @param cuenta
	 */
	public void grabarCuenta(Cuenta cuenta) {

		if (getCuentas() == null)
			setCuentas(new TreeMap<>());
		getCuentas().put(cuenta, new ArrayList<Movimiento>());

		try {
			grabaArchivo("banco.cuentas", getCuentas());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void grabaArchivo(String archivo, Object objetoAGrabar) throws Exception {

		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(objetoAGrabar);
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public Object leerArchivo(String archivo) throws ClassNotFoundException, IOException {

		FileInputStream fileInputStream = new FileInputStream(archivo);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		return objectInputStream.readObject();

	}

	public String leerTecladoTexto() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			return bufferedReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}

	}

	public Map<Cuenta, List<Movimiento>> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Map<Cuenta, List<Movimiento>> cuentas) {
		this.cuentas = cuentas;
	}

}
