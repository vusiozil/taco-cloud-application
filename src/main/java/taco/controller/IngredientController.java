package taco.controller;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.Ingredient;
import taco.repository.IngredientRepository;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IngredientController {

	private final Logger logger = Logger.getLogger(IngredientController.class);

	private final IngredientRepository repository;

	public IngredientController(IngredientRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<String> createIngredient(@RequestBody Ingredient ingredient) {

		ingredient = repository.save(ingredient);
		return ResponseEntity
				.created(URI.create("/ingredients/" + ingredient.getId()))
				.body("Ingredient created successfully");
	}

	@GetMapping("/{Id}")
	public ResponseEntity<Ingredient> getById(@PathVariable("Id") String Id) {
		Optional<Ingredient> ingredientOptional = repository.findById(Id);

		return ingredientOptional
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}


	@GetMapping
	public ResponseEntity<Collection<Ingredient>> findAll(Pageable pageable) {
		Page<Ingredient> page = repository.findAll(
				PageRequest.of(
						pageable.getPageNumber(),
						pageable.getPageSize(),
						pageable.getSortOr(Sort.by(Sort.Direction.DESC, "amount"))));
		return ResponseEntity.ok(page.toList());
	}
}
