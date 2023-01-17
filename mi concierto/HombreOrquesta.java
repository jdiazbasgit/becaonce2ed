package concierto;

public class HombreOrquesta extends Musico implements Bailarin {

	public HombreOrquesta(Instrumento[] instrumetos){
		super(instrumetos);
	}

	public void bailar(){

	}

	public void tocar(){
		for (int i = 0; i < getInstrumentos().length; i++) {
			System.out.println(getInstrumentos()[i].sonar());
		}
		
	}
}