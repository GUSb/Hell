package exercises.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void testCalculate() {
        String expected = "9";
        String actual = Calculator.calculate("5 4 +");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAddAndSubtract() {
        String expected = "2";
        String actual = Calculator.calculate("5 4 + 7 -");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivide() {
        String expected = "2";
        String actual = Calculator.calculate("4 2 /");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiply() {
        String expected = "8";
        String actual = Calculator.calculate("2 4 *");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testComplexExpression() {
        String expected = "19";
        String actual = Calculator.calculate("18 4 2 * 8 / +");
        assertThat(actual).isEqualTo(expected);
    }
}
