package exercises.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassicCalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new ClassicCalculator();
    }

    @Test
    public void calculateWhenInputValueIsNull() {
        final Double expected = 0d;
        final Double actual = calculator.calculate(null);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenEmptyExpression() {
        final Double expected = 0d;
        final Double actual = calculator.calculate("");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenExpressionIsSingleValue() {
        final Double expected = 5d;
        final Double actual = calculator.calculate("5");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenAddTwoNumbers() {
        final Double expected = 7d;
        final Double actual = calculator.calculate("3 + 4");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenSubtractTwoNumbers() {
        final Double expected = 3d;
        final Double actual = calculator.calculate("7 - 4");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenDivideTwoNumbers() {
        final Double expected = 4d;
        final Double actual = calculator.calculate("16 / 4");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenMultiplyTwoNumbers() {
        final Double expected = 12d;
        final Double actual = calculator.calculate("3 * 4");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void calculateWhenComplexExpressionWithAllOperators() {
        final Double expected = 2.5d;
        final Double actual = calculator.calculate("4 + 3 - 2 * 5 / 10");
        assertThat(actual).isEqualTo(expected);
    }
}