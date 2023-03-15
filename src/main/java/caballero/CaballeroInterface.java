package caballero;

import excepciones.SinEspadaException;

public interface CaballeroInterface {

	public void embarcar() throws SinEspadaException;

	public void matarDragon() throws SinEspadaException;

}