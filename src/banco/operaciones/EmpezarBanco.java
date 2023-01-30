package banco.operaciones;

import java.util.List;
import java.util.Map;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

public class EmpezarBanco {
	public void main(String[] args) {

		Banco banco = new Banco("Santander");
		try {
			banco.setCuentas((Map<Cuenta, List<Movimiento>>) banco.leerArchivo("banco.cuentas"));
		} catch (Exception e) {

		}
		while (true) {
			System.out.println("Bienvenido al banco "+banco.getNombreDelBanco());
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
				banco.crearCuenta();
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
				Cuenta cuentaSeleccionada = banco.seleccionarCuenta();
				System.out.println("el saldo de la cuenta "+cuentaSeleccionada.getAlias()+" es "+banco.consultarSaldo(cuentaSeleccionada));
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

}
