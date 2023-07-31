package taco.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@RestResource(rel ="tacos" ,path = "tacos")
public class Taco extends BaseEntity implements Serializable {


  @NotNull
//  @Size(min = 5 ,message = "Name must be at least 5 characters long")
  private String name;

  private Date createdAt = new Date();

//  @Size(min=1, message="You must choose at least 1 ingredient")
  @ManyToMany
  private List<Ingredient> ingredients;

  public Taco(){
  }

  public void addIngredient(Ingredient ingredient){
    this.ingredients.add(ingredient);
  }

  public Taco(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public List<Ingredient> getIngredients(){
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients){
    this.ingredients = ingredients;
  }

  public Date getCreatedAt(){
    return createdAt;
  }

  @Override
  public String toString(){
    return "Taco{" +
            "name='" + name + '\'' +
            ", ingredients=" + ingredients +
            '}';
  }
}
