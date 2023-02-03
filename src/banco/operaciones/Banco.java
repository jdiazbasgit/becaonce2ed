package banco.operaciones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import banco.cuentas.Cuenta;
import banco.exepciones.SinSaldoExepcion;
import banco.movimientos.Movimiento;

/**
 * @author RGM
 * @created 23-ene.-2023 14:03:59
 * @version 1.1
 */
public class Banco {

	public TreeMap<Cuenta, List<Movimiento>> bovedaMapP;

	public Banco() {
	}

	@SuppressWarnings("unchecked")
	public  void listarCuentas() {
		try {
			TreeMap<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo(
					"boveda.banco");
			System.out.println("Listado de Cuentas operativas:");
			generarSaltosDeLinea(1);
			for (Cuenta cuenta : cuentas.keySet()) {
				System.out.print("Nombre de la cuenta: [");
				System.out.print(cuenta.getAlias());
				System.out.print("]	   CCC: ");
				System.out.print(cuenta.getNumeroCuenta());
				System.out.print("	   Saldo disponible: ");
				System.out.println(consultarSaldo(cuenta) + "€");
			}
		} catch (Exception e) {
			System.out.println("Aún no has creado ninguna cuenta");
		}
	}
	public  void borradoGeneral() {
		System.out.println("**Atención**");
		System.out.println("Está a punto de borrar definitivamente todos los datos, esta operación no se puede deshacer");
		System.out.println("¿Desea continuar? (Escribe SI o NO)");
		while (true) {
			String continuar = leerTecladoTexto();
			if (continuar.contentEquals("no") || continuar.contentEquals("n") || continuar.contentEquals("No")
					|| continuar.contentEquals("NO") || continuar.contentEquals("N")) {
				System.out.println("Operación cancelada");
				return;
			}
			if (continuar.contentEquals("si") || continuar.contentEquals("s") || continuar.contentEquals("Si")
					|| continuar.contentEquals("SI") || continuar.contentEquals("S")) {
				grabaArchivoVaciarDatos("banco.sesion");
				grabaArchivoVaciarDatos("banco.traspaso");
				grabaArchivoVaciarDatos("boveda.banco");
				System.out.println("Datos borrados con éxito");
				return;
			}
			System.out.println("Debes responder SI o NO");
		}
	}

	public  void darDeBajaCuenta(Cuenta cuentaSesion) throws IOException, ClassNotFoundException {
		System.out.println("**Atención**");
		@SuppressWarnings("unchecked")
		Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
		if (cuentas.size() < 2) {
			System.out.println("Necesitas al menos otra cuenta donde Traspasar los fondos");
			return;
		}
		System.out.println("Está a punto de borrar definitivamente la cuenta [" + cuentaSesion.getAlias()
				+ "]. El saldo será Traspasado a otra cuenta");
		System.out.println("¿Desea continuar? (Escribe S o N)");
		String continuar = leerTecladoTexto();
		if (continuar.contentEquals("no") || continuar.contentEquals("n") || continuar.contentEquals("No")
				|| continuar.contentEquals("NO") || continuar.contentEquals("N")) {
			System.out.println("Operación cancelada");
			return;
		}
		generarSaltosDeLinea(50);
		System.out.println(
				"La cuenta [" + cuentaSesion.getAlias() + "] tiene un saldo de " + consultarSaldo(cuentaSesion) + "€");
		System.out.println("Selecciona la cuenta de destino donde Traspasar el saldo:");
		Map<Integer, Integer> listado = new TreeMap<Integer, Integer>();
		try {			
			int i = 1;
			for (Cuenta cuenta : cuentas.keySet()) {
				if (cuentaSesion.getNumeroCuenta() == cuenta.getNumeroCuenta())
					continue;
				listado.put(i, cuenta.getNumeroCuenta());
				System.out.print(i + ".- [");
				System.out.print(cuenta.getAlias());
				System.out.print("]   CCC: ");
				System.out.println(cuenta.getNumeroCuenta());
				i++;
			}
		} catch (Exception e) {
			// System.out.println("Aún no has creado ninguna cuenta");
		}
		String cuentaDestino = leerTecladoTexto();
		int i = Integer.parseInt(cuentaDestino);
		Integer c = listado.get(i);
		grabaArchivoSobreescribiendo("banco.traspaso", Integer.toString(c));
		Cuenta cuentaDestinoC = leerSesion("banco.traspaso");
		String conceptoD = "Traspaso desde [" + cuentaSesion.getAlias() + "]";
		grabarMovimiento(cuentaDestinoC, Integer.toString(consultarSaldo(cuentaSesion)), conceptoD);
		System.out.println("Traspaso a favor: " + consultarSaldo(cuentaSesion) + "€ registrado en ["
				+ cuentaDestinoC.getAlias() + "]. Saldo disponible: " + consultarSaldo(cuentaDestinoC) + "€");		
		try {			
			cuentas.remove(cuentaSesion);
			grabarArchivo("boveda.banco", cuentas);			
		} catch (Exception e) {
			// System.out.println("Aún no has creado ninguna cuenta");
		}
	}

	public  void traspaso(Cuenta cuentaSesion) throws SinSaldoExepcion, ClassNotFoundException, IOException {
		@SuppressWarnings("unchecked")
		Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
		if (cuentas.size() < 2) {
			System.out.println("**ATENCION**\n Necesitas al menos otra cuenta donde Traspasar los fondos");
			return;
		}
		System.out.print("Operando en la cuenta [" + cuentaSesion.getAlias() + "]. Escribe el importe a retirar: ");
		String ingreso = leerTecladoTexto();
		if (consultarSaldo(leerSesion("banco.sesion")) < Integer.parseInt(ingreso)) {
			System.out.println("Disponible: " + consultarSaldo(cuentaSesion));
			throw new SinSaldoExepcion("Saldo insuficiente");
		}
		System.out.println("Selecciona la cuenta de destino: ");
		Map<Integer, Integer> listado = new TreeMap<Integer, Integer>();
		try {
			//Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
			int i = 1;
			for (Cuenta cuenta : cuentas.keySet()) {
				if (cuentaSesion.getNumeroCuenta() == cuenta.getNumeroCuenta())
					continue;
				listado.put(i, cuenta.getNumeroCuenta());
				System.out.print(i + ".- [");
				System.out.print(cuenta.getAlias());
				System.out.print("]   CCC: ");
				System.out.println(cuenta.getNumeroCuenta());
				i++;
			}
		} catch (Exception e) {
			// System.out.println("Aún no has creado ninguna cuenta");
		}
		String cuentaDestino = leerTecladoTexto();
		int i = Integer.parseInt(cuentaDestino);
		Integer c = listado.get(i);
		grabaArchivoSobreescribiendo("banco.traspaso", Integer.toString(c));
		Cuenta cuentaDestinoC = leerSesion("banco.traspaso");
		String conceptoD = "Traspaso desde [" + cuentaSesion.getAlias() + "]";
		String concepto = "Traspaso destino [" + cuentaDestinoC.getAlias() + "]";
		grabarMovimiento(cuentaDestinoC, ingreso, conceptoD);
		System.out.println("Traspaso a favor: " + ingreso + "€ registrado en [" + cuentaDestinoC.getAlias()
				+ "]. Saldo disponible: " + consultarSaldo(cuentaDestinoC) + "€");
		ingreso = "-" + ingreso;
		grabarMovimiento(cuentaSesion, ingreso, concepto);
		System.out.println("Retirado " + ingreso + "€ desde [" + cuentaSesion.getAlias() + "]. Saldo disponible: "
				+ consultarSaldo(cuentaSesion) + "€");
	}

	public  void operar(Cuenta cuentaSesion, boolean positivo) throws SinSaldoExepcion {
		if (positivo) {
			System.out
					.print("Operando en la cuenta [" + cuentaSesion.getAlias() + "]. Escribe el importe a ingresar: ");
		} else {
			System.out.print("Operando en la cuenta [" + cuentaSesion.getAlias() + "]. Saldo disponible: "
					+ consultarSaldo(cuentaSesion) + "€. Escribe el importe a retirar: ");
		}
		String ingreso = leerTecladoTexto();

		if (consultarSaldo(leerSesion("banco.sesion")) < Integer.parseInt(ingreso) && !positivo) {
			System.out.println("Disponible: " + consultarSaldo(cuentaSesion));
			throw new SinSaldoExepcion("Saldo insuficiente");
		}
		if (!positivo) {
			ingreso = "-" + ingreso;
		}
		System.out.print("Escribe el concepto: ");
		String concepto = leerTecladoTexto();
		grabarMovimiento(cuentaSesion, ingreso, concepto);

		if (positivo) {
			System.out.println("Ingreso " + ingreso + ". Saldo disponible: " + consultarSaldo(cuentaSesion) + "€");
		} else {
			System.out.println("Retirado " + ingreso + ". Saldo disponible: " + consultarSaldo(cuentaSesion) + "€");
		}
	}

	@SuppressWarnings("unchecked")
	public  void grabarMovimiento(Cuenta cuentaS, String ingreso, String concepto) {
		Movimiento movimiento = new Movimiento();
		movimiento.setImporte(Integer.parseInt(ingreso));
		movimiento.setFecha(fechaActual());		
		movimiento.setConcepto(concepto);
		TreeMap<Cuenta, List<Movimiento>> cuentas = null;
		try {
			cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		cuentas.get(cuentaS).add(movimiento);
		setBovedaMapP(cuentas);
		grabarArchivo("boveda.banco", getBovedaMapP());
	}

	public  void generarLogo() {
		System.out.println("	 ▄▀ ▄▀");
		System.out.println("	  ▀  ▀");
		System.out.println("	█▀▀▀▀▀█▄     _________");
		System.out.println("	█░░░░░█ █    JAVA BANK");
		System.out.println("	▀▄▄▄▄▄▀▀    ▀▀▀▀▀▀▀▀▀▀▀");
	}

	public  void solicitarAcceso() {
		int pinMaestro = 666;
		boolean solicitarPin = true;
		while (solicitarPin) {
			generarSaltosDeLinea(50);
			generarLogo();
			generarSaltosDeLinea(1);
			System.out.println("	Powered by RGM Solutions™");
			generarSaltosDeLinea(2);
			System.out.print("  Introduce PIN de acceso: ");
			int pin = 0;
			try {
				pin = Integer.parseInt(leerTecladoTexto());
				if (pin == pinMaestro) {
					solicitarPin = false;
					generarSaltosDeLinea(50);
				} else {
					System.err.println("Número incorrecto");
					pulsaEnter();
				}
			} catch (NumberFormatException e) {
				generarSaltosDeLinea(1);
				System.err.println("Debes introducir dígitos");
				pulsaEnter();
			}
		}
	}

	/*public  String fechaActual() {
		Calendar calendario = Calendar.getInstance();
		String fecha = Integer.toString(calendario.get(Calendar.DATE)) + "-"
				+ Integer.toString(calendario.get(Calendar.MONTH) + 1) + "-"
				+ Integer.toString(calendario.get(Calendar.YEAR));
		return fecha;
	}*/
	
	public  Calendar fechaActual() {
		Calendar calendario = new GregorianCalendar();
		return calendario;
	}

	public  void pulsaEnter() {
		try {
			System.out.println("");
			System.out.println("Pulsa Enter...");
			System.in.read();
			leerTecladoTexto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  void generarSaltosDeLinea(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.println("");
		}
	}

	@SuppressWarnings("unchecked")
	public  int consultarSaldo(Cuenta cuentaConsultada) {
		// System.out.print("Saldo disponible: ");
		int sumatorioTotal = 0;
		TreeMap<Cuenta, List<Movimiento>> cuentas = null;
		try {
			cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		// Cuenta cuentaSesion = leerSesion("banco.sesion");
		List<Movimiento> movimientos = cuentas.get(cuentaConsultada);
		for (Movimiento movimientoLinea : movimientos) {
			int sumatorioInt = movimientoLinea.getImporte();
			sumatorioTotal += sumatorioInt;
		}
		// System.out.println(sumatorioTotal);
		return sumatorioTotal;
	}

	@SuppressWarnings("unchecked")
	public  String cuentaActual(Cuenta cuentaSesion) {

		TreeMap<Cuenta, List<Movimiento>> cuentas = null;
		try {
			cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
			if (cuentas.isEmpty()) {
				grabaArchivoVaciarDatos("boveda.banco");
				return "**ATENCION: No se ha podido acceder a la Bóveda**\n \t Continuar creará una nueva bbdd local \n";
				// El Map existe pero está vacio, limpiamos el archivo para que las demás
				// opciones no muestren un listado vacio
			}
		} catch (Exception e1) {
			return "**ATENCION: No se ha podido acceder a la Bóveda**\n \t Continuar creará una nueva bbdd local \n";
			// exista o no el archivo, no hay Map
		}
		cuentas = null;// llamo al gc???
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = leerArchivoTexto("banco.sesion");
			while (bufferedReader.ready()) {
				String cuentaActiva = "Operando en la cuenta: " + bufferedReader.readLine() + " ["
						+ cuentaSesion.getAlias() + "]";
				return cuentaActiva;
			}
		} catch (NullPointerException | IOException e) {
			return "**Ninguna Cuenta Seleccionada**";// hay datos pero de otra cuenta que ya no existe
		}
		return "**Ninguna Cuenta Seleccionada**";// no entra al while porque el archivo está en blanco
	}

	@SuppressWarnings("unchecked")
	public  int calcularNumeroDeCuentaAleatorio() throws IOException {
		TreeMap<Cuenta, List<Movimiento>> cuentas = null;
		int salida = 0;
		try {
			cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
		} catch (Exception e1) {
			return sacarRandoms(100000000, 999999999);
		}
		boolean loop = true;
		while (loop) {
			salida = sacarRandoms(100000000, 999999999);
			boolean usado = false;
			for (Cuenta cuenta : cuentas.keySet()) {
				if (cuenta.getNumeroCuenta() == salida) {
					usado = true;
					break;
				}
			}
			if (!usado) {
				return salida;
			}
		}
		return salida;
	}

	public  int sacarRandoms(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min) + min);
	}

	public  void grabarArchivo(String archivo, Object objetoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(objetoAGrabar);
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void grabaArchivoSobreescribiendo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  void grabaArchivoVaciarDatos(String archivo) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  Object leerArchivo(String archivo) throws ClassNotFoundException, IOException {

		FileInputStream fileInputStream = new FileInputStream(archivo);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			// objectInputStream.close();
			return objectInputStream.readObject();
		}

	}

	public  BufferedReader leerArchivoTexto(String archivo) {

		try {
			FileInputStream fileInputStream = new FileInputStream(archivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			return bufferedReader;
		} catch (Exception e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public  Cuenta leerSesion(String archivo) {
		BufferedReader bufferedReader = leerArchivoTexto(archivo);
		Cuenta cuentaElegida = null;
		Map<Cuenta, List<Movimiento>> cuentas = null;
		try {
			try {
				cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
				while (bufferedReader.ready()) {
					String linea = bufferedReader.readLine();
					int numeroCuenta = Integer.parseInt(linea);
					for (Cuenta cuenta : cuentas.keySet()) {
						if (cuenta.getNumeroCuenta() == numeroCuenta) {
							cuentaElegida = cuenta;
							break;
						}
					}
				}
			} catch (ClassNotFoundException e) {

			}

		} catch (NumberFormatException e) {
		} catch (Exception e) {
		}
		return cuentaElegida;
	}

	public void crearCuentaNueva(){
		System.out.print("Escribe un nombre para la nueva cuenta: ");
		String alias = leerTecladoTexto();
		try {
			int ultimaCuenta = calcularNumeroDeCuentaAleatorio();
			Cuenta cuentaCreada = new Cuenta();
			cuentaCreada.setNumeroCuenta(ultimaCuenta);
			cuentaCreada.setAlias(alias);
			grabarCuenta(cuentaCreada);
			generarSaltosDeLinea(50);
			System.out.println("Se ha creado la cuenta  [" + alias + "] con número " + ultimaCuenta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void grabarCuenta(Cuenta cuenta) {

		if (getBovedaMapP() == null)
			setBovedaMapP(new TreeMap<>());
		getBovedaMapP().put(cuenta, new ArrayList<Movimiento>());

		grabarArchivo("boveda.banco", getBovedaMapP());
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

	public  TreeMap<Cuenta, List<Movimiento>> getBovedaMapP() {
		return bovedaMapP;
	}

	public  void setBovedaMapP(TreeMap<Cuenta, List<Movimiento>> boveda) {
		this.bovedaMapP = boveda;
	}

}// end Banco

/*
 * @SuppressWarnings("unchecked") public  int
 * calcularNumeroDeCuentaSecuencial() throws IOException { TreeMap<Cuenta,
 * List<Movimiento>> cuentas = null; try { cuentas = (TreeMap<Cuenta,
 * List<Movimiento>>) leerArchivo("boveda.banco"); } catch (Exception e1) { //
 * System.out.println("Aún no hay cuentas"); return 0; } int salida = 0; for
 * (Cuenta cuenta : cuentas.keySet()) { if (cuenta.getNumeroCuenta() > salida)
 * salida = cuenta.getNumeroCuenta();
 * 
 * } return salida; }
 */

/*
 * public  Movimiento[] listadoMovimientos(Cuenta cuenta) { return null; }
 */

/*
 * public  int consultarSaldoS(String numeroCuenta) { //
 * System.out.print("Saldo disponible: "); int sumatorioTotal = 0; //
 * BufferedReader bufferedReader4= leerArchivo("banco.sesion"); try { //
 * while(bufferedReader4.ready()) { // String linea= bufferedReader4.readLine();
 * String nombreDelArchivo = numeroCuenta + ".movimientos"; BufferedReader
 * bufferedReader7 = leerArchivoTexto(nombreDelArchivo); try { while
 * (bufferedReader7.ready()) { String linea2 = bufferedReader7.readLine();
 * StringTokenizer stringTokenizer = new StringTokenizer(linea2, ";");
 * stringTokenizer.nextToken(); String sumatorioStr =
 * stringTokenizer.nextToken(); int sumatorioInt =
 * Integer.parseInt(sumatorioStr); sumatorioTotal += sumatorioInt; } //
 * System.err.println(sumatorioTotal); * 
 * } catch (IOException e) { 
 * e.printStackTrace(); } // } } catch (NumberFormatException e) {
 *  e.printStackTrace(); } return sumatorioTotal; }
 */