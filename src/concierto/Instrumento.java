package concierto;

//soy profe

public class Instrumento implements InstrumentoInterface {

	private String sonido;

	public Instrumento(String sonido) {
		//setSonido(sonido);
		this.sonido=sonido;
			
	}
	
	public String sonar(){
		return getSonido();
	}	
	
	public String getSonido(){
		return this.sonido;
	}

	public void setSonido(String sonido){
		this.sonido = sonido;
	}

	
}