package taco.helper;

public class TacoOrderNotFoundException extends RuntimeException{

  public TacoOrderNotFoundException(Long Id){
    super("Could not find Taco Order "+Id);
  }
}
