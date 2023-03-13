package concierto.musicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import concierto.exception.SinSonidoException;
import concierto.instrumentos.Instrumento;
import lombok.extern.apachecommons.CommonsLog;

@Component
public class HombreOrquesta extends Musico {

	@Override
	public void tocar() throws SinSonidoException {
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}

	}
	@Override
	@Autowired
	@Qualifier("tocameAMi")
	public void setInstrumentos(List<Instrumento> instrumentos) {
		super.setInstrumentos(instrumentos);
	}

}
