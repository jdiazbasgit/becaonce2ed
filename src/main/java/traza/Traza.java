package traza;

import org.springframework.stereotype.Component;

@Component

public class Traza implements TrazaInterface {

	public void escritura() {
		String leer;
		System.out.println("estoy escribiendo");
	}

	public void lectura() {
		System.out.println("estoy leyendo");
	}

}
