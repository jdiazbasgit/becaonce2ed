package banco.operaciones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;


public class Banco {

	private Cuenta[] cuentas;

	public Banco() {

	}
	
	public static void main(String[] args) {
		String alias="";
		int ultimaCuenta = 0;
		BufferedReader bufferedReader=null;
		
		System.out.println("MENU DEL BANCO");
		System.out.println("1.- Crear cuenta");
		System.out.println("2.- Listado Cuentas");
		System.out.println("3.- Ingresar dinero");
		System.out.println("4.- Sacar dinero");
		System.out.println("5.- Consultar saldo");
		System.out.println("6.- Consultar movimientos");
		System.out.println("7.- Seleccionar cuenta");
		System.out.println("8.- Salir");
		System.out.println("Por favor, escribe un numero:");
		
		while (true) {
			int opcion = 0;
			try {
				opcion = Integer.parseInt(leerTecladoTexto());
			} catch (NumberFormatException e) {
				System.err.println("Debes escribir un numero");
			}
			
			switch (opcion) {				
			case 1:// crear cuenta
				System.out.println("Escribe el alias de la cuenta:");
				try {
					alias = leerTecladoTexto();
					ultimaCuenta = calcularNumeroDeCuenta();
					ultimaCuenta++;
					grabaArchivo("banco.cuentas", ultimaCuenta+";"+alias);
					System.out.println("Por favor, escribe un numero:");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			case 2:// Listado cuentas
				bufferedReader = leerArchivo("banco.cuentas");
				int count =0;
				
				try {
					while(bufferedReader.ready()) {
						String linea= bufferedReader.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						System.out.println("Cuenta:"+stringTokenizer.nextToken()+" - alias:"+stringTokenizer.nextToken());
						count++;
					}
					
					if(count>0) {
						System.out.println("Escribe un numero de la cuenta:");
						ultimaCuenta = Integer.parseInt(leerTecladoTexto());
						System.out.println("Por favor, escribe un numero:");
					} else {
						System.err.println("No hay registros de la cuenta");
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}catch (NullPointerException e) {
					System.err.println("Archivo cuentas no encontrado");
				}
				
				break;
				
			case 3:// Ingresar dinero
				int ingresos = 0;
				int retiradas = 0;
				int saldo = 0;
				
				String fecha="";
				Date myDate = new Date();
				fecha = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss").format(myDate);
				
				try {
					System.out.println("Por favor, escribe el importe:");
					ingresos = Integer.parseInt(leerTecladoTexto());
					grabarMovimiento("banco.movimiento", ultimaCuenta, alias, Integer.toString(ingresos), Integer.toString(retiradas), Integer.toString(saldo), fecha);
					System.out.println("Por favor, escribe un numero:"); 
					
				} catch (NumberFormatException e) {
					System.err.println("Debes escribir un numero");
				}
				
				break;
			case 4:// Sacar dinero
				
				break;
			case 5:// Consultar saldo
				bufferedReader= leerArchivo("banco.movimiento");
				String scuenta=""; 
				String salias="";
				String sfecha="";
				String singresos="";
				String sretiradas="";
				int stotal=0;
				
				try {
					while(bufferedReader.ready()) {
						String linea= bufferedReader.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						scuenta=stringTokenizer.nextToken();
						if(Integer.valueOf(scuenta)==ultimaCuenta) {
							salias=stringTokenizer.nextToken();
							sfecha=stringTokenizer.nextToken();
							singresos=stringTokenizer.nextToken();
							sretiradas=stringTokenizer.nextToken();
							stotal=stotal+Integer.valueOf(singresos);
							stotal=stotal-Integer.valueOf(sretiradas);
							
							if(scuenta.length()>0) {
								System.out.println("Cuenta: "+scuenta+" alias: "+salias+" fecha: "+sfecha+" ingresos:"+singresos+" retiradas:"+sretiradas+" saldo:"+stotal+"€");
							}
						}
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				break;
			case 6:// Consultar movimientos
				
				break;
			case 7:// Seleccionar cuenta
				
				break;
			case 8:// Salir
				System.exit(0);
				break;
			default:
				System.err.println("Por favor, escribe una opcion valida");
			
			}			
		}
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

	/**
	 * 
	 * @param cuenta
	 */
	public static void grabarCuenta(Cuenta cuenta) {

	}

	/**
	 * 
	 * @param archivo,texto
	 */
	public static void grabaArchivo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param archivo
	 */
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
	 * @param archivo, cuenta, alias, ingresos, retiradas, saldo, fecha
	 */
	public static void grabarMovimiento(String archivo, int cuenta, String alias, String ingresos, String retiradas, String saldo, String fecha) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(cuenta+";"+alias+";"+fecha+";"+ingresos+";"+retiradas+";"+saldo);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
