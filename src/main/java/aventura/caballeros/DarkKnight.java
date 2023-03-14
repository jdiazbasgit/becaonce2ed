package aventura.caballeros;

import org.springframework.stereotype.Component;

import aventura.excepciones.SinEspadaException;
import lombok.Data;

@Data
@Component
public class DarkKnight implements KnightInterface{
	
	private boolean espada;

	public void embarcar() throws SinEspadaException {
		if ((!isEspada())) {
			throw new SinEspadaException();
		}
		matarAlDragon();
		
	}

	public void matarAlDragon() {

		System.out.println("El "+this.getClass().getSimpleName()+ " derrotó al temible dragón,\n celebremos su victoria con esta canción");
	}

	public boolean comprobarEspada() {
		return isEspada();
	}
	public boolean entregarEspada(boolean x) {
		setEspada(x);
		return isEspada();
	}

}
