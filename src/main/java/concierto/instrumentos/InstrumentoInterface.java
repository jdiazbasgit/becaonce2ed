package concierto.instrumentos;

import concierto.exception.SinSonidoException;

public interface InstrumentoInterface {

	
	public String sonar() throws SinSonidoException;
}
