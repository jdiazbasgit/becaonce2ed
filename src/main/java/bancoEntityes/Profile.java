package bancoEntityes;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="profiles")
public class Profile {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String secondName;
	private String identification;
	private String email;
	private String phone;
	private Image image;
	
	@ManyToOne
	@JoinColumn (name="identification_type_id")
	private IdentificationType identificationType;
	
	@ManyToOne
	@JoinColumn (name="users_id")
	private User user;

}