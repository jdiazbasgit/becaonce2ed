package concierto.instrumentos;

import concierto.excepciones.SinSonidoException;
import lombok.Data;

@Data
public class Instrumento implements InstrumentoInterface {

	private String sonido;
	
	public String sonar() throws SinSonidoException {
		
		if(getSonido().equals("nada"))
			throw new SinSonidoException();
		
		
		
		return getSonido();
	}

}
