package once.curso.beans;

import lombok.Data;

@Data
public class Persona {
	private String nombre;
	private String dni;
	private String telefono;

	public Persona(String nombre, String dni, String telefono) {
		this.setNombre(nombre);
		this.setDni(dni);
		this.setTelefono(telefono);
	}

}