package main;

import java.util.Comparator;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FootballClubService{
	@NonNull
	private final ClubRepository repository;
	private WebClient client = WebClient.create("http://localhost:7634/clubs");
	CompareClub comparator = new CompareClub();
	
	public String getClubs(Model model) {
		model.addAttribute("allClubs", repository.findAll());
		return "clubs.html";
	}
}

class CompareClub implements Comparator<FootballClub>{
	public int compare(FootballClub club1, FootballClub club2) {
		if(club1.getRating() == club2.getRating()) {
			return 0;
		}
		else if(club1.getRating() < club2.getRating()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
