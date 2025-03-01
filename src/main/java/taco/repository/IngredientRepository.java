package taco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taco.domain.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
