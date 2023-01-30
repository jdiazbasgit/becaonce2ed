package banco.movimientos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;

import banco.cuentas.Cuenta;

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


<<<<<<< HEAD
		setCuenta(cuenta);
		setFecha(fecha);
		setImporte(importe);
		
	}

	public void ingresar() {
		grabaArchivo("banco.movimientos", this.cuenta.getNumeroCuenta()+";"+fechaTexto(this.fecha)+";"+this.importe);
	}

	public void sacar() {
		int importeTotal = calcularTotal();
		if (-this.importe <= importeTotal) {
			grabaArchivo("banco.movimientos", this.cuenta.getNumeroCuenta()+";"+fechaTexto(this.fecha)+";"+this.importe);
		} else {
			System.out.println("No podemos sacar tu importe");
		}
		
	}

	public int calcularTotal() {

		BufferedReader bufferedReader= leerArchivo("banco.movimientos");
		int cuentaLeido=0;
		int importeLeido=0;
		int importeTotal=0;

		
		return importeTotal;

	}
	
	public void consultar() {

		BufferedReader bufferedReader= leerArchivo("banco.movimientos");
		int cuentaLeido=0;
		String fechaLeido=null;
		int importeLeido=0;
		int importeTotal=0;

		try {
			while(bufferedReader.ready()) {
				String linea= bufferedReader.readLine();
				StringTokenizer stringTokenizer= new StringTokenizer(linea,";");
				cuentaLeido = Integer.parseInt(stringTokenizer.nextToken());
				fechaLeido = stringTokenizer.nextToken();
				importeLeido = Integer.parseInt(stringTokenizer.nextToken());
				if (cuentaLeido == this.cuenta.getNumeroCuenta()) {
					importeTotal += importeLeido;
					System.out.println(" - fechaLeido: "+fechaLeido+" - importeLeido: "+importeLeido+" - importeAcumulado: "+importeTotal);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String fechaTexto(Calendar fecha) {
		
		String fechaTexto = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return fechaTexto;
		
	}
	
	public static BufferedReader leerArchivo(String archivo) {

		try {
			FileInputStream fileInputStream = new FileInputStream(archivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			return bufferedReader;
		} catch (Exception e) {
			return null;
		}

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
=======
>>>>>>> branch 'bancoMap' of https://github.com/jdiazbasgit/becaonce2ed.git

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