package caballero;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import excepciones.SinEspadaException;
import lombok.Data;

@Component
@Data

public class Caballero implements CaballeroInterface {
	@Value("false")
	private boolean espada;

	public void embarcar() throws SinEspadaException {
		matarDragon();
	}

	public void matarDragon() throws SinEspadaException {
		if (!isEspada())
			throw new SinEspadaException();
		System.out.println("Como tengo la picha tiesa \n Voy a rescatar a la princesa");
	}

}