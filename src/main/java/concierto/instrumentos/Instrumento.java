package concierto.instrumentos;

<<<<<<< HEAD
import concierto.excepciones.SinSonidoException;
=======
import concierto.exception.SinSonidoException;
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
import lombok.Data;

@Data
public class Instrumento implements InstrumentoInterface {

	private String sonido;
<<<<<<< HEAD
	
	public String sonar() throws SinSonidoException {
		
		if(getSonido().equals("nada"))
			throw new SinSonidoException();
		
=======

	public String sonar() throws SinSonidoException {
		if (getSonido().equals("NADA"))
			throw new SinSonidoException();
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
		return getSonido();
	}

}
