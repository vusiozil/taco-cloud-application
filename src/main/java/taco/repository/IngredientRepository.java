package taco.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import taco.domain.Ingredient;

import java.util.List;
import java.util.Optional;


public interface IngredientRepository extends CrudRepository<Ingredient,String> {

  List<Ingredient> findAll();

  Optional<Ingredient> findById(String id);

  Ingredient save(Ingredient ingredient);

//  Page<Ingredient> findAll(PageRequest of, Sort id);

//  Page<Ingredient> findAll(PageRequest pageRequest);
}
