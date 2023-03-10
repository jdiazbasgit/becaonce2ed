package concierto.instrumentos;

import concierto.exception.SinSonidoException;
import lombok.Data;

@Data
public class Instrumento implements InstrumentoInterface {

	private String sonido;

	public String sonar() throws SinSonidoException {
		if (getSonido().equals("NADA"))
			throw new SinSonidoException();
		return getSonido();
	}

}
