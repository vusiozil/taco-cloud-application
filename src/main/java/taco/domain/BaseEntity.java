package taco.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public BaseEntity(){
  }

  public BaseEntity(Long id){
    this.id = id;
  }

  public Long getId(){
    return id;
  }

  public void setId(Long id){
    this.id = id;
  }
}
