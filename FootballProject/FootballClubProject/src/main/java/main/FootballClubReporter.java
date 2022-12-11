package main;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class FootballClubReporter {
	private final FootballClubService fcService;
	
	@Bean
	Supplier<Iterable<FootballClub>> reportFootballClubs(){
		return () -> {
			try {
				return fcService.getFootballClubs();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return List.of();
		};
	}
}
