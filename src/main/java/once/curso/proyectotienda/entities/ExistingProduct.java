package once.curso.proyectotienda.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data                     
@Entity
@Table(name="existing_products")
public class ExistingProduct extends RepresentationModel<ExistingProduct> {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	
	private Double price;
	
	@Lob
	private byte[] image;
	
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="subcategories_id")
	private SubCategory subcategory;
}
