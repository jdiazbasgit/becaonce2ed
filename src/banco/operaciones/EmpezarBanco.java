package banco.operaciones;

<<<<<<< HEAD
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
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

public class EmpezarBanco {
	private Map<Cuenta, List<Movimiento>> cuentas;

	public void main(String[] args) {

=======
import java.util.List;
import java.util.Map;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

public class EmpezarBanco {
	public static void main(String[] args) {

>>>>>>> 6762b373d2886dd116ee4d2f030170288644f5de
		Banco banco = new Banco();
		try {
			banco.setCuentas((Map<Cuenta, List<Movimiento>>) banco.leerArchivo("banco.cuentas"));
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
				Cuenta cuenta=banco.seleccionarCuenta();
<<<<<<< HEAD
				banco.consultarSaldo(cuenta);
				System.out.println("El saldo de la cuenta "+cuenta.getAlias()+" es "+banco.consultarSaldo(cuenta));
=======
				System.out.println("el saldo de la cuenta "+cuenta.getAlias()+" es "+banco.consultarSaldo(cuenta));
>>>>>>> 6762b373d2886dd116ee4d2f030170288644f5de
				break;
			case 6:
				banco.consultarMovimiento();
				break;
			case 7:
				System.out.println("Fin...");
				System.exit(0);
				break;
			default:
				System.out.println("debes escribir una opcion valida");
			}
		}
	}

	private void leerArchivo(String string){
		
		
	}}