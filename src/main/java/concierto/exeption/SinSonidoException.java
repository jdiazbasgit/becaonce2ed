package concierto.exeption;

public class SinSonidoException extends Exception {
	public SinSonidoException() {
		
	}
	public SinSonidoException(String message) {
		super(message);
	}
	public SinSonidoException(Throwable cause) {
		super(cause);
	}
	public SinSonidoException(String message, Throwable cause) {
		super(message, cause);
	}
	public SinSonidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
