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
	private String Code;
	
	@Column (name = "Name")
	private String Name;
	@Column (name = "`Desc`")
	private String Desc;
	
	public Pratice () {
		
	}
	
	public Pratice(String Name, String Desc,String Code) {
		this.Name = Name;
		this.Desc = Desc;
		this.Code = Code;
	}
	
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
	public void setCode(String Code) {
		this.Code = Code;	
	}
	
	@Override
	public String toString() {
		return "pratice [Code=" + Code + ", Name=" + Name + ", Desc=" + Desc  + "]";
	}
	
	
}
