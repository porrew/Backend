package sit.int204.practice.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	private String name;
	
	@Column (name = "`Description`")
	private String Desc;
	
	@Column (name = "Price")
	private double Price;
	
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
	
	public Product(Long product_id, String names, String description, double price, String date, String path) {
		this.Product_id = product_id;
		this.name = names;
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
		return name;
	}

	public void setProduct_Name(String names) {
		name = names;
	}

	public String getDescription() {
		return Desc;
	}

	public void setDescription(String description) {
		Desc = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
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
	
//	public String getPhotosImagePath() {
//        return "src/main/resources/image/" + Product_id + "/" + Path;
//    }

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
		return "Product [Product_id=" + Product_id + ", Product_Name=" + name + ", Desc=" + Desc + ", Price="
				+ Price + ", Date=" + Date + ", Path=" + Path + ", colors=" + colors + ", brand=" + brand + "]";
	}

	

	

	
	
	
	

	
}
