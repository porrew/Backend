package sit.int204.practice.models;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color {
	@Id
	private Long Color_id;
	
	@Column (name = "Color_Name")
	private String Color_Name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Color")
	private Set<Product> posts = new HashSet<>();
	
	public Color () {
		
	}
	
	public Color(Long color_id, String color_Name) {
		super();
		Color_id = color_id;
		Color_Name = color_Name;
	}

	public Long getColor_id() {
		return Color_id;
	}

	public void setColor_id(Long color_id) {
		Color_id = color_id;
	}

	public String getColor_Name() {
		return Color_Name;
	}

	public void setColor_Name(String color_Name) {
		Color_Name = color_Name;
	}

	@Override
	public String toString() {
		return "Color [Color_id=" + Color_id + ", Color_Name=" + Color_Name + "]";
	}
	
	
	
}
