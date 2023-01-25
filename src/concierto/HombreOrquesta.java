package concierto;

import java.util.Set;

public class HombreOrquesta extends Musico {

	public HombreOrquesta(Set<Instrumento> instrumentos){
		super(instrumentos);

	}

	public void hacerAlgo() {
		
	}
	
	public void tocar(){
		for (Instrumento instrumento : getInstrumentos()) {
			System.out.println(instrumento.sonar()+"  - "+instrumento.hashCode());
		}
		System.out.println("máximo valor:"+Integer.MAX_VALUE);
		System.out.println("mínimo valor:"+Integer.MIN_VALUE);
		System.out.println("máximo valor long:"+Long.MAX_VALUE);
		
	}
}