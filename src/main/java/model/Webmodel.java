package model;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Webmodel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

	public Webmodel() {

	}

}