import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
//import org.junit.jupiter.api.condition.EnabledOnOs;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
import taco.domain.Calculator;
import taco.domain.Ingredient;
import taco.domain.IngredientType;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class Test_Class {

//  Calculator calculator = new Calculator();
//
//  Ingredient ingredient = new Ingredient("d","Cheese", IngredientType.CHEESE);
//
//  @Test
//  @Tag("taxes")
//  void testingTaxCalculation(){
//
//  }
//
//  @Test
//  void testOnlyOnCiServer(){
//    assumeTrue("CI".equals(System.getenv("ENV")));
//
//  }
//
//  @Test
//  void testOnlyOnDeveloperWorkstation() {
//    assertTrue("DEV".equals(System.getenv("ENV")),()->"Aborting test : not on developer workstation");
//  }
//
//  @Test
//  @DisabledOnOs(WINDOWS)
//  void testInAllEnvironments() {
//    assumingThat("CI".equals(System.getenv("ENV")),
//            () -> {
//              // perform these assertions only on the CI server
//              assertEquals(2, calculator.divide(4, 2));
//            });
//    // perform these assertions in all environments
//    assertEquals(42, calculator.multiply(6, 7));
//  }
//
//
//  @Test
//  void exceptionTesting(){
//    Exception exception = assertThrows(ArithmeticException.class,()-> calculator.divide(0,0));
//    System.out.println(exception.getClass());
//
//
//  }
//
//  @Test
//  void dependentAssertions(){
//    assertAll("properties",
//    ()->{
//      String name = ingredient.getName();
//      assertEquals("Cheese", name);
//      assertAll("First name",
//              ()->assertTrue(name.startsWith("C")),
//              ()->assertTrue(name.endsWith("e")));
//    },
//            ()->{});
//  }
//
//  @Test
//  void standardAssertions(){
//    assertEquals(2,calculator.add(1,1));
//    assertEquals(4,calculator.multiply(2,2), "The optional failure message is now the last " +
//            "Parameter");
//
//    assertTrue('c'<'b',"wwwwwwwwwwwwww");
//  }
//
//  @Test
//  void groupedAssertions(){
//    assertAll("ingredient",
//            ()->assertEquals(1,1),
//            ()->assertEquals(3,2)
//            );
//  }
//
//  @DisplayName("A negative value for year is not supported by the leap year computation")
//  @ParameterizedTest(name = "For example, year {0} is not supported.")
//  @ValueSource(ints = {-1,-4})
//  void if_it_is_negative(int year){
//
//  }
//
//  @Nested
//  @IndicativeSentencesGeneration( generator =
//          DisplayNameGenerator.ReplaceUnderscores.class)
//  class A_year_is_a_leap_year {
//    @ParameterizedTest(name = "Year {0} is a leap year.")
//    @ValueSource(ints = { 2016, 2020, 2048 })
//    void if_it_is_one_of_the_following_years(int year) {
//
//
//    }
//  }

}
