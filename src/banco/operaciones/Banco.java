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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

/**
 * @author RGM
 * @created 23-ene.-2023 14:03:59
 * @version 1.1
 */
public class Banco {

	private static TreeMap<Cuenta, List<Movimiento>> cuentasMap;

	public Banco() {

	}

	public static void main(String[] args) {

		//solicitarAcceso();
		try {
			setCuentasMap((TreeMap<Cuenta, List<Movimiento>>) leerArchivo("bovedaDeDatos.banco"));
		} catch (Exception e) {

		}
		boolean menuActivo = true;
		while (menuActivo) {
			generarSaltosDeLinea(15);
			System.out.println("	 ▄▀ ▄▀");
			System.out.println("	  ▀  ▀");
			System.out.println("	█▀▀▀▀▀█▄     _________");
			System.out.println("	█░░░░░█ █    JAVA BANK");
			System.out.println("	▀▄▄▄▄▄▀▀    ▀▀▀▀▀▀▀▀▀▀▀");
			generarSaltosDeLinea(1);
			System.out.println(" " + cuentaActual());
			System.out.println("	1.- Crear cuenta");
			System.out.println("	2.- Listado Cuentas");
			System.out.println("	3.- Seleccionar cuenta");
			System.out.println("	4.- Ingresar dinero");
			System.out.println("	5.- Sacar dinero");
			System.out.println("	6.- Consultar saldo");
			System.out.println("	7.- Consultar movimientos");
			System.out.println("	8.- Salir");
			System.out.println("	9.- Eliminar datos de prueba");
			System.out.println("_______________________________________");
			int opcion = 0;
			Cuenta cuentaSesion = leerSesion("banco.sesion");
			try {
				opcion = Integer.parseInt(leerTecladoTexto());
			} catch (NumberFormatException e) {
				// System.err.println("Debes escribir un numero");
			}
			switch (opcion) {
			case 1:// crear cuenta
				generarSaltosDeLinea(50);
				System.out.println("Escribe un nombre para la nueva cuenta: ");
				String alias = leerTecladoTexto();
				try {
					int ultimaCuenta = calcularNumeroDeCuenta();
					++ultimaCuenta;
					Cuenta cuentaCreada = new Cuenta();
					cuentaCreada.setNumeroCuenta(ultimaCuenta);
					cuentaCreada.setAlias(alias);
					grabarCuenta(cuentaCreada);
					/*
					 * String nombreFicheroMovimientosAsociado = ultimaCuenta+".movimientos";
					 * grabaArchivo(nombreFicheroMovimientosAsociado, fechaActual()+";"+"0");
					 * generarSaltosDeLinea(15);
					 */
					generarSaltosDeLinea(50);
					System.out.println("Se ha creado la cuenta  \"" + alias + "\" con número " + ultimaCuenta);
					generarSaltosDeLinea(2);
					pulsaEnter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:// Listado cuentas
					// System.err.println("Cuenta: "+numeroCuenta+" - alias: "+aliasCuenta+ " -
					// Saldo disponible: " +consultarSaldo(numeroCuenta));
				generarSaltosDeLinea(50);
				try {
					TreeMap<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo(
							"boveda.banco");
					for (Cuenta cuenta : cuentas.keySet()) {
						System.out.print("Nombre de la cuenta: ");
						System.out.print(cuenta.getAlias());
						System.out.print("   CCC: ");
						System.out.print(cuenta.getNumeroCuenta());
						System.out.print("   Saldo disponible: ");
						System.out.println("");
					}
				} catch (Exception e) {
					System.err.println("Aún no has creado ninguna cuenta");
				}
				generarSaltosDeLinea(2);
				pulsaEnter();
				break;
			case 3:// Seleccionar Cuenta
				generarSaltosDeLinea(50);
				try {
					Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo(
							"boveda.banco");
					int i = 1;
					for (Cuenta cuenta : cuentas.keySet()) {
						// System.err.println("Nombre de la cuenta: "+cuenta.getAlias() +" Número:
						// "+cuenta.getNumeroCuenta()+" Saldo disponible: ");
						System.out.print(i+".- ");
						System.out.print(cuenta.getAlias());
						System.out.print("   CCC: ");
						System.out.println(cuenta.getNumeroCuenta());
						i++;
					}
				} catch (Exception e) {
					System.out.println("Aún no has creado ninguna cuenta");
				}
				generarSaltosDeLinea(2);
				System.out.println("Selecciona la cuenta para operar: ");
				String cuentaElegida = leerTecladoTexto();
				grabaArchivoSobreescribiendo("banco.sesion", cuentaElegida);
				break;
			case 4:// Ingresar dinero
				//Cuenta cuentaSesion = leerSesion("banco.sesion");
				System.out.print("Operando en la cuenta ["+cuentaSesion.getAlias()+"]. Escribe el importe a ingresar: ");
				String ingreso = leerTecladoTexto();
				Movimiento movimiento = new Movimiento();
				movimiento.setImporte(Integer.parseInt(ingreso));
				movimiento.setFecha(fechaActual());
				movimiento.setConcepto("InDev");
				TreeMap<Cuenta, List<Movimiento>> cuentas = null;
				try {
					cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				cuentas.get(cuentaSesion).add(movimiento);
				setCuentasMap(cuentas);
				grabarArchivo("boveda.banco", getCuentasMap());
				generarSaltosDeLinea(50);
				break;
			case 5:// Sacar dinero
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader31 = leerArchivoTexto("banco.sesion");
				try {
					while (bufferedReader31.ready()) {
						String linea = bufferedReader31.readLine();
						String nombreDelArchivo = linea + ".movimientos";
						System.out.println("Escribe el importe a retirar:");
						String ingreso1 = leerTecladoTexto();
						if (consultarSaldo() > Integer.parseInt(ingreso1))
							grabarArchivo(nombreDelArchivo, fechaActual() + ";" + "-" + ingreso1);
						else {
							System.err.println("No cuela colega!");
							pulsaEnter();
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:// Consultar saldo
				generarSaltosDeLinea(15);
				consultarSaldo();
				pulsaEnter();
				break;
			case 7:// Consultar movimientos
				generarSaltosDeLinea(50);
				System.out.println("  Fecha              Importe			Concepto");
				System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
				TreeMap<Cuenta, List<Movimiento>> cuentas1 = null;
				try {
					cuentas1 = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Movimiento> movimientos = cuentas1.get(cuentaSesion);		        
		        for (Movimiento movimientoLinea : movimientos) {
		            System.out.println(movimientoLinea.getFecha()+"               "+movimientoLinea.getImporte()+"               ");
		        }
		        pulsaEnter();
				generarSaltosDeLinea(50);							
				break;
			case 8:// Salir
				grabaArchivoVaciarDatos("banco.sesion");
				solicitarAcceso();
				// System.exit(0);
				break;
			case 9:// Borrar datos de los ficheros
				grabaArchivoVaciarDatos("banco.sesion");
				grabaArchivoVaciarDatos("banco.cuentas");
				break;
			default:
				System.err.println("Escribe una opcion valida");
				pulsaEnter();
			}
		}

	}

	private static void solicitarAcceso() {
		int pinMaestro = 666;
		boolean solicitarPin = true;
		while (solicitarPin) {
			generarSaltosDeLinea(50);
			System.out.println("	 ▄▀ ▄▀");
			System.out.println("	  ▀  ▀");
			System.out.println("	█▀▀▀▀▀█▄     _________");
			System.out.println("	█░░░░░█ █    JAVA BANK");
			System.out.println("	▀▄▄▄▄▄▀▀    ▀▀▀▀▀▀▀▀▀▀▀");
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

	private static String fechaActual() {
		Calendar calendario = Calendar.getInstance();
		String fecha = Integer.toString(calendario.get(Calendar.DATE)) + "-"
				+ Integer.toString(calendario.get(Calendar.MONTH) + 1) + "-"
				+ Integer.toString(calendario.get(Calendar.YEAR));
		return fecha;
	}

	private static void pulsaEnter() {
		try {
			System.out.println("");
			System.out.println("Pulsa Enter...");
			System.in.read();
			leerTecladoTexto();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private static void generarSaltosDeLinea(int espacio) {
		for (int i = 0; i < espacio; i++) {
			//System.out.println("");
		}
	}

	private static int consultarSaldo() {
		System.out.print("Saldo disponible: ");
		int sumatorioTotal = 0;
		BufferedReader bufferedReader4 = leerArchivoTexto("banco.sesion");
		try {
			while (bufferedReader4.ready()) {
				String linea = bufferedReader4.readLine();
				String nombreDelArchivo = linea + ".movimientos";
				BufferedReader bufferedReader7 = leerArchivoTexto(nombreDelArchivo);
				try {
					while (bufferedReader7.ready()) {
						String linea2 = bufferedReader7.readLine();
						StringTokenizer stringTokenizer = new StringTokenizer(linea2, ";");
						stringTokenizer.nextToken();
						String sumatorioStr = stringTokenizer.nextToken();
						int sumatorioInt = Integer.parseInt(sumatorioStr);
						sumatorioTotal += sumatorioInt;
					}
					System.err.println(sumatorioTotal);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sumatorioTotal;
	}

	private static int consultarSaldo(String numeroCuenta) {
		// System.out.print("Saldo disponible: ");
		int sumatorioTotal = 0;
		// BufferedReader bufferedReader4= leerArchivo("banco.sesion");
		try {
			// while(bufferedReader4.ready()) {
			// String linea= bufferedReader4.readLine();
			String nombreDelArchivo = numeroCuenta + ".movimientos";
			BufferedReader bufferedReader7 = leerArchivoTexto(nombreDelArchivo);
			try {
				while (bufferedReader7.ready()) {
					String linea2 = bufferedReader7.readLine();
					StringTokenizer stringTokenizer = new StringTokenizer(linea2, ";");
					stringTokenizer.nextToken();
					String sumatorioStr = stringTokenizer.nextToken();
					int sumatorioInt = Integer.parseInt(sumatorioStr);
					sumatorioTotal += sumatorioInt;
				}
				// System.err.println(sumatorioTotal);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// }
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sumatorioTotal;
	}

	private static String cuentaActual() {

		BufferedReader bufferedReader = leerArchivoTexto("banco.sesion");
		try {
			while (bufferedReader.ready()) {
				String cuentaActiva = "Bienvenido a su cuenta: " + bufferedReader.readLine();
				return cuentaActiva;
			}
		} catch (Exception e) {
			// System.out.println("Aún no hay cuentas");
			return "**Ninguna Cuenta Seleccionada**";
		}

		return "Ninguna Cuenta Seleccionada";
	}

	@SuppressWarnings("unchecked")
	private static int calcularNumeroDeCuenta() throws IOException {
		TreeMap<Cuenta, List<Movimiento>> cuentas = null;
		try {
			cuentas = (TreeMap<Cuenta, List<Movimiento>>) leerArchivo("boveda.banco");
			System.out.println("hay cuentas");
		} catch (Exception e1) {
			System.out.println("Aún no hay cuentas");
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

	public static void grabarArchivo(String archivo, Object objetoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(objetoAGrabar);
			objectOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void grabaArchivoSobreescribiendo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void grabaArchivoVaciarDatos(String archivo) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Object leerArchivo(String archivo) throws ClassNotFoundException, IOException {

		FileInputStream fileInputStream = new FileInputStream(archivo);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		// objectInputStream.close();
		return objectInputStream.readObject();

	}

	public static BufferedReader leerArchivoTexto(String archivo) {

		try {
			FileInputStream fileInputStream = new FileInputStream(archivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			return bufferedReader;
		} catch (Exception e) {
			return null;
		}

	}

	private static Cuenta leerSesion(String archivo) {
		BufferedReader bufferedReader = leerArchivoTexto("banco.sesion");
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

	/**
	 * 
	 * @param cuenta,importe,fecha
	 */
	public static void grabarCuenta(Cuenta cuenta) {

		if (getCuentasMap() == null)
			setCuentasMap(new TreeMap<>());
		getCuentasMap().put(cuenta, new ArrayList<Movimiento>());

		grabarArchivo("boveda.banco", getCuentasMap());

	}

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

	public static TreeMap<Cuenta, List<Movimiento>> getCuentasMap() {
		return cuentasMap;
	}

	public static void setCuentasMap(TreeMap<Cuenta, List<Movimiento>> cuentasMap) {
		Banco.cuentasMap = cuentasMap;
	}

}// end Banco