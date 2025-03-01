package taco.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TacoOrder extends BaseEntity implements Serializable {

  @NotBlank
  private static final long serialVersionUID = 1L;

  @ManyToOne
  private User user;

  @NotNull
  private Date placedAt = new Date(System.currentTimeMillis());

  private BigDecimal totalAmount;

  private OrderStage orderStage;

  @Size(min = 1, message = "You must choose at least 1 Taco")
  @OneToMany(cascade = CascadeType.ALL)
  List<Taco> tacos = new ArrayList<>();

  public TacoOrder(){
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
