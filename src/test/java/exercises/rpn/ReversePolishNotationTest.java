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
}