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
}