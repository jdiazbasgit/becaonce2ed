package concierto;

public class PublicoFactory {
	
	
	private String entrada;
	
	public PublicoFactory() {}
	
	public static PublicoFactory of() {
		return new PublicoFactory();
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	
}
