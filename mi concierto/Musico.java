package concierto;

public abstract class Musico implements MusicoInterface {

	private Instrumento instrumento;
	private Instrumento[] instrumentos;
	
	public Musico() {
		
	}
	
	public Musico(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	public Musico(Instrumento[] instrumentos) {
		this.instrumentos=instrumentos;
	}
	
	public abstract void tocar();

	public Instrumento getInstrumento(){
		return instrumento;
	}

	public Instrumento[] getInstrumentos(){
		return instrumentos;
	}

	public void setInstrumento(Instrumento instrumento){
		this.instrumento = instrumento;
	}

	public void setInstrumentos(Instrumento[] instrumentos){
		this.instrumentos = instrumentos;
	}

}