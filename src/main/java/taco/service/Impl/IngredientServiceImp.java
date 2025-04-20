package taco.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import taco.domain.Ingredient;
import taco.helper.DataNotFoundException;
import taco.repository.IngredientRepository;
import taco.service.IngredientService;

import java.util.List;

@Service
public class IngredientServiceImp implements IngredientService {

  private final IngredientRepository ingredientRepository;

  @Autowired
  public IngredientServiceImp(IngredientRepository ingredientRepository){
    this.ingredientRepository = ingredientRepository;
  }

  @Override
  public Ingredient findById(String id){

    return ingredientRepository
            .findById(id)
            .orElseThrow(() -> new DataNotFoundException("Ingredient " + id));
  }

  @Override
  public void deleteById(String id){
    Ingredient saved = findById(id);

    ingredientRepository.delete(saved);
  }

  @Override
  public List<Ingredient> findAll(){
    return ingredientRepository.findAll();
  }

  @Override
  public Ingredient save(Ingredient ingredient){
    return ingredientRepository.save(ingredient);
  }

  @Override
  public Page<Ingredient> findAll(Pageable pageable){
    return ingredientRepository.findAll(pageable);
  }

  @Override
  public void update(Ingredient ingredient){

    if(!ingredientRepository.existsById(ingredient.getId())){
      throw new DataNotFoundException("Ingredient " + ingredient.getId());
    }
    ingredientRepository.save(ingredient);
  }
}
