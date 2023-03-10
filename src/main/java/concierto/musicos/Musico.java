package concierto.musicos;

import java.util.List;

import concierto.instrumentos.Instrumento;
import lombok.Data;

@Data
public abstract class Musico implements MusicoInterface {

	private Instrumento instrumento;
	
	private List<Instrumento> instrumentos;
	
	@Override
	public abstract void tocar();

}
