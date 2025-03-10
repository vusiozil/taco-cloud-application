package taco.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import static taco.helper.FeatureFlags.DISCOUNT_APPLIED;

@Entity
public class Taco extends BaseEntity implements Serializable {

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @CreationTimestamp
  @Column(updatable = false, nullable = false)
  private Date createdAt;

  @Transient
  private double price;

  @Size(min = 1, message = "You must choose at least 1 ingredient")
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

  public double getPrice(){
    double amount = this.getIngredients()
            .parallelStream()
            .mapToDouble(Ingredient::getPrice)
            .sum();

    if(DISCOUNT_APPLIED.isActive()){
      return amount - amount * 0.05;
    }
    return amount;
  }

  @Override
  public String toString(){
    return "Taco{" +
            "name='" + name + '\'' +
            ", createdAt=" + createdAt +
            ", price=" + price +
            ", ingredients=" + ingredients +
            '}';
  }
}
