package rescate.caballero;

import java.util.List;

import lombok.Data;

@Data

public abstract class Caballero implements CaballeroInterface {
	private boolean espada;

	public Caballero(boolean espada) {
		this.espada = espada;
	}

	public boolean tieneEspada() {
		return espada;
	}

	public void setEspada(boolean espada) {
		this.espada = espada;
	}
}
