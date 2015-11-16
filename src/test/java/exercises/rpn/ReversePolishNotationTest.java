package exercises.rpn;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ReversePolishNotationTest {

    private ReversePolishNotation translator;

    @Before
    public void setUp() {
        translator = new ReversePolishNotation();
    }

    @Test
    public void testAddTwoValues() {
        String input = "5+6";
        String expected = "56+";
        String actual = translator.translate(input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testComplexExpressionWithEqualPriority() {
        String input = "5+6-7";
        String expected = "56+7-";
        String actual = translator.translate(input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void test() {
        String input = "5+6-7-8+1+5";
        String expected = "56+7-8-1+5+";
        String actual = translator.translate(input);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}