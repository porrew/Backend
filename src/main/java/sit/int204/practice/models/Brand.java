package sit.int204.practice.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Brand")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","product"})
public class Brand {
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "Brand_Brand_id")
    List <Product> product = new ArrayList <> ();
	
	@Id
	private Long Brand_id;
	
	@Column (name = "Brand_Name")
	private String Brand_Name;
	
	
    
	public Brand() {
		
	}
	
	public Brand(Long brand_id, String brand_Name) {
		super();
		Brand_id = brand_id;
		Brand_Name = brand_Name;
	}

	public Long getBrand_id() {
		return Brand_id;
	}

	public void setBrand_id(Long brand_id) {
		Brand_id = brand_id;
	}

	public String getBrand_Name() {
		return Brand_Name;
	}

	public void setBrand_Name(String brand_Name) {
		Brand_Name = brand_Name;
	}

	

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Brand [product=" + ", Brand_id=" + Brand_id + ", Brand_Name=" + Brand_Name + "]";
	}

	
	
	
}
