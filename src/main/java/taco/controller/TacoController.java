package taco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taco.domain.Taco;
import taco.service.TacoService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/tacos")
public class TacoController {

  private final TacoService tacoService;

  @Autowired
  public TacoController(TacoService tacoService){
    this.tacoService = tacoService;
  }

  @GetMapping
  public ResponseEntity<?> findAll(@PageableDefault(size = 10, sort = "createdAt", direction =
          Sort.Direction.DESC) Pageable pageable){

    if(pageable.isUnpaged()){

      return ResponseEntity.ok(tacoService.findAll());
    }

    Page<Taco> tacos = tacoService.findAll(pageable);
    return ResponseEntity.ok(tacos);
  }

  @PostMapping
  public ResponseEntity<String> save(@Valid @RequestBody Taco taco){

    Taco savedTaco = tacoService.save(taco);

    return ResponseEntity
            .created(URI.create("/ingredients/" + savedTaco.getId()))
            .body("Ingredient created successfully");

  }

  @DeleteMapping("/{Id}")
  public ResponseEntity<String> delete(@PathVariable("Id") Long id){

    tacoService.deleteById(id);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body("Taco with id " + id + " deleted successfully");
  }

  @GetMapping("/{Id}")
  public ResponseEntity<Taco> getTacoById(@PathVariable("Id") Long id){

    Taco taco = tacoService.findById(id);

    return ResponseEntity.ok(taco);
  }

  @PutMapping("/{Id}")
  public ResponseEntity<Taco> update(@PathVariable("Id") Long id, @Valid @RequestBody Taco taco){

    taco.setId(id);
    Taco updatedTaco = tacoService.update(taco);

    return ResponseEntity.ok(updatedTaco);

  }

}
