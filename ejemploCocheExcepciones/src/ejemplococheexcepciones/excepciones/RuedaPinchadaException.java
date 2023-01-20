/**
 * 
 */
package ejemplococheexcepciones.excepciones;

/**
 * @author UsuarioM
 * @version 1.0
 * Esta excepción se disparará cuando mi coche no tengsa gasolina
 */
public class RuedaPinchadaException extends Exception {

	/**
	 * Este es el contructor estandar, contruye un objeto SinGasolinaException
	 */
	public RuedaPinchadaException() {
	}

	/**
	 * Este constructor construye una excepcion con un mensaje asociado
	 * @param es el mensaje asociado a la excepción
	 */
	public RuedaPinchadaException(String message) {
		super(message);
	}

	/**
	 * Este constructor construye una excepcion con la causa
	 * @param cause es la causa de la excepción
	 */
	public RuedaPinchadaException(Throwable cause) {
		super(cause);
	}

	/**
	 * Este constructor construye una excepción con 2 parámetros, un objeto que indica mensaje y la causa
	 * @param message mensaje de la causa
	 * @param cause es la causa de la excepción
	 */
	public RuedaPinchadaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Este constructor recibe cuatro parámetros que son:
	 * @param message el mensaje asociado a la excepción
	 * @param cause la causa que ha provocado la excepción
	 * @param enableSuppression no se que es, boolean
	 * @param writableStackTrace un boooleado, muestra o no la excepción en consola
	 */
	public RuedaPinchadaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
