package taco.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@RestResource(rel ="ingredients" ,path = "ingredients")
public class Ingredient implements Serializable {

  @NotNull
  @Id
  private String id;

  @NotNull
  private String name;

  @NotNull
  private IngredientType type;

  public Ingredient(){
  }

  public Ingredient(String id, String name, IngredientType type){
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public IngredientType getType(){
    return type;
  }

  public void setType(IngredientType type){
    this.type = type;
  }

  @Override
  public String toString(){
    return "Ingredient{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", type=" + type +
            '}';
  }
}
