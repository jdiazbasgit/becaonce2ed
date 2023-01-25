package concierto;
import java.util.Set;

public abstract class Musico implements MusicoInterface {

	private Instrumento instrumento;
	private Set<Instrumento> instrumentos;
	
	public Musico(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	public abstract void tocar();
	
	public Instrumento getInstrumento(){
		return instrumento;
	}
	
	public Musico(Set<Instrumento> instrumentos) {
		this.instrumentos=instrumentos;
	}

	public void setInstrumento(Instrumento instrumento){
		this.instrumento = instrumento;
	}

	public Set<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(Set<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	

	
}