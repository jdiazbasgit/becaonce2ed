package patrones;

public class EjemploFactory {
	private int edad;
	private EjemploFactory() {
		
	}
	
	public static EjemploFactory of() {
		return new EjemploFactory();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
