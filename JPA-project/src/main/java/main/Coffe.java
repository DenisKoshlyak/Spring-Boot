package main;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;

@Entity
public class Coffe{
	@Id
	private String id;
	private String name;
	
	public Coffe() {}
	
	public Coffe(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
