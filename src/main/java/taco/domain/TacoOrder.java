package taco.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class TacoOrder extends BaseEntity implements Serializable {

  @NotBlank
  private static final long serialVersionUID = 1L;

  @ManyToOne
  private User user;

  @NotNull
  private Date placedAt = new Date();
//  @NotBlank(message = "Delivery name is required")
  private String deliveryName;

//  @NotBlank(message = "Delivery Street is required")
  private String deliveryStreet;
//  @NotBlank(message = "Delivery city is required")
  private String deliveryCity;
//  @NotBlank(message = "Delivery state is required")
  private String deliveryState;
//  @NotBlank(message = "Delivery Zip Code is required")
  private String deliveryZip;
//  @NotBlank(message = "CC Number is required")
//  @CreditCardNumber(message="Not a valid credit card number")
  private String ccNumber;
//  @NotBlank(message = "CC Expiration is required")
//  @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",message="Must be formatted MM/YY")
  private String ccExpiration;
//  @NotBlank(message = "CC CVV is required")
//  @Digits(integer =3,fraction = 0,message = "invalid")
  private String ccCVV;

//  @Size(min=1,message="You must choose at least 1 Taco")
  @OneToMany(cascade = CascadeType.ALL)
  List<Taco> tacos = new ArrayList<>();

  public TacoOrder(){
  }

  public String getDeliveryName(){
    return deliveryName;
  }

  public void setDeliveryName(String deliveryName){
    this.deliveryName = deliveryName;
  }

  public String getDeliveryStreet(){
    return deliveryStreet;
  }

  public void setDeliveryStreet(String deliveryStreet){
    this.deliveryStreet = deliveryStreet;
  }

  public String getDeliveryCity(){
    return deliveryCity;
  }

  public void setDeliveryCity(String deliveryCity){
    this.deliveryCity = deliveryCity;
  }

  public String getDeliveryState(){
    return deliveryState;
  }

  public void setDeliveryState(String deliveryState){
    this.deliveryState = deliveryState;
  }

  public String getDeliveryZip(){
    return deliveryZip;
  }

  public void setDeliveryZip(String deliveryZip){
    this.deliveryZip = deliveryZip;
  }

  public String getCcNumber(){
    return ccNumber;
  }

  public void setCcNumber(String ccNumber){
    this.ccNumber = ccNumber;
  }

  public String getCcExpiration(){
    return ccExpiration;
  }

  public void setCcExpiration(String ccExpiration){
    this.ccExpiration = ccExpiration;
  }

  public String getCcCVV(){
    return ccCVV;
  }

  public void setCcCVV(String ccCVV){
    this.ccCVV = ccCVV;
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

  @Override
  public String toString(){
    return "TacoOrder{" +
            "deliveryName='" + deliveryName + '\'' +
            ", deliveryStreet='" + deliveryStreet + '\'' +
            ", deliveryCity='" + deliveryCity + '\'' +
            ", deliveryState='" + deliveryState + '\'' +
            ", deliveryZip='" + deliveryZip + '\'' +
            ", ccNumber='" + ccNumber + '\'' +
            ", ccExpiration='" + ccExpiration + '\'' +
            ", ccCVV='" + ccCVV + '\'' +
            ", tacos=" + tacos +
            '}';
  }
}
