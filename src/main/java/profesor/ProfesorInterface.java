package profesor;

import exception.SinClaseException;

public interface ProfesorInterface {

	
	public void entrarEnClase() throws SinClaseException;
	
	public void comenzarLaClase() throws SinClaseException;
	
	public boolean salirDeClase(boolean x);
}
