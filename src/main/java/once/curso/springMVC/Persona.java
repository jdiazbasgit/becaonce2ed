package once.curso.springMVC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
	
	private String nombre, apellidos, telefono;
	

}
