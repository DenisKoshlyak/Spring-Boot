package main;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

interface CoffeRepository extends CrudRepository<Coffe, String>{}