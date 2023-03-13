package concierto.excepcion;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class SinSonidoExcepcion1 extends Exception {

	public SinSonidoExcepcion1() {

	}

	public SinSonidoExcepcion1(String message) {
		super(message);

	}
	
	public SinSonidoExcepcion1( Throwable cause) {
		super(cause);

	}
	
	public SinSonidoExcepcion1(String message, Throwable cause) {
		super(message , cause);

	}
	
	public SinSonidoExcepcion1(String message, Throwable cause, boolean enableSuppression, boolean writablerStacktrace) {

		super(message , cause , enableSuppression, writablerStacktrace);

	}
}
