package concierto;
import java.util.List;

public abstract class Musico implements MusicoInterface {

	private Instrumento instrumento;
	private List<Instrumento> instrumentos;
	
	public Musico(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	public abstract void tocar();
	
	public Instrumento getInstrumento(){
		return instrumento;
	}
	
	public Musico(List<Instrumento> instrumentos) {
		this.instrumentos=instrumentos;
	}

	public void setInstrumento(Instrumento instrumento){
		this.instrumento = instrumento;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	

	
}