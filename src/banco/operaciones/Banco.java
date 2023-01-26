package banco.operaciones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:59
 */
public class Banco {

	private Cuenta[] cuentas;

	public Banco() {

	}

	public static void main(String[] args) {

		while (true) {
			System.out.println("MENU DEL BANCO DE EDU");
			System.out.println(cuentaNueva());
			System.out.println("1.- Crear cuenta");
			System.out.println("2.- Listado Cuentas");
			System.out.println("3.- Ingresar dinero");
			System.out.println("4.- Sacar dinero");
			System.out.println("5.- Consultar saldo");
			System.out.println("6.- Consultar movimientos");
			System.out.println("7.- Seleccionar cuenta");
			System.out.println("8.- Eliminar cuenta");
			System.out.println("9.- Salir");
			int opcion = 0;
			try {
				opcion = Integer.parseInt(leerTecladoTexto());
			} catch (NumberFormatException e) {
				System.err.println("Debes escribir un numero");
			}
			switch (opcion) {
			case 1:// crear cuenta
				spaceLine(15);
				System.out.println("Nombre para crear cuenta nueva: ");
				String alias = leerTecladoTexto();
				try {
					int ultimaCuenta = calcularNumeroDeCuenta();
					ultimaCuenta++;
					grabaArchivo("banco.cuentas", ultimaCuenta+";"+alias);
					String nombreFicheroMovimientosAsociado = ultimaCuenta+".movimientos";					
					grabaArchivo(nombreFicheroMovimientosAsociado, fechaToday()+";"+"0");					
					spaceLine(15);
					System.err.println("Se ha creado la cuenta  \""+alias+"\" con número "+ultimaCuenta);					
					spaceLine(2);
					grabarCuenBanco();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 2:// Listado cuentas
				spaceLine(10);
				BufferedReader bufferedReader= leerArchivo("banco.cuentas");
				try {
					while(bufferedReader.ready()) {
						String linea= bufferedReader.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						System.err.println("Cuenta:"+stringTokenizer.nextToken()+" - alias:"+stringTokenizer.nextToken());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:// Ingresar dinero
				spaceLine(10);
				BufferedReader bufferedReader3= leerArchivo("banco.lista");
				try {
					while(bufferedReader3.ready()) {
						String linea= bufferedReader3.readLine();
						String nombreDelArchivo = linea+".movimientos";						
						System.out.println("Que cantidad quieres ingresar en tu cuenta:");
						String ingreso = leerTecladoTexto();
						grabaArchivo(nombreDelArchivo, fechaToday()+";"+ingreso);
					}					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			case 4:// Sacar dinero
				spaceLine(10);
				System.out.println("¿Cuantos dineros quieres sacar el dinero? :");
				
				break;
			case 5:// Consultar saldo
				spaceLine(10);
				BufferedReader bufferedReader4= leerArchivo("banco.lista");
				try {
					System.out.print(">>>> TU SALDO <<< ");
					System.out.print("Saldo disponible: ");
					int sumaTotal = 0; 
					while(bufferedReader4.ready()) {
						String linea= bufferedReader4.readLine();
						String nombre = linea+".movimientos";
						BufferedReader bufferedReader7= leerArchivo(nombre);
						try {
							while(bufferedReader7.ready()) {
								String linea2= bufferedReader7.readLine();
								StringTokenizer stringTokenizer= new StringTokenizer(linea2,";");
								String siguiente = stringTokenizer.nextToken();
								String sumaString = stringTokenizer.nextToken();
								int sumaEntero = Integer.parseInt(sumaString);								
								sumaTotal += sumaEntero;
							}
							System.err.println(sumaTotal);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					grabarCuenBanco();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:// Consultar movimientos
				spaceLine(10);
				BufferedReader bufferedReader6= leerArchivo("banco.lista");
				try {
					System.out.println(" | Fecha |             | Importe |");
					System.out.println("---------------------------------");
					while(bufferedReader6.ready()) {
						String linea= bufferedReader6.readLine();
						String nombre = linea+".movimientos";
						BufferedReader bufferedReader7= leerArchivo(nombre);
						try {
							while(bufferedReader7.ready()) {
								String linea2= bufferedReader7.readLine();
								StringTokenizer stringTokenizer= new StringTokenizer(linea2,";");								
								System.err.println(stringTokenizer.nextToken()+"--------------"+stringTokenizer.nextToken());
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					grabarCuenBanco();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:// Seleccionar cuenta
				spaceLine(10);
				BufferedReader bufferedReader2= leerArchivo("banco.cuentas");
				try {
					while(bufferedReader2.ready()) {
						String linea= bufferedReader2.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						System.err.println("Cuenta: "+stringTokenizer.nextToken()+" - alias: "+stringTokenizer.nextToken());
					}
					System.out.println("Elige el numero de cuentas: ");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String numeroCuenta= leerTecladoTexto();
				grabaArchivo("banco.lista", numeroCuenta);							
				break;
			case 8:
				eliminarCuenta("banco.cuentas");
				eliminarCuenta("banco.lista");
				break;
				
			case 9:// Salir
				eliminarCuenta("banco.lista");
				System.exit(0);
				break;
			default:
				System.err.println("debes escribir una opcion valida");
			}
		}

	}

	private static void eliminarCuenta(String archivo) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, false);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void spaceLine(int space) {
		for(int i=0;i<space;i++) {
			System.out.println("");
		}
		
		
	}

	private static void grabarCuenBanco() {
		try {
			spaceLine(5);
			System.out.println("--------------------------------------------");
			System.out.println(">>>Pulsa cualquier tecla para continuar..<<<");
			System.out.println("--------------------------------------------");
			System.in.read();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String fechaToday() {
		Calendar calendario = Calendar.getInstance();
		String fecha = Integer.toString(calendario.get(Calendar.DATE))+"-"+Integer.toString(calendario.get(Calendar.MONTH)+1)+"-"+Integer.toString(calendario.get(Calendar.YEAR));
		return fecha;

	}

	private static int calcularNumeroDeCuenta() throws IOException {
		// TODO Auto-generated method stub
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
	private static String cuentaNueva() {
		
		BufferedReader bufferedReader= leerArchivo("banco.lista");
		try {
			while(bufferedReader.ready()) {
				String cuentaActiva= "Bienvenido a su cuenta: " +bufferedReader.readLine();
				return cuentaActiva;
			}
		} catch (Exception e) {
			//System.out.println("Aún no hay cuentas");
			return "**Null**";
		}
		
		return "No has seleccionado todavía";
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

	/**
	 * 
	 * @param cuenta
	 */
	public static void grabarCuenta(Cuenta cuenta) {

	}

	public static void grabaArchivo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
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
}// Fin