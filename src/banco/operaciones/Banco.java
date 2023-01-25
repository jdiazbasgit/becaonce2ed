package banco.operaciones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

/**
 * @author RGM
 * @version 1.0
 * @created 23-ene.-2023 14:03:59
 */
public class Banco {

	private Cuenta[] cuentas;

	public Banco() {

	}

	public static void main(String[] args) {

		boolean menuActivo = true;
		while (menuActivo) {
			generarSaltosDeLinea(15);			
			System.out.println("--------------------------------");
			System.out.println("MENU DEL BANCO");
			System.out.println(cuentaActual());
			System.out.println("1.- Crear cuenta");
			System.out.println("2.- Listado Cuentas");
			System.out.println("3.- Seleccionar cuenta");
			System.out.println("4.- Ingresar dinero");
			System.out.println("5.- Sacar dinero");
			System.out.println("6.- Consultar saldo");
			System.out.println("7.- Consultar movimientos");
			System.out.println("8.- Salir");
			System.out.println("9.- Eliminar datos de prueba");
			System.out.println("--------------------------------");
			int opcion = 0;
			try {
				opcion = Integer.parseInt(leerTecladoTexto());
			} catch (NumberFormatException e) {
				System.err.println("Debes escribir un numero");
			}
			switch (opcion) {
			case 1:// crear cuenta
				generarSaltosDeLinea(15);
				System.out.println("Escribe un nombre para la nueva cuenta: ");
				String alias = leerTecladoTexto();
				try {
					int ultimaCuenta = calcularNumeroDeCuenta();
					ultimaCuenta++;
					grabaArchivo("banco.cuentas", ultimaCuenta+";"+alias);
					String nombreFicheroMovimientosAsociado = ultimaCuenta+".movimientos";					
					grabaArchivo(nombreFicheroMovimientosAsociado, fechaActual()+";"+"0");					
					generarSaltosDeLinea(15);
					System.err.println("Se ha creado la cuenta  \""+alias+"\" con número "+ultimaCuenta);					
					generarSaltosDeLinea(2);
					pulsaEnter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:// Listado cuentas
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader= leerArchivo("banco.cuentas");
				try {
					while(bufferedReader.ready()) {
						String linea= bufferedReader.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						String numeroCuenta = stringTokenizer.nextToken();
						String aliasCuenta = stringTokenizer.nextToken();
						System.err.println("Cuenta: "+numeroCuenta+" - alias: "+aliasCuenta+ " -  Saldo disponible: " +consultarSaldo(numeroCuenta));
					}
					pulsaEnter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				catch (NullPointerException e) {
					System.out.println("No hay cuentas activas");
					pulsaEnter();
				}
				break;
			case 3:// Seleccionar Cuenta
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader2= leerArchivo("banco.cuentas");
				try {
					while(bufferedReader2.ready()) {
						String linea= bufferedReader2.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						System.err.println("Cuenta: "+stringTokenizer.nextToken()+" - alias: "+stringTokenizer.nextToken());
					}
					generarSaltosDeLinea(1);
					System.out.println("Selecciona la cuenta para operar: ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String cuentaElegida = leerTecladoTexto();
				grabaArchivoSobreescribiendo("banco.sesion", cuentaElegida);							
				break;
			case 4:// Ingresar dinero
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader3= leerArchivo("banco.sesion");
				try {
					while(bufferedReader3.ready()) {
						String linea= bufferedReader3.readLine();
						String nombreDelArchivo = linea+".movimientos";						
						System.out.println("Escribe el importe a ingresar:");
						String ingreso = leerTecladoTexto();
						grabaArchivo(nombreDelArchivo, fechaActual()+";"+ingreso);
					}					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			case 5:// Sacar dinero
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader31= leerArchivo("banco.sesion");
				try {
					while(bufferedReader31.ready()) {
						String linea= bufferedReader31.readLine();
						String nombreDelArchivo = linea+".movimientos";						
						System.out.println("Escribe el importe a retirar:");
						String ingreso = leerTecladoTexto();
						if (consultarSaldo()>Integer.parseInt(ingreso))							
						grabaArchivo(nombreDelArchivo, fechaActual()+";"+"-"+ingreso);
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
				generarSaltosDeLinea(15);
				BufferedReader bufferedReader6= leerArchivo("banco.sesion");
				try {
					System.out.println("  Fecha              Importe");
					System.out.println("------------------------------");
					while(bufferedReader6.ready()) {
						String linea= bufferedReader6.readLine();
						String nombreDelArchivo = linea+".movimientos";
						BufferedReader bufferedReader7= leerArchivo(nombreDelArchivo);
						try {
							while(bufferedReader7.ready()) {
								String linea2= bufferedReader7.readLine();
								StringTokenizer stringTokenizer= new StringTokenizer(linea2,";");								
								System.err.println(stringTokenizer.nextToken()+"                "+stringTokenizer.nextToken());
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					pulsaEnter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:// Salir
				grabaArchivoVaciarDatos("banco.sesion");
				System.exit(0);
				break;
			case 9:// Borrar datos de los ficheros
				grabaArchivoVaciarDatos("banco.sesion");
				grabaArchivoVaciarDatos("banco.cuentas");
				break;
			default:
				System.err.println("debes escribir una opcion valida");
			}
		}

	}

	private static String fechaActual() {
		Calendar calendario = Calendar.getInstance();
		String fecha = Integer.toString(calendario.get(Calendar.DATE))+"-"+Integer.toString(calendario.get(Calendar.MONTH)+1)+"-"+Integer.toString(calendario.get(Calendar.YEAR));
		return fecha;
	}

	private static void pulsaEnter() {
		try {
			System.out.println("");
			System.out.println("Pulsa Enter...");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	private static void generarSaltosDeLinea(int espacio) {
		for (int i=0; i<espacio; i++) {
			System.out.println("");
		}		
	}

	private static int consultarSaldo() {
		System.out.print("Saldo disponible: ");
		int sumatorioTotal = 0; 
		BufferedReader bufferedReader4= leerArchivo("banco.sesion");
		try {
			while(bufferedReader4.ready()) {
				String linea= bufferedReader4.readLine();
				String nombreDelArchivo = linea+".movimientos";
				BufferedReader bufferedReader7= leerArchivo(nombreDelArchivo);
				try {
					while(bufferedReader7.ready()) {
						String linea2= bufferedReader7.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea2,";");
						stringTokenizer.nextToken();
						String sumatorioStr = stringTokenizer.nextToken();
						int sumatorioInt = Integer.parseInt(sumatorioStr);								
						sumatorioTotal += sumatorioInt;
					}
					System.err.println(sumatorioTotal);
					
				}
			 catch (IOException e) {
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
		//System.out.print("Saldo disponible: ");
		int sumatorioTotal = 0; 
		//BufferedReader bufferedReader4= leerArchivo("banco.sesion");
		try {
			//while(bufferedReader4.ready()) {
				//String linea= bufferedReader4.readLine();
				String nombreDelArchivo = numeroCuenta+".movimientos";
				BufferedReader bufferedReader7= leerArchivo(nombreDelArchivo);
				try {
					while(bufferedReader7.ready()) {
						String linea2= bufferedReader7.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea2,";");
						stringTokenizer.nextToken();
						String sumatorioStr = stringTokenizer.nextToken();
						int sumatorioInt = Integer.parseInt(sumatorioStr);								
						sumatorioTotal += sumatorioInt;
					}
					//System.err.println(sumatorioTotal);
					
				}
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				//}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sumatorioTotal;
	}
	
	private static String cuentaActual() {
		
		BufferedReader bufferedReader= leerArchivo("banco.sesion");
		try {
			while(bufferedReader.ready()) {
				String cuentaActiva= "Bienvenido a su cuenta: " +bufferedReader.readLine();
				return cuentaActiva;
			}
		} catch (Exception e) {
			//System.out.println("Aún no hay cuentas");
			return "**Ninguna Cuenta Seleccionada**";
		}
		
		return "Ninguna Cuenta Seleccionada";
	}

	private static int calcularNumeroDeCuenta() throws IOException {
		BufferedReader bufferedReader = leerArchivo("banco.cuentas");
		if (bufferedReader == null) {
			return 0;
		} else {
			int salida = 0;
			try {
				while (bufferedReader.ready()) {
					String texto = bufferedReader.readLine();
					StringTokenizer stringTokenizer = new StringTokenizer(texto, ";");
					salida = Integer.parseInt(stringTokenizer.nextToken());
				}
				return salida;
			} catch (IOException e) {
				throw e;
			}
		}
	}

	/**
	 * 
	 * @param cuenta
	 */
	public static int consultarSaldo(Cuenta cuenta) {
		return 0;
	}

	public Cuenta[] getCuentas() {
		return cuentas;
	}


	/*public static void grabarCuenta(Cuenta cuenta) {
		String archivoCuenta = Integer.toString(cuenta.getNumeroCuenta())+cuenta.getAlias();
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivoCuenta, true);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
			printWriter.println(cuenta);
			printWriter.println(Integer.toString(cuenta.getNumeroCuenta())+cuenta.getAlias());
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public static void grabaArchivo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
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

	public static BufferedReader leerArchivo(String archivo) {

		try  {
			FileInputStream fileInputStream = new FileInputStream(archivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			return bufferedReader;
		} catch (Exception e) {
			return null;
		}

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

	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}
}// end Banco