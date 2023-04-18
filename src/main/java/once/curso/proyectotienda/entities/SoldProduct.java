package once.curso.proyectotienda.entities;

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
@Table(name = "sold_products")
public class SoldProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "existing_products_id")
	private ExistingProduct existingProduct;
}
