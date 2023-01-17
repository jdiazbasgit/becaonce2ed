package concierto;



public class Solista extends Musico {

	public Solista(Instrumento instrumento) {
		super(instrumento);
	}
	
	public void tocar(){
		System.out.println(getInstrumento().sonar());
	}
}