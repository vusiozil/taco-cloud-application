package taco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.Ingredient;
import taco.service.IngredientService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

  private final IngredientService ingredientService;

  @Autowired
  public IngredientController(IngredientService ingredientService){
    this.ingredientService = ingredientService;
  }

  @PostMapping
  public ResponseEntity<String> createIngredient(@Valid @RequestBody Ingredient ingredient){

    Ingredient savedIngredient = ingredientService.save(ingredient);

    LOGGER.debug("Ingredient created {}", ingredient);

    return ResponseEntity
            .created(URI.create("/ingredients/" + savedIngredient.getId()))
            .body("Ingredient created successfully");
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Ingredient> getById(@PathVariable("Id") String Id){

    Ingredient ingredient = ingredientService.findById(Id);

    return ResponseEntity.ok(ingredient);
  }

  @DeleteMapping("/{Id}")
  public ResponseEntity<String> deleteIngredient(@PathVariable("Id") String Id){

    Ingredient ingredient = ingredientService.findById(Id);

    ingredientService.delete(ingredient);

    return ResponseEntity.ok("Ingredient deleted successfully");
  }

  @PutMapping("/{Id}")
  public ResponseEntity<String> update(@PathVariable("Id") String Id,
                                       @Valid @RequestBody Ingredient ingredient){

    ingredient.setId(Id);
    ingredientService.update(ingredient);

    return ResponseEntity.ok("Ingredient deleted successfully");
  }

  @GetMapping
  public ResponseEntity<Page<Ingredient>> getIngredients(@PageableDefault(size = 10) Pageable pageable){

    Page<Ingredient> ingredientPage = ingredientService.findAll(pageable);

    return ResponseEntity.ok(ingredientPage);
  }

}
