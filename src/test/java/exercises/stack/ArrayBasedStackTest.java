package exercises.stack;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayBasedStackTest {

    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new ArrayBasedStack<>(String.class);
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
    public void testIfStackResized() {
        final int expectedSize = 100;
        final String input = "input";
        addNodes(expectedSize);
    }

    private void addNodes(int size) {
        for (int i = 0; i < size; i++) {
            stack.push(String.valueOf(i));
        }
    }
}