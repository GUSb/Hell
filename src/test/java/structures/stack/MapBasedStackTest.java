package structures.stack;

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
    public void nodePushed() {
        final String expected = "first stack node";
        stack.push(expected);
        final String actual = stack.pop();
        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = RuntimeException.class)
    public void stackIsEmptyException() {
        final String inputValueFirst = "first stack node";
        final String inputValueSecond = "second stack node";
        stack.push(inputValueFirst);
        stack.push(inputValueSecond);
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test()
    public void nodePulled() {
        final String inputValueFirst = "first stack node";
        final String inputValueSecond = "second stack node";
        stack.push(inputValueFirst);
        stack.push(inputValueSecond);
        stack.pop();
        final String actual = stack.pop();
        assertThat(actual).isEqualTo(inputValueFirst);
    }

    @Test
    public void peak() {
        final String first = "One";
        final String second = "Two";
        stack.push(first);
        stack.push(second);
        String actual = stack.peak();
        assertThat(actual).isEqualTo(second);
    }

    @Test
    public void isEmpty() {
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
    public void isNotEmpty() {
        final String first = "input";
        final String second = "input";
        stack.push(first);
        stack.push(second);
        boolean actual = stack.isEmpty();
        assertThat(actual).isFalse();
    }

    @Test
    public void reverse() {
        final String first = "One";
        final String second = "Two";
        final String third = "Three";
        stack.push(first);
        stack.push(second);
        stack.push(third);
        Stack<String> reversedStack = stack.reverse();
        String actual = reversedStack.peak();
        assertThat(actual).isEqualTo(first);
    }

    @Test
    public void size() {
        final String first = "One";
        final String second = "Two";
        final String third = "Three";
        stack.push(first);
        stack.push(second);
        stack.push(third);
        int expected = 3;
        int actual = stack.size();
        assertThat(actual).isEqualTo(expected);
    }
}