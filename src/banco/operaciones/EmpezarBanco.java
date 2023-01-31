package banco.operaciones;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.TreeMap;
=======
>>>>>>> 8289f827ad8ea56e282de6cbe46a1cd790c45bd3

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

public class EmpezarBanco {
	public void main(String[] args) {

<<<<<<< HEAD
		Banco banco = new Banco();
		try {
			banco.setCuentas((Map<Cuenta, List<Movimiento>>) leerArchivo("banco.cuentas"));
=======
>>>>>>> 8289f827ad8ea56e282de6cbe46a1cd790c45bd3
=======

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

public class EmpezarBanco {
	public static void main(String[] args) {

>>>>>>> 6762b373d2886dd116ee4d2f030170288644f5de
		Banco banco = new Banco();
		try {
			banco.setCuentas((Map<Cuenta, List<Movimiento>>) banco.leerArchivo("banco.cuentas"));
>>>>>>> 6762b373d2886dd116ee4d2f030170288644f5de
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out.println("7.- Salir");
			int opcion = 0;
			try {
				opcion = Integer.parseInt(banco.leerTecladoTexto());
			} catch (NumberFormatException e) {
				System.err.println("Debes escribir un numero");
			}
			switch (opcion) {
			case 1:
<<<<<<< HEAD
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
=======
				banco.crearCuenta();
>>>>>>> 6762b373d2886dd116ee4d2f030170288644f5de
				break;
			case 2:
				banco.listarCuentas();
				break;
			case 3:
				banco.ingresarDinero();
				break;
			case 4:
				banco.sacarDinero();
				break;
			case 5:
				Cuenta cuenta=banco.seleccionarCuenta();
				System.out.println("el saldo de la cuenta "+cuenta.getAlias()+" es "+banco.consultarSaldo(cuenta));
				break;
			case 6:
				banco.consultarMovimiento();
				break;
			case 7:
				System.out.println("Fin...");
				System.exit(0);
				break;
			default:
				System.err.println("debes escribir una opcion valida");
			}
		}

	}

	private Map<Cuenta, List<Movimiento>> leerArchivo(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String leerTecladoTexto() {
		// TODO Auto-generated method stub
		return null;
	}

}
