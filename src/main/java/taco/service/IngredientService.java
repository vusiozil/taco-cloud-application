package taco.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import taco.domain.Ingredient;

import java.util.List;

public interface IngredientService {

  Ingredient findById(String id);

  void deleteById(String id);

  List<Ingredient> findAll();

  Ingredient save(Ingredient ingredient);

  Page<Ingredient> findAll(Pageable pageable);

  void update(Ingredient ingredient);
}
