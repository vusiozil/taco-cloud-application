package taco.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.json.JsonTest;
//import org.springframework.boot.test.json.JacksonTester;
import taco.repository.IngredientRepository;

//import static org.assertj.core.api.Assertions.assertThat;

//@JsonTest
class IngredientTest {

//  @Autowired
//  private JacksonTester<Ingredient> json;
//
//  private final IngredientRepository repository;
//
//  IngredientTest(IngredientRepository repository){
//    this.repository = repository;
//  }
//
//  @Test
//  void testIngredientSerialization() throws Exception {
//
//    Ingredient ingredient = repository.findById("FLTO").get();
//
//    assertThat(json.write(ingredient)).isStrictlyEqualToJson("expected.json");
//    assertThat(json.write(ingredient)).hasJsonPathNumberValue("@.id");
//    assertThat(json.write(ingredient)).extractingJsonPathNumberValue("@.id")
//            .isEqualTo("FLTO");
//    assertThat(json.write(ingredient)).hasJsonPathNumberValue("@.name");
//    assertThat(json.write(ingredient)).extractingJsonPathNumberValue("@.name")
//            .isEqualTo("Flour Tortilla");
//
//  }

//  @Test
//  public void cashCardDeserializationTest() throws IOException{
//    String expected = " {\"id\":99,\"amount\":123.45}";
//    assertThat(json.parse(expected))
//            .isEqualTo(new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP));
//    assertThat(json.parseObject(expected).id()).isEqualTo(1000);
//    assertThat(json.parseObject(expected).amount()).isEqualTo(67.89);
//  }

}