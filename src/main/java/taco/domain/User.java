package taco.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name="users")
public class User extends BaseEntity implements UserDetails {
  private String username;
  private String password;
  private String fullname;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String phoneNumber;

  public User(){
  }

  public User(String username, String password, String fullname, String street, String city,
              String state, String zip, String phoneNumber){
    this.username = username;
    this.password = password;
    this.fullname = fullname;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phoneNumber = phoneNumber;
  }
  public String getFullname(){
    return fullname;
  }

  public String getStreet(){
    return street;
  }

  public String getCity(){
    return city;
  }

  public String getState(){
    return state;
  }

  public String getZip(){
    return zip;
  }

  public String getPhoneNumber(){
    return phoneNumber;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public void setFullname(String fullname){
    this.fullname = fullname;
  }

  public void setStreet(String street){
    this.street = street;
  }

  public void setCity(String city){
    this.city = city;
  }

  public void setState(String state){
    this.state = state;
  }

  public void setZip(String zip){
    this.zip = zip;
  }

  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String getPassword(){
    return password;
  }

  @Override
  public String getUsername(){
    return username;
  }



  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  }
}
