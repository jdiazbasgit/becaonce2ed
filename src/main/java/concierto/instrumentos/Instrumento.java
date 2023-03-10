package concierto.instrumentos;

import lombok.Data;

@Data
public class Instrumento implements InstrumentoInterface {

	private String sonido;
	
	public String sonar() {
		return getSonido();
	}

}
