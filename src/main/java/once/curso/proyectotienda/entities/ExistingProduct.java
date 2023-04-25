package once.curso.proyectotienda.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="existing_products")
public class ExistingProduct implements Serializable {

    private static final long serialVersionUID = -1000119078147252957L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	
	private Double price;
	
	@Lob
	private byte[] image;
	
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subcategories_id")
	private SubCategory subcategories;
}
