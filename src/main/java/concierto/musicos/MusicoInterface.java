package concierto.musicos;

import concierto.excepciones.SinSonidoException;

public interface MusicoInterface {
	
	public void tocar() throws SinSonidoException;

}
