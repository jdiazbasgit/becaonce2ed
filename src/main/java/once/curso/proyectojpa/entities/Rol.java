package once.curso.proyectojpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ROLES")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String rol;

}
