package structures.list;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleLinkedListTest {

    private List<String> elements;

    @Before
    public void setUp() {
        elements = new SimpleLinkedList<>();
    }

    @Test
    public void sizeWhenEmptyList() {
        final int expected = 0;
        final int actual = elements.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void isEmptyReturnsTrueWhenNoElements() {
        final boolean result = elements.isEmpty();

        assertThat(result).isTrue();
    }

    @Test
    public void isEmptyReturnsFalseWhenAtLeastOneElement() {
        elements.add("One");

        final boolean result = elements.isEmpty();

        assertThat(result).isFalse();
    }

    @Test
    public void containsReturnTrueWhenListHasInputElement() {
        elements.add("One");

        final boolean result = elements.contains("One");

        assertThat(result).isTrue();
    }

    @Test
    public void containsReturnFalseWhenNoElementFound() {
        elements.add("Two");

        final boolean result = elements.contains("One");

        assertThat(result).isFalse();
    }

    @Test
    public void whenAddElementSizeGrows() {
        final int expected = 1;

        elements.add("one");

        assertThat(elements.size()).isEqualTo(expected);
    }

    @Test
    public void addReturnsTrueWhenElementAdded() {
        final int expected = 1;

        elements.add("one");

        assertThat(elements.size()).isEqualTo(expected);
    }
}
