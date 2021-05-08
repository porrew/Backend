package sit.int204.practice.models;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import javax.persistence.JoinColumn;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Product_id")
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
	private String Path;
	
	
	@ManyToMany
	@JoinTable(name = "Have",
		joinColumns = { @JoinColumn(name = "Product_Product_id")},
		inverseJoinColumns = { @JoinColumn (name = "Color_Color_id")})
	private List<Color> colors ;
	
	 @ManyToOne
	 @JoinColumn(name= "Brand_Brand_Id")
	 private Brand brand;

	
	public Product () {
		
	}
	
	public Product(Long product_id, String product_Name, String description, int price, String date, String path) {
		this.Product_id = product_id;
		this.Product_Name = product_Name;
		this.Desc = description;
		this.Price = price;
		this.Date = date;
		this.Path = path;
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

	public String getPath() {
		return Path;
	}
	
	public String getPhotosImagePath() {
        return "src/main/resources/image/" + Product_id + "/" + Path;
    }

	public void setPath(String path) {
		Path = path;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", Product_Name=" + Product_Name + ", Desc=" + Desc + ", Price="
				+ Price + ", Date=" + Date + ", Path=" + Path + ", colors=" + colors + ", brand=" + brand + "]";
	}

	

	

	
	
	
	

	
}
