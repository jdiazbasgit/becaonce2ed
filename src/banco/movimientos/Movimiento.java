package banco.movimientos;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	public Movimiento(){

	}

	public Movimiento(Cuenta cuenta, int importe){
		
		Calendar fecha = Calendar.getInstance();

		setCuenta(cuenta);
		setFecha(fecha);
		setImporte( importe);
		
	}

	public void ingresar() {
		grabaArchivo("banco.movimientos", this.cuenta.getNumeroCuenta()+";"+fechaTexto(this.fecha)+";"+this.importe);
	}

	private String fechaTexto(Calendar fecha) {
		
		String fechaTexto = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return fechaTexto;
		
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
		this.cuenta = cuenta;
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