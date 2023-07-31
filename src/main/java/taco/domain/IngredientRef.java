package taco.domain;

public class IngredientRef {

  private String ingredientRef;

  public IngredientRef(){
  }

  public IngredientRef(String ingredientRef){
    this.ingredientRef = ingredientRef;
  }

  public String getIngredientRef(){
    return ingredientRef;
  }

  public void setIngredientRef(String ingredientRef){
    this.ingredientRef = ingredientRef;
  }

  @Override
  public String toString(){
    return "IngredientRef{" +
            "ingredientRef='" + ingredientRef + '\'' +
            '}';
  }
}
