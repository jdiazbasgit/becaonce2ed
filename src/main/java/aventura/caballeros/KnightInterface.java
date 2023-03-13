package aventura.caballeros;

import aventura.excepciones.SinEspadaException;

public interface KnightInterface {
	
	public void embarcar();
	
	public void matarAlDragon() throws SinEspadaException;
	
	public boolean comprobarEspada();

}
