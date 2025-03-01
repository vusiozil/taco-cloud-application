package taco.service.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import taco.domain.Ingredient;

import java.util.logging.Logger;

@Service
public class ConsumeAPIService {

//  Logger logger = Logger.getLogger(ConsumeAPIService.class);
private final static Logger LOGGER = Logger.getLogger(ConsumeAPIService.class.getName());

  private final RestTemplate client;

  public ConsumeAPIService(RestTemplate client){
    this.client = client;
  }

  public Ingredient getIngredientByIdx(String ingredientId) {
    ResponseEntity<Ingredient> responseEntity =
            client.getForEntity("http://localhost:8080/ingredients/{id}",
                    Ingredient.class, ingredientId);
    LOGGER.info("Fetched time: {}"+ responseEntity.getHeaders().getDate());
    return responseEntity.getBody();
  }

  public Ingredient getIngredientById(String id){
    return client.getForObject("http://localhost:8443/api/v1/ingredients/{id}", Ingredient.class, id);
  }

  public Ingredient saveIngredient(Ingredient ingredient){
    return client.postForObject("http://localhost:8443/api/v1/ingredients",ingredient,
            Ingredient.class);
  }

  public void deleteIngredientById(String id){
    client.delete("http://localhost:8443/api/v1/ingredients/{id}", id);
  }

  public void updateIngredient(Ingredient ingredient){
    client.put("http://localhost:8443/api/v1/ingredients/{id}",ingredient,ingredient.getId());
  }
}
