package exercises.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapBasedStackTest {

    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new MapBasedStack<>();
    }

    @Test
    public void testNodePushed() {
        final String expected = "first stack node";
        stack.push(expected);
        final String actual = stack.pop();
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = RuntimeException.class)
    public void testStackIsEmptyException() {
        final String inputValueFirst = "first stack node";
        final String inputValueSecond = "second stack node";
        stack.push(inputValueFirst);
        stack.push(inputValueSecond);
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test()
    public void testNodePulled() {
        final String inputValueFirst = "first stack node";
        final String inputValueSecond = "second stack node";
        stack.push(inputValueFirst);
        stack.push(inputValueSecond);
        stack.pop();
        final String actual = stack.pop();
        assertThat(actual).isEqualTo(inputValueFirst);
    }

    @Test
    public void testPeak() {
        final String first = "input";
        final String second = "input";
        stack.push(first);
        stack.push(second);
        String actual = stack.peak();
        assertThat(actual).isEqualTo(second);
    }

    @Test
    public void testIsEmpty() {
        final String first = "input";
        final String second = "input";
        stack.push(first);
        stack.push(second);
        stack.pop();
        stack.pop();
        boolean actual = stack.isEmpty();
        assertThat(actual).isTrue();
    }

    @Test
    public void testIsNotEmpty() {
        final String first = "input";
        final String second = "input";
        stack.push(first);
        stack.push(second);
        boolean actual = stack.isEmpty();
        assertThat(actual).isFalse();
    }
}