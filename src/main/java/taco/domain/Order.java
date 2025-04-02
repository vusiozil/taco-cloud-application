package taco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {

  @Serial
  @NotBlank
  private static final long  serialVersionUID = 1L;

  @ManyToOne
  private User user;

  @NotNull
  private Date placedAt = new Date(System.currentTimeMillis());

  private BigDecimal totalAmount;

  private OrderStage orderStage;

  @Size(min = 1, message = "You must choose at least 1 Taco")
  @OneToMany(cascade = CascadeType.ALL)
  List<Taco> tacos = new ArrayList<>();

  public Order(){
  }

  public Date getPlacedAt(){
    return placedAt;
  }

  public User getUser(){
    return user;
  }

  public void setUser(User user){
    this.user = user;
  }

  public void addOrder(Taco taco){
    this.tacos.add(taco);
  }

  public List<Taco> getTacos(){
    return tacos;
  }

  public void setTacos(List<Taco> tacos){
    this.tacos = tacos;
  }

  public BigDecimal getTotalAmount(){
    return totalAmount;
  }

  public void setPlacedAt(Date placedAt){
    this.placedAt = placedAt;
  }

  public void setTotalAmount(BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }

  public OrderStage getOrderStage(){
    return orderStage;
  }

  public void setOrderStage(OrderStage orderStage){
    this.orderStage = orderStage;
  }

  @Override
  public String toString(){
    return "TacoOrder{" +
            "user=" + user +
            ", placedAt=" + placedAt +
            ", tacos=" + tacos +
            '}';
  }
}
