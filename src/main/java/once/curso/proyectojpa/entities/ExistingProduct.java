package once.curso.proyectojpa.entities;

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
@Table(name = "EXISTING_PRODUCTS")
public class ExistingProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private double price;
	private byte image;
	private int stock;

	@ManyToOne
	@JoinColumn(name = "SUBCATEGORIES_ID")
	private int subCategory;

}
