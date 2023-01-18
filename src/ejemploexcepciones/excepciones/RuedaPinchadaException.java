/**
 * 
 */
package ejemploexcepciones.excepciones;

/**
 * @
 * @author fjdia
 *	@version 1.0
 *Esta excepcion se disparará cuando el coche no tenaga gasolina
 */
@SuppressWarnings("serial")
public class RuedaPinchadaException extends Exception {

	/**
	 * Este es elk constructor estandar, construye un objeto SinGasolinaException
	 */
	public RuedaPinchadaException() {
	}

	/**
	 * Este constructor construye una excepcion con un mansaje asociado
	 * @param message es el mensaje asociado a la excepcion
	 */
	public RuedaPinchadaException(String message) {
		super(message);
	}

	/**
	 * Este constructor construye una excepcion con un objeto que indica la causa
	 * @param cause es la causa de la excepcion
	 */
	public RuedaPinchadaException(Throwable cause) {
		super(cause);
	}

	/**
	 * Este constructor recibe dos parametros uno es el mansaje y otro la cauusa
	 * @param message es el texto del mensaje
	 * @param cause es la causa del mensaje
	 */
	public RuedaPinchadaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Este constructor recibe 4 parametros que son:
	 * @param message el mensaje asociado a la excepcion
	 * @param cause  la caUSA QUE HA PROVOCADO LA EXCEPCION
	 * @param enableSuppression NO SE QUE ES
	 * @param writableStackTrace Que no muestre la traza de la excepcion
	 */
	public RuedaPinchadaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
