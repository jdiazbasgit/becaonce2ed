package concierto.musicos;

import concierto.exception.SinSonidoException;

public interface MusicoInterface {
	
	public void tocar() throws SinSonidoException;

}
