package banco.operaciones;

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
import java.util.TreeMap;
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

public class Banco implements Runnable{

	private static Map<Cuenta, List<Movimiento>> cuentas;

	public Banco() {

	}

	public static void main(String[] args) {

		System.out.println("Autor: LuisFer");
		System.out.println();
		try {
			setCuentas((Map<Cuenta, List<Movimiento>>) leerArchivo("banco.cuentas"));
		} catch (Exception e) {
			
		} 
		while (true) {
			System.out.println();
			System.out.println("MENU DEL BANCO");
			System.out.println("1.- Crear cuenta");
			System.out.println("2.- Listado Cuentas");
			System.out.println("3.- Ingresar dinero");
			System.out.println("4.- Sacar dinero");
			System.out.println("5.- Consultar saldo");
			System.out.println("6.- Consultar movimientos");
			System.out.println("7.- Seleccionar cuenta");
			System.out.println("8.- Salir");
			int opcion = 0;
			try {
				opcion = Integer.parseInt(leerTecladoTexto());
			} catch (NumberFormatException e) {
				System.err.println("Debes escribir un numero");
			}
			switch (opcion) {
			case 1:
				crearCuenta();
				break;
			case 2:
				listarCuentas();
				break;
			case 3:
				ingresarDinero();
				break;
			case 4:
				sacarDinero();
				break;
			case 5:
				consultarSaldo();
				break;
			case 6:
				consultarMovimiento();
				break;
			case 7:
				Cuenta cuentaSeleccionada = seleccionarCuenta();
				System.out.println("Cuenta seleccionada es: " + cuentaSeleccionada.getNumeroCuenta() + ", es de: "
						+ cuentaSeleccionada.getAlias());
				break;
			case 8:
				System.out.println("Fin...");
				System.exit(0);
				break;
			default:
				System.err.println("debes escribir una opcion valida");
			}
		}

	}

	private static void crearCuenta() {

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
	private static void listarCuentas() {
		try {
			Map<Cuenta, List<Movimiento>>cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("banco.cuentas");
			for (Cuenta cuenta : cuentas.keySet()) {
				System.err.println("numero de cuenta:"+cuenta.getNumeroCuenta()+" - alias:"+cuenta.getAlias());
			}
		} catch (Exception e) {
			System.out.println("no existen cuentas");
		} 
	}

	private static void ingresarDinero() {
		Cuenta cuentaElegida = seleccionarCuenta();
		int importe = escribirImporte();
		System.out.println("Importe obtenido es: " + importe);
		Movimiento movimiento = new Movimiento(cuentaElegida, importe);
		getCuentas().get(cuentaElegida).add(movimiento);
		grabaArchivo("banco.cuentas", getCuentas());
	}

	private static void sacarDinero() {
		Cuenta cuentaElegida = seleccionarCuenta();
		int importe = -escribirImporte();
		System.out.println("Importe obtenido es: " + importe);
		Movimiento movimiento = new Movimiento(cuentaElegida, importe);
		movimiento.sacar();

	}

	private static void consultarSaldo() {
		Cuenta cuentaElegida = seleccionarCuenta();
		Movimiento movimiento = new Movimiento(cuentaElegida);
		System.out.println("Saldo consultado es: " + movimiento.calcularTotal());

	}

	private static void consultarMovimiento() {
		Cuenta cuentaElegida = seleccionarCuenta();
		for (Movimiento movimiento : getCuentas().get(cuentaElegida)) {
			
			Calendar a= movimiento.getFecha();
			//System.out.println(a);
			System.out.println(a.get(Calendar.DAY_OF_MONTH)+"/"
					+a.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())+"/"
					+a.get(Calendar.YEAR)+" - "
					+movimiento.getImporte());
		}

	}

	private static Cuenta seleccionarCuenta() {
		listarCuentas();
		System.out.println("indica numero de cuenta:");
		int numeroCuenta=Integer.parseInt(leerTecladoTexto());
		Cuenta cuentaElegida=null;
		for (Cuenta cuenta : getCuentas().keySet()) {
			if(cuenta.getNumeroCuenta()==numeroCuenta)
			{
				cuentaElegida=cuenta;
				break;
			}
			
		}
		return cuentaElegida;
	}

	private static Cuenta obtenerCuentas(int numCuentaElegida) {

		/*
		 * BufferedReader bufferedReader = leerArchivo("banco.cuentas"); int cuentaLeido
		 * = 0; String aliasLeido = null;
		 * 
		 * try { while (bufferedReader.ready() && numCuentaElegida != cuentaLeido) {
		 * String linea = bufferedReader.readLine(); StringTokenizer stringTokenizer =
		 * new StringTokenizer(linea, ";"); cuentaLeido =
		 * Integer.parseInt(stringTokenizer.nextToken()); aliasLeido =
		 * stringTokenizer.nextToken(); } } catch (IOException e) { e.printStackTrace();
		 * }
		 * 
		 * Cuenta cuentaObtenida = new Cuenta(aliasLeido, cuentaLeido); return
		 * cuentaObtenida;
		 */
		return null;
	}

	private static int escribirImporte() {

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
	private static int calcularNumeroDeCuenta() throws IOException {
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
	public static int consultarSaldo(Cuenta cuenta) {
		return 0;
	}

	/**
	 * 
	 * @param cuenta
	 */
	public static void grabarCuenta(Cuenta cuenta) {

		if (getCuentas() == null)
			setCuentas(new TreeMap<>());
		getCuentas().put(cuenta, new ArrayList<Movimiento>());

		grabaArchivo("banco.cuentas", getCuentas());

	}

	public static void grabaArchivo(String archivo, Object objetoAGrabar) {

		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(objetoAGrabar);
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object leerArchivo(String archivo) throws ClassNotFoundException, IOException {

		FileInputStream fileInputStream = new FileInputStream(archivo);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		return objectInputStream.readObject();

	}

	/**
	 * 
	 * @param cuenta,importe,fecha
	 */
	public static void grabarMovimiento(Cuenta cuenta, int importe, Calendar fecha) {

	}

	public static Movimiento[] listadoMovimientos(Cuenta cuenta) {
		return null;
	}

	public static String leerTecladoTexto() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			return bufferedReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}

	}

	public static boolean operar(Cuenta cuenta, int importe) {
		return false;
	}

	public static Map<Cuenta, List<Movimiento>> getCuentas() {
		return cuentas;
	}

	public static void setCuentas(Map<Cuenta, List<Movimiento>> cuentas) {
		Banco.cuentas = cuentas;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}