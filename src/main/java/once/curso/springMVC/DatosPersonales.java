package once.curso.springMVC;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatosPersonales {
	 private String nombre;
	 private String apellidos;
	 private String telefono;
	
	/* ES LO MISMO QUE @AllArgsConstructor
	public DatosPersonales(String nombre, String apellidos, String telefono) {
	    this.nombre = nombre;
	    this.apellidos = apellidos;
	    this.telefono = telefono;
	}
	
	@Override
	public String toString() {
	    return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Teléfono: " + telefono;
	}*/
}
