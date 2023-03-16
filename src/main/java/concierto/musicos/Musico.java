package concierto.musicos;

import java.util.List;

<<<<<<< HEAD
import concierto.excepciones.SinSonidoException;
=======
import concierto.exception.SinSonidoException;
>>>>>>> branch 'springCore' of https://github.com/jdiazbasgit/becaonce2ed.git
import concierto.instrumentos.Instrumento;
import lombok.Data;

@Data
public abstract class Musico implements MusicoInterface {

	private Instrumento instrumento;
	
	private List<Instrumento> instrumentos;
	
	@Override
	public abstract void tocar() throws SinSonidoException;

}
