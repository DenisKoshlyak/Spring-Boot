package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AircraftController {
	@NonNull
	private final AircraftRepository repository;
	private WebClient client = WebClient.create("http://localhost:7634/aircraft");
	
	@GetMapping("/aircraft")
	public String getPosition(Model model) {
		repository.deleteAll();
		
		client.get().retrieve()
					.bodyToFlux(Aircraft.class)
					.filter(plane -> !(plane.getReg()
					.isEmpty()))
					.toStream()
					.forEach(repository::save);
		
		model.addAttribute("CurrentPosition", repository.findAll());
		return "positions.html";
	}
}
