package taco.helper;

public class DataNotFoundException extends RuntimeException{

  public DataNotFoundException(String message){
    super("Could not find "+message);
  }
}
