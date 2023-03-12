package exepciones.concierto;

public class SinSonidoException extends Exception {

	public SinSonidoException(String mensaje) {

		super(mensaje);
	}

	public class Instrumento {
		public String sonar(String sonido) throws SinSonidoException {

			if (sonido == "nada") {
				throw new SinSonidoException("sonido");
			}

			try {
				Instrumento instrumento = new Instrumento();
				instrumento.sonar("nada");
			} catch (SinSonidoException e) {
				System.out.println("Se produjo un error: " + e.getMessage());
			}
			return ("sonido");
		}
	}
}
