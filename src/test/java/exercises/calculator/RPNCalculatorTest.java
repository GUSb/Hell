package exercises.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import structures.stack.ArrayBasedStack;

public class RPNCalculatorTest {

  private Calculator calculator;

  @Before
  public void setUp() {
    calculator = new RPNCalculator(new ArrayBasedStack<>(String.class));
  }

  @Test
  public void calculateWhenAddTwoNumbers() {
    Double expected = 9d;
    Double actual = calculator.calculate("5 4 +");
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculateWhenAddAndSubtractValues() {
    Double expected = 2d;
    Double actual = calculator.calculate("5 4 + 7 -");
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculateWhenDivideTwoValues() {
    Double expected = 2d;
    Double actual = calculator.calculate("4 2 /");
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculateWhenMultiplyTwoValues() {
    Double expected = 8d;
    Double actual = calculator.calculate("2 4 *");
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void calculateComplexExpressionUsingThreeDifferentOperators() {
    Double expected = 19d;
    Double actual = calculator.calculate("18 4 2 * 8 / +");
    assertThat(actual).isEqualTo(expected);
  }
}
