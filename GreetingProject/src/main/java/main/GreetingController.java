package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private Greeting greeting;
	
	public GreetingController(Greeting greeting) {
		this.greeting = greeting;
	}
	
	@GetMapping("/name")
	public String getName() {
		return greeting.getName();
	}
	
	@GetMapping("/coffe")
	public String getCoffe() {
		return greeting.getCoffe();
	}
}
