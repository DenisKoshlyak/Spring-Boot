package main;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class FootballClubRetriever {
	private final ClubRepository repository;
	
	@Bean
	Consumer<List<FootballClub>> retrieveFootballClub(){
		return fcList -> {
			repository.deleteAll();
			
			repository.saveAll(fcList);
		};
	}
}
