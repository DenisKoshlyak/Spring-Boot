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

import main.CoffeRepository;

@RestController
public class CoffeController {
	private CoffeRepository coffeRepository;
	
	public CoffeController(CoffeRepository coffeRepository){
		this.coffeRepository = coffeRepository;
	}
	
	@GetMapping("/")
	public Iterable<Coffe> getAllCoffes(){
		return coffeRepository.findAll();
	}
	
	@GetMapping("/findCoffeById/{id}")
	public Optional<Coffe> getCoffeById(@PathVariable String id) {
		return coffeRepository.findById(id);
	}
	
	@PostMapping("/addNewCoffe")
	public Iterable<Coffe> addNewCoffe(@RequestBody Coffe coffe) {
		coffeRepository.save(coffe);
		return coffeRepository.findAll();
	}
	
	@PutMapping("/putCoffe")
	public ResponseEntity putCoffe(@RequestBody Coffe coffe) {
		return (!coffeRepository.existsById(coffe.getId())) ? new ResponseEntity(coffeRepository.save(coffe), HttpStatus.CREATED) 
									 					    : new ResponseEntity(coffeRepository.save(coffe), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCoffe/{id}")
	public void deleteCoffe(@PathVariable String id){
		coffeRepository.deleteById(id);
	}
}
