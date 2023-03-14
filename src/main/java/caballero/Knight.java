package caballero;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import exception.SinEspadaException;
import lombok.Data;


@Data
@Component
public class Knight implements KnightInterface {
	
	@Value("true")
	private boolean espada;
	
	@Override
	public void embarcar() throws SinEspadaException {
		System.out.println("Voy a rescatar a mi damisela");
		matarDragon();
		
	}

	@Override
	public void matarDragon() throws SinEspadaException {
		if (!isEspada())
			throw new SinEspadaException();
		System.out.println("He matado al Dragón");
		
	
	}

	@Override
	public boolean entregarEspada(boolean x) {
		setEspada(x);
		return isEspada();
	}
			
		
	}
	
	

	
