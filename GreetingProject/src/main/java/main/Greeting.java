package main;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greeting")
public class Greeting {
	private String name;
	private String coffe;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCoffe() {
		return coffe;
	}
	
	public void setCoffe(String coffe) {
		this.coffe = coffe;
	}
	
	
}
