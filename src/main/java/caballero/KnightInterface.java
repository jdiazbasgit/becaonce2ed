package caballero;

import exception.SinEspadaException;

public interface KnightInterface {
	
	
	public  void embarcar() throws SinEspadaException;
	
	public void matarDragon() throws SinEspadaException; 
	
	public boolean entregarEspada(boolean x);
	
	
}
