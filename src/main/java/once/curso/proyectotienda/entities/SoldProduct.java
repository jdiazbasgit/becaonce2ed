package once.curso.proyectotienda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name = "sold_products")
public class SoldProduct extends RepresentationModel<SoldProduct> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int quantity;

	@ManyToOne
	@JoinColumn(name = "existing_products_id")
	private ExistingProduct existingProduct;

	private int price;

	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "profiles_id")
	private Profile profile;

	private boolean basket;
}
