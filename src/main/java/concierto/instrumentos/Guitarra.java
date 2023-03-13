package concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Guitarra extends Instrumento {
	
	@Override
	@Value("nada")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}

}
