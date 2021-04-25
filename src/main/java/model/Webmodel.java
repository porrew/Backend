//package model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "product")
//public class Webmodel {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//
//	@Column(name = "prod_desc")
//	private String prod_desc;
//
//	@Column(name = "prod_image")
//	private String prod_image;
//
//	@Column(name = "prod_name")
//	private String prod_name;
//
//	public Webmodel() {
//
//	}
//	
//	public Webmodel(String prod_desc, String prod_image, String prod_name) {
//		this.prod_desc = prod_desc;
//		this.prod_image = prod_image;
//		this.prod_name = prod_name;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public String getDesc() {
//		return prod_desc;
//	}
//
//	public void setDesc(String prod_desc) {
//		this.prod_desc = prod_desc;
//	}
//
//	public String getImage() {
//		return prod_image;
//	}
//
//	public void setImage(String prod_image) {
//		this.prod_image = prod_image;
//	}
//
//	public String getName() {
//		return prod_name;
//	}
//	public void setName(String prod_name) {
//		this.prod_name = prod_name;
//	}
//	@Override
//	public String toString() {
//		return "Webmodel [id=" + id + ", title=" + prod_desc + ", desc=" + prod_image + ", published=" + prod_name + "]";
//	}
//	
//}