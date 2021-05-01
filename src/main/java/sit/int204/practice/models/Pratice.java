package sit.int204.practice.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pratice")
public class Pratice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Code;
	@Column (name = "Name")
	private String Name;
	@Column (name = "`Desc`")
	private String Desc;
	
	
	public String getCode() {
	    return Code;
	 }
	public String getName() {
		return Name;
	}
	public String getDesc() {
		return Desc;
	}
	public void setName(String Name) {
		this.Name = Name;	
	}
	
	public void setDesc(String Desc) {
		this.Desc = Desc;	
	}
	
	@Override
	public String toString() {
		return "pratice [Code=" + Code + ", Name=" + Name + ", Desc=" + Desc  + "]";
	}
	
	
}
