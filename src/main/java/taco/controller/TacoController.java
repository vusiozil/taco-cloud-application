package taco.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.Taco;
import taco.service.TacoService;

import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/tacos")
@Tag(name = "Taco API", description = "Endpoints for managing tacos")
public class TacoController {

  private final TacoService tacoService;

  @Autowired
  public TacoController(TacoService tacoService){
    this.tacoService = tacoService;
  }

  @GetMapping
  @Operation(
          summary = "Retrieve all tacos",
          description = "Fetches a list of all available tacos with optional pagination and " +
                  "sorting."
  )
  public ResponseEntity<?> findAll(@Parameter(description = "Pagination and sorting options")
                                   Pageable pageable){

    if(pageable.isUnpaged()){

      return ResponseEntity.ok(tacoService.findAll());
    }

    Page<Taco> tacos = tacoService.findAll(pageable);
    return ResponseEntity.ok(tacos);
  }

  @PostMapping
  @Operation(
          summary = "Create a new taco",
          description = "Saves a new taco in the system."
  )
  public ResponseEntity<String> save(@Valid @RequestBody Taco taco){

    Taco savedTaco = tacoService.save(taco);

    return ResponseEntity
            .created(URI.create("/ingredients/" + savedTaco.getId()))
            .body("Ingredient created successfully");

  }

  @DeleteMapping("/{Id}")
  @Operation(
          summary = "Delete a taco",
          description = "Removes a taco from the system using its ID."
  )
  public ResponseEntity<String> delete(@Parameter(description = "ID of the taco to delete")
                                       @PathVariable("Id") Long id){

    tacoService.deleteById(id);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Taco with id " + id + " deleted successfully");
  }

  @GetMapping("/{Id}")
  @Operation(
          summary = "Retrieve a taco by ID",
          description = "Fetches a taco based on the given ID."
  )
  public ResponseEntity<Taco> getTacoById(@Parameter(description = "ID of the taco to retrieve")
                                          @PathVariable("Id") Long id){

    Taco taco = tacoService.findById(id);

    return ResponseEntity.ok(taco);
  }

  @PutMapping("/{Id}")
  @Operation(
          summary = "Update an existing taco",
          description = "Updates the details of an existing taco using the provided ID."
  )
  public ResponseEntity<Taco> update(@Parameter(description = "ID of the taco to update")
                                     @PathVariable("Id") Long id,
                                     @Valid @RequestBody Taco taco){

    taco.setId(id);
    Taco updatedTaco = tacoService.update(taco);

    return ResponseEntity.ok(updatedTaco);

  }

}
