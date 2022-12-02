package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeController {
	private List<Coffe> coffes = new ArrayList<>();
	private CoffeService coffeService;
	Logger logger = Logger.getLogger(CoffeController.class.getName());
	
	@Autowired
	public CoffeController(CoffeService coffeService){
		this.coffeService = coffeService;
	}
	
	@GetMapping("/")
	public Iterable<Coffe> getAllCoffes(){
		return coffes;
	}
	
	@PostMapping("/")
	public List<Coffe> createCoffes(){
		coffes.add(new Coffe(1, "ARABICA"));
		coffes.add(new Coffe(2, "RUSSIA"));
		return coffes;
	}
	
	@GetMapping("/findCoffeById")
	public Optional<Coffe> getCoffe(@RequestParam int id) {
		return coffeService.findCoffeById(coffes, id);
	}
	
	@PostMapping("/addNewCoffe")
	public List<Coffe> addNewCoffe(@RequestBody Coffe coffe2) {
		coffes.add(coffe2);
		return coffes;
	}
	
	@PutMapping("/putCoffe")
	public ResponseEntity putCoffe(@RequestBody Coffe coffe) {
		int id = coffe.getId();
		for(Coffe c : coffes) {
			if(c.getId() == id) {
				id = -1;
				coffes.set(c.getId() - 1, coffe);
				break;
			}
		}
		return (id == coffe.getId()) ? new ResponseEntity(addNewCoffe(coffe), HttpStatus.CREATED) 
									 : new ResponseEntity(coffes, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCoffe/{id}")
	public List<Coffe> deleteCoffe(@PathVariable String id){
		Integer iden = Integer.parseInt(id);
		coffes.removeIf(c -> c.getId() == iden);
		return coffes;
	}
}
