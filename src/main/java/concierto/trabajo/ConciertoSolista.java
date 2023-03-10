package concierto.trabajo;

import concierto.excepciones.SinSonidoException;
import concierto.instrumentos.Instrumento;
import concierto.musicos.Solista;

public class ConciertoSolista {

	public static void main(String[] args) throws SinSonidoException {
		Instrumento tambor= new Instrumento();
		tambor.setSonido("pom, pom, pom");
		Solista solista= new Solista();
		solista.setInstrumento(tambor);
		solista.tocar();
	}

}
