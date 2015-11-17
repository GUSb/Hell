package exercises.calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void testCalculate() {
        String expected = "9";
        String actual = Calculator.calculate("54+");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAddAndSubtract() {
        String expected = "2";
        String actual = Calculator.calculate("54+7-");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDivide() {
        String expected = "2";
        String actual = Calculator.calculate("42/");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testMultiply() {
        String expected = "8";
        String actual = Calculator.calculate("24*");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testComplexExpression() {
        String expected = "9";
        String actual = Calculator.calculate("842*8/+");
        assertThat(actual).isEqualTo(expected);
    }
}
