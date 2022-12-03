package main;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
	private final CoffeRepository coffeRepository;

	public DataLoader(CoffeRepository coffeRepository) {
		this.coffeRepository = coffeRepository;
	}
	
	@PostConstruct
	public void loadData() {
		this.coffeRepository.saveAll(List.of(new Coffe("1", "ARABICA"), new Coffe("2", "RUSSIA"), new Coffe("3", "BRAZIL"), new Coffe("4", "BELARUS")));
	}
}
