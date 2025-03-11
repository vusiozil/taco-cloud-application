package taco.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.Ingredient;
import taco.service.IngredientService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ingredient API", description = "Endpoints for managing taco ingredients")
public class IngredientController {

  private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

  private final IngredientService ingredientService;

  @Autowired
  public IngredientController(IngredientService ingredientService){
    this.ingredientService = ingredientService;
  }

  @PostMapping
  @Operation(
          summary = "Create a new ingredient",
          description = "Adds a new ingredient to the system."
  )
  public ResponseEntity<String> create(@Valid @RequestBody Ingredient ingredient){

    Ingredient savedIngredient = ingredientService.save(ingredient);

    LOGGER.debug("Ingredient created {}", ingredient);

    return ResponseEntity
            .created(URI.create("/ingredients/" + savedIngredient.getId()))
            .body("Ingredient created successfully");
  }

  @GetMapping("/{Id}")
  @Operation(
          summary = "Retrieve an ingredient",
          description = "Fetches an ingredient by its ID."
  )
  public ResponseEntity<Ingredient> getById(@Parameter(description = "ID of the ingredient to " +
          "retrieve") @PathVariable("Id") String Id){

    Ingredient ingredient = ingredientService.findById(Id);

    return ResponseEntity.ok(ingredient);
  }

  @DeleteMapping("/{Id}")
  @Operation(
          summary = "Delete an ingredient",
          description = "Removes an ingredient from the system using its ID."
  )
  public ResponseEntity<String> delete(@Parameter(description = "ID of the ingredient to delete")
                                       @PathVariable("Id") String Id){

    ingredientService.deleteById(Id);

    return ResponseEntity.ok("Ingredient deleted successfully");
  }

  @PutMapping("/{Id}")
  @Operation(
          summary = "Update an ingredient",
          description = "Updates the details of an existing ingredient."
  )
  public ResponseEntity<String> update(@Parameter(description = "ID of the ingredient to update")
                                       @PathVariable("Id") String Id,
                                       @Valid @RequestBody Ingredient ingredient){

    ingredient.setId(Id);
    ingredientService.update(ingredient);

    return ResponseEntity.ok("Ingredient updated successfully");
  }

  @GetMapping
  @Operation(
          summary = "Retrieve all ingredients",
          description = "Fetches a list of all available ingredients."
  )
  public ResponseEntity<List<Ingredient>> getIngredients(){

    return ResponseEntity.ok(ingredientService.findAll());
  }

}
