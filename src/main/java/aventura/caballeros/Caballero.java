package aventura.caballeros;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import aventura.excepciones.SinEspadaException;
import lombok.Data;

@Data
@Component

public class Caballero implements CaballeroInterface{
	@Value("true")
	private boolean espada;

	public void embarcar() throws SinEspadaException {
		if ((!isEspada())) {
			throw new SinEspadaException(null);
		}
		matarAlDragon();
		
	}

	public void matarAlDragon() {

		System.out.println("El "+this.getClass().getSimpleName()+ " derrotó al temible dragón,\n celebremos la victoria con unos cuantos barriles de cerveza Mahou");
	}

	public boolean comprobarEspada() {
		return isEspada();
	}
	public boolean entregarEspada(boolean x) {
		setEspada(x);
		return isEspada();
	}
}
