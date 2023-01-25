package concierto;

import java.util.List;

public class HombreOrquesta extends Musico {

	public HombreOrquesta(List<Instrumento> instrumentos){
		super(instrumentos);

	}

	public void hacerAlgo() {
		
	}
	
	public void tocar(){
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar());
		}
		
	}
}