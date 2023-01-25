package concierto;

//soy profe

public class Instrumento implements InstrumentoInterface, Comparable<Instrumento> {

	private String sonido;

	public Instrumento(String sonido) {
		// setSonido(sonido);
		this.sonido = sonido;

	}

	public String sonar() {
		return getSonido();
	}

	public String getSonido() {
		return this.sonido;
	}

	public void setSonido(String sonido) {
		this.sonido = sonido;
	}

	@Override
	public boolean equals(Object obj) {
		Instrumento otro= (Instrumento) obj;
		return this.getSonido().equals(otro.getSonido());
	}
	
	@Override
	public int hashCode() {
		
		return getSonido().hashCode()+28;
	}

	@Override
	public int compareTo(Instrumento otro) {

		return this.getSonido().compareTo(otro.getSonido());
	}

}