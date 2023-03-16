package traza;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class Traza implements TrazaInterface {
	@Value(value = "")
	public void escritura() {
		String leer;
		System.out.println("estoy escribiendo");
	}

	public void lectura() {
		System.out.println("estoy leyendo");
	}

}
