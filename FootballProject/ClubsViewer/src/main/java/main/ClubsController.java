package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ClubsController {
	@NonNull
	private final FootballClubService fcService;
		
	@GetMapping("/clubs")
	public String getClubs(Model model) {
		return fcService.getClubs(model);
	}
}

