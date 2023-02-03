package banco.operaciones;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import banco.cuentas.Cuenta;
import banco.exepciones.SinSaldoExepcion;
import banco.movimientos.Movimiento;

public class CajeroAutomatico {

	public static void main(String[] args) {
		
		Banco banco = new Banco();

		banco.solicitarAcceso();
		/*
		 * try { setCuentasMap((TreeMap<Cuenta, List<Movimiento>>)
		 * leerArchivo("bovedaDeDatos.banco")); } catch (Exception e) { }
		 */
		boolean menuActivo = true;
		while (menuActivo) {
			banco.generarSaltosDeLinea(50);
			banco.generarLogo();
			banco.generarSaltosDeLinea(1);
			Cuenta cuentaSesion = banco.leerSesion("banco.sesion");
			System.out.println(" " + banco.cuentaActual(cuentaSesion));
			System.out.println("	1.- Crear cuenta");
			System.out.println("	2.- Listado Cuentas");
			System.out.println("	3.- Seleccionar cuenta");
			System.out.println("	4.- Ingresar dinero");
			System.out.println("	5.- Sacar dinero");
			System.out.println("	6.- Consultar saldo");
			System.out.println("	7.- Consultar movimientos");
			System.out.println("	8.- Traspaso entre cuentas");
			System.out.println("	9.- Eliminar cuenta");
			System.out.println("	10.- Eliminar todos los datos");
			System.out.println("	11.- Salir");
			System.out.println("_______________________________________");
			int opcion = 0;
			try {
				opcion = Integer.parseInt(banco.leerTecladoTexto());
			} catch (NumberFormatException e) {
			}
			switch (opcion) {
			case 1:// crear cuenta
				banco.generarSaltosDeLinea(50);
				banco.crearCuentaNueva();
				banco.pulsaEnter();
				break;
			case 2:// Listado cuentas
				banco.generarSaltosDeLinea(50);
				banco.listarCuentas();
				banco.pulsaEnter();
				break;
			case 3:// Seleccionar Cuenta
				banco.generarSaltosDeLinea(50);
				Map<Integer, Integer> listado = new TreeMap<Integer, Integer>();
				try {
					Map<Cuenta, List<Movimiento>> cuentas = (TreeMap<Cuenta, List<Movimiento>>) banco.leerArchivo(
							"boveda.banco");
					int i = 1;
					for (Cuenta cuenta : cuentas.keySet()) {
						listado.put(i, cuenta.getNumeroCuenta());
						System.out.print(i + ".- [");
						System.out.print(cuenta.getAlias());
						System.out.print("]	   CCC: ");
						System.out.println(cuenta.getNumeroCuenta());
						i++;
					}
				} catch (Exception e) {
					System.out.println("Aún no has creado ninguna cuenta");
					banco.pulsaEnter();
					break;
				}
				banco.generarSaltosDeLinea(1);
				System.out.print("Selecciona la cuenta para operar: ");
				String cuentaElegida = banco.leerTecladoTexto();
				int i = Integer.parseInt(cuentaElegida);
				Integer c = listado.get(i);
				banco.grabaArchivoSobreescribiendo("banco.sesion", Integer.toString(c));
				break;
			case 4:// Ingresar dinero
				banco.generarSaltosDeLinea(50);
				try {
					banco.operar(cuentaSesion, true);
				} catch (SinSaldoExepcion objExcep) {
					System.out.println(objExcep.getMessage());
				} catch (Exception e) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				break;
			case 5:// Sacar dinero
				banco.generarSaltosDeLinea(50);
				try {
					banco.operar(cuentaSesion, false);
				} catch (SinSaldoExepcion objExcep) {
					System.out.println(objExcep.getMessage());
				} catch (Exception e) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				break;
			case 6:// Consultar saldo
				banco.generarSaltosDeLinea(50);
				try {
					System.out.println("Consulta de la cuenta [" + cuentaSesion.getAlias() + "]");
					banco.generarSaltosDeLinea(1);
					System.out.print("Saldo disponible: ");
					System.out.println(banco.consultarSaldo(cuentaSesion) + "€");
				} catch (Exception e1) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				break;
			case 7:// Consultar movimientos
				banco.generarSaltosDeLinea(50);
				TreeMap<Cuenta, List<Movimiento>> cuentas1 = null;
				try {
					cuentas1 = (TreeMap<Cuenta, List<Movimiento>>) banco.leerArchivo("boveda.banco");
				} catch (ClassNotFoundException e) {

				} catch (IOException e) {

				}
				try {
					List<Movimiento> movimientos = cuentas1.get(cuentaSesion);
					System.out.println("Movimientos de la cuenta [" + cuentaSesion.getAlias() + "]:");
					banco.generarSaltosDeLinea(1);
					System.out.println("  Fecha               Importe	                   Concepto");
					System.out.println("▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
					for (Movimiento movimientoLinea : movimientos) {
						Calendar fecha = movimientoLinea.getFecha();						
						System.out.println(fecha.get(Calendar.DAY_OF_MONTH) + "/"
								+ fecha.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + "/" + fecha.get(Calendar.YEAR)
								+"               " + movimientoLinea.getImporte()
								+ "                     " + movimientoLinea.getConcepto());
					}
				} catch (Exception e) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				banco.generarSaltosDeLinea(50);
				break;
			case 8:// Traspaso entre cuentas
				banco.generarSaltosDeLinea(50);
				try {
					banco.traspaso(cuentaSesion);
				} catch (SinSaldoExepcion objExcep) {
					System.out.println(objExcep.getMessage());
				} catch (Exception e) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				break;
			case 9:// Borrar key de la cuenta
				banco.generarSaltosDeLinea(50);
				try {
					banco.darDeBajaCuenta(cuentaSesion);
				} catch (Exception e) {
					System.out.println("Debes elegir una cuenta para Operar");
				}
				banco.pulsaEnter();
				break;
			case 10:// Borrar datos de los ficheros
				banco.generarSaltosDeLinea(50);
				try {
					banco.borradoGeneral();
				} catch (Exception e) {					
					e.printStackTrace();
				}
				banco.pulsaEnter();
				break;
			case 11:// Salir
				try {
					banco.grabaArchivoVaciarDatos("banco.sesion");
					banco.solicitarAcceso();
				} catch (Exception e) {					
					e.printStackTrace();
				}
				// System.exit(0);
				break;
			default:
				System.err.println("Escribe una opcion valida");
				banco.pulsaEnter();
			}
		}

	}

}
