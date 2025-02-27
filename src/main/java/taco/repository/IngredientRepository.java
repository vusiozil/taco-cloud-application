package taco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taco.domain.Ingredient;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
