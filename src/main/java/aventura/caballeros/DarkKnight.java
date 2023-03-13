package aventura.caballeros;

import org.springframework.stereotype.Component;

import aventura.excepciones.SinEspadaException;
import lombok.Data;

@Data
@Component
public class DarkKnight implements KnightInterface{
	
	private boolean espada;

	public void embarcar() {
				
	}

	public void matarAlDragon() throws SinEspadaException {
		if ((!isEspada())) {
			throw new SinEspadaException();
		}
						
	}

	public boolean comprobarEspada() {
		System.out.println(isEspada());
		return isEspada();
	}

}
