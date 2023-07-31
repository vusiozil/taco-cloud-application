package taco.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import taco.helper.TacoOrderNotFoundException;

@ControllerAdvice
public class TacoOrderNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(TacoOrderNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String tacoOrderNotFound(TacoOrderNotFoundException exception) {
    return exception.getMessage();
  }

}
