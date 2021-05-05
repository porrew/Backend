package sit.int204.practice.models;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {
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
	
	
}
