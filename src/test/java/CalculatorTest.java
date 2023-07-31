import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import taco.domain.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTest {

  @Test
  @Disabled
  void test_When_Minus_60_And_50(){

    Calculator calculator = new Calculator();
    double sum = calculator.minus(60, 50);
    assertEquals(10, sum);
  }

  @Test
  @Disabled("Feature still under development")
  void test_When_Add_10_And_50(){

    Calculator calculator = new Calculator();
    double sum = calculator.add(100, 50);
  assertEquals(150, sum);
  }


}
