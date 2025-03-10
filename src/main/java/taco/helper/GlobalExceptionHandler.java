package taco.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<String> handleDataNotFoundException(DataNotFoundException ex){

    LOG.error("Resource not found", ex);

    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Resource not found: " + ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

    LOG.error("Validation errors", ex);

    //Collect all the validation errors
    Map<String, String> errors = new HashMap<>();
    for(FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Validation errors : " + errors);
  }
}
