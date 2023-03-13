package concierto.musicos;

import concierto.exeption.SinSonidoException;

public interface MusicoInterface {
	
	public void tocar() throws SinSonidoException;

}
