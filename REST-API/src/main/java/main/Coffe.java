package main;

import java.util.UUID;

public class Coffe {
	private final int id;
	private String name;
	
	public Coffe(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
}
