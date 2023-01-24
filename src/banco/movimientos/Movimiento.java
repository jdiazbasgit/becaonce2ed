package banco.movimientos;

import banco.cuentas.Cuenta;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:55
 */
public class Movimiento {

	private Cuenta cuenta;
	private java.util.Calendar fecha;
	private int importe;
	public Cuenta m_Cuenta;

	public Movimiento(){

	}

	public void finalize() throws Throwable {

	}
	public Cuenta getCuenta(){
		return cuenta;
	}

	public java.util.Calendar getFecha(){
		return fecha;
	}

	public int getImporte(){
		return importe;
	}

	/**
	 * 
	 * @param cuenta
	 */
	public void setCuenta(Cuenta cuenta){
		this.cuenta=cuenta;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(java.util.Calendar fecha){
		this.fecha =fecha;
	}

	/**
	 * 
	 * @param importe
	 */
	public void setImporte(int importe){
		this.importe =importe;
	}
}//end Movimiento