package aventura.caballeros;

import aventura.excepciones.SinEspadaException;

public interface KnightInterface {
	
	public void embarcar() throws SinEspadaException;
	
	public void matarAlDragon();
		
	public void entregarEspada(boolean x);
	
	public void ajustarSleep(int y);
}
