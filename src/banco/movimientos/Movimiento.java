package banco.movimientos;

import java.io.Serializable;

/**
 * @author UsuarioM
 * @version 1.0
 * @created 23-ene.-2023 14:03:55
 */
@SuppressWarnings("serial")
public class Movimiento implements Serializable {

	private String fecha;
	private int importe;
	private String concepto;
	
	public Movimiento(){
	}
	
	
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

}//end Movimiento