package aventura.caballeros;

import aventura.excepciones.SinEspadaException;

public interface KnightInterface {
	
	public void embarcar() throws SinEspadaException;
	
	public void matarAlDragon();
	
	public boolean comprobarEspada();
	
	public boolean entregarEspada(boolean x);

}
