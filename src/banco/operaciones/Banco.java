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
 * @author UsuarioM dav
 * @version 1.0
 * @created 23-ene.-2023 14:03:59
 */
public class Banco {

	private Cuenta[] cuentas;

	public Banco() {

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		while (true) {
			System.out.println("MENU DEL BANCO de David");
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
			case 1:// crear cuenta
				System.out.println("Escribe el alias de la cuenta:");
				String alias = leerTecladoTexto();
				try {
					int ultimaCuenta = calcularNumeroDeCuenta();
					ultimaCuenta++;
					grabaArchivo("banco.cuentas", ultimaCuenta+";"+alias);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:// Listado cuentas
				BufferedReader bufferedReader= leerArchivo("banco.cuentas");
				try {
					while(bufferedReader.ready()) {
						String linea= bufferedReader.readLine();
						StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
						System.err.println("Cuenta:"+stringTokenizer.nextToken()+" - alias:"+stringTokenizer.nextToken());
					}
				} catch (IOException e) {
					e.printStackTrace();
					
				//}catch (nullPointerException) {
				//System.err.println("no hay cuenta");
				}
				break;
			case 3:// Ingresar dinero
				BufferedReader br= leerArchivo("banco.cuentas");
				System.out.println("saldo:  ");
				String alias2 = leerTecladoTexto();
				
				try {
					int ultimaCuenta = calcularNumeroDeCuenta();
					ultimaCuenta++;
					grabaArchivo("banco.cuentas", ultimaCuenta+";"+"alias");
				} catch (IOException e) {
					e.printStackTrace();
				
				}
				Scanner scanner = new Scanner(System.in);
				System.out.println("alias");
				String moviemientojava = scanner.nextLine();
				System.out.println( " + alias" + scanner);
				
				
				break;
			case 4:// Sacar dinero
				break;
			case 5:// Consultar saldo
				break;
			case 6:// Consultar movimientos
				break;
			case 7:// Seleccionar cuenta
				break;
			case 8:// Salir
				System.exit(0);
				break;
			default:
				System.err.println("debes escribir una opcion valida");
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
}// end Banco