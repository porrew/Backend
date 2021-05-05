package sit.int204.practice.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	private Long Product_id;
	
	@Column (name = "Product_Name")
	private String Product_Name;
	
	@Column (name = "`Description`")
	private String Desc;
	
	@Column (name = "Price")
	private int Price;
	
	@Column (name = "Date")
	private String Date;
	
	@Column (name = "Path")
	private int Path;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Have",
		joinColumns = { @JoinColumn(name = "Product_Product_id")},
		inverseJoinColumns = { @JoinColumn (name = "Color_Color_id")})
	private Set<Color> colors = new HashSet<>();
	
	public Product () {
		
	}
	
	public Product(Long product_id, String product_Name, String description, int price, String date, int path) {
		Product_id = product_id;
		Product_Name = product_Name;
		Desc = description;
		Price = price;
		Date = date;
		Path = path;
	}
	
	public Long getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

	public String getDescription() {
		return Desc;
	}

	public void setDescription(String description) {
		Desc = description;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getPath() {
		return Path;
	}

	public void setPath(int path) {
		Path = path;
	}

	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", Product_Nam=" + Product_Name + ", Description=" + Desc
				+ ", Price=" + Price + ", Date=" + Date + ", Path=" + Path + "]";
	}

	
	
	
	

	
}
