package banco.movimientos;

import java.io.Serializable;
import java.util.Calendar;


/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:55
 */

public class Movimiento implements Serializable{

	
	private java.util.Calendar fecha;
	private int importe;

	public Movimiento(){

	}



	public Movimiento(Calendar fecha, int importe) {
		super();
		this.fecha = fecha;
		this.importe = importe;
	}



	

	public java.util.Calendar getFecha(){
		return fecha;
	}

	public int getImporte(){
		return importe;
	}
	
	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(java.util.Calendar fecha){
		this.fecha = fecha;
	}

	/**
	 * 
	 * @param importe
	 */
	public void setImporte(int importe){
		this.importe = importe;
	}

}