package concierto.trabajo;

import concierto.exception.SinSonidoException;
import concierto.instrumentos.Instrumento;
import concierto.musicos.Solista;

public class ConciertoSolista {

	public static void main(String[] args) {
		Instrumento tambor= new Instrumento();
		tambor.setSonido("pom, pom, pom");
		Solista solista= new Solista();
		solista.setInstrumento(tambor);
		try {
			solista.tocar();
		} catch (SinSonidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
