package concierto.instrumentos;

import concierto.excepciones.SinSonidoException;

public interface InstrumentoInterface {

	
	public String sonar() throws SinSonidoException;
}
