package once.curso.proyectotienda.entitypes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "Id", length = 20, nullable = false)
	private int id;
	private String description;
	
	@Column(name = "Price", nullable = false)
	private double price;
	
	@Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	
	/*String imagePath = "path/to/your/image.jpg";
	BufferedImage myPicture = ImageIO.read(new File(imagePath));*/
	
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="subcategories_id")
	private Subcategory subcategories;
}
