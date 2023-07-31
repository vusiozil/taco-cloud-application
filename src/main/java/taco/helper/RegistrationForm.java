package taco.helper;

import org.springframework.security.crypto.password.PasswordEncoder;
import taco.domain.User;

public class RegistrationForm {

  private String username;
  private String password;
  private String fullname;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phone;

  public RegistrationForm(){
  }

  public RegistrationForm(String username, String password, String fullname, String street,
                          String city, String state, String zip, String phone){
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phone = phone;
  }

  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(
            username, passwordEncoder.encode(password),
            fullname, street, city, state, zip, phone);
  }


  public String getUsername(){
    return username;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public String getFullname(){
    return fullname;
  }

  public void setFullname(String fullname){
    this.fullname = fullname;
  }

  public String getStreet(){
    return street;
  }

  public void setStreet(String street){
    this.street = street;
  }

  public String getCity(){
    return city;
  }

  public void setCity(String city){
    this.city = city;
  }

  public String getState(){
    return state;
  }

  public void setState(String state){
    this.state = state;
  }

  public String getZip(){
    return zip;
  }

  public void setZip(String zip){
    this.zip = zip;
  }

  public String getPhone(){
    return phone;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }
}
