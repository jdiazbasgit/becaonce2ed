package concierto;



public class HombreOrquesta extends Musico {

	public HombreOrquesta(Instrumento[] instrumentos){
		super(instrumentos);

	}

	public void hacerAlgo() {
		
	}
	
	public void tocar(){
		for (int i = 0; i < getInstrumentos().length; i++) {
			System.out.println( getInstrumentos()[i].sonar());
			
		}
		
	}
}