package exercises.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void calculate() {
        String expected = "9";
        String actual = calculator.calculate("5 4 +");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void addAndSubtract() {
        String expected = "2";
        String actual = calculator.calculate("5 4 + 7 -");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void divide() {
        String expected = "2";
        String actual = calculator.calculate("4 2 /");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiply() {
        String expected = "8";
        String actual = calculator.calculate("2 4 *");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void complexExpression() {
        String expected = "19";
        String actual = calculator.calculate("18 4 2 * 8 / +");
        assertThat(actual).isEqualTo(expected);
    }
}
