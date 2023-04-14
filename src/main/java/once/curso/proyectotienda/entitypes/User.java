package once.curso.proyectotienda.entitypes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", length = 20, nullable = false)
	private int id;
	
	@Column(name = "User", nullable = false)
	private String user;
	
	@Column(name = "Password", nullable = false)
	private String password;
	
	@Column(name = "Enabled", nullable = false)
	private String enabled;
	
	@OneToMany
	@JoinColumn (name="Roles_Id")
	private Rol roles;
}
