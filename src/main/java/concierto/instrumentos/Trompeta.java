package concierto.instrumentos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tocameAMi")
@Scope(value = "prototype")
public class Trompeta extends Instrumento {
	
	@Override
	@Value("nada")
	public void setSonido(String sonido) {
		super.setSonido(sonido);
	}

}
