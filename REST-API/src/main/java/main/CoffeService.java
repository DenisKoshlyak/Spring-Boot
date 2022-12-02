package main;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CoffeService {
	public Optional<Coffe> findCoffeById(List<Coffe> coffes, int id) {
		for(Coffe c : coffes) {
			if(c.getId() == id)
				return Optional.of(c);
		}
		return Optional.empty();
	}
}
