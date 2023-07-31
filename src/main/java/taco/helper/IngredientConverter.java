package taco.helper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import taco.domain.Ingredient;
import taco.repository.IngredientRepository;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {

  private final IngredientRepository ingredientRepository;

  public IngredientConverter(IngredientRepository ingredientRepository){
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public Ingredient convert(String id){
    return ingredientRepository.findById(id).orElse(null);
  }
}
