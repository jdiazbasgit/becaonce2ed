package banco.operaciones;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.Calendar;

import banco.cuentas.Cuenta;
import banco.movimientos.Movimiento;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:59
 */
public class Banco {

	private Cuenta[] cuentas;

	public Banco(){

	}
	
	public static void main(String[] args) {
		
	}
	/**
	 * 
	 * @param cuenta
	 */
	public int consultarSaldo(Cuenta cuenta){
		return 0;
	}

	public Cuenta[] getCuentas(){
		return cuentas;
	}

	/**
	 * 
	 * @param cuenta
	 */
	public void grabarCuenta(Cuenta cuenta){

	}

	public void grabaArchivo(String archivo){
		
	}
	
	public BufferedReader leerArchivo(String archivo) {
		
		return null;
	}
	/**
	 * 
	 * @param cuenta,importe,fecha
	 */
	public void grabarMovimiento(Cuenta cuenta,int importe,Calendar fecha){

	}

	public Movimiento[] listadoMovimientos(Cuenta cuenta){
		return null;
	}
	
	public String leerTeclado() {
		
		return null;
	}

	
	public boolean operar(Cuenta cuenta, int importe){
		return false;
	}

	
	public void setCuentas(Cuenta[] cuentas){
	this.cuentas =cuentas;
	}
}//end Banco