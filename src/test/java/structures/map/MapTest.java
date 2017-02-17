package structures.map;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {

    private Map<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new Map<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
    }

    @Test
    public void putReturnsFalseWhenInputValueIsNull() throws Exception {
        boolean actual = map.put("One", null);
        assertThat(actual).isFalse();
    }

    @Test
    public void putValueToMapReturnsTrue() throws Exception {
        boolean actual = map.put("Four", 4);
        assertThat(actual).isTrue();
    }

    @Test
    public void putKeyTahAlreadyExistsReturnsFalse() throws Exception {
        boolean actual = map.put("One", 1);
        assertThat(actual).isFalse();
    }

    @Test
    public void containsReturnTrueWhenMapHasInputKey() throws Exception {
        boolean actual = map.contains("Two");
        assertThat(actual).isTrue();
    }

    @Test
    public void containsReturnFalseWhenMapHasNotInputKey() throws Exception {
        boolean actual = map.contains("Krakow");
        assertThat(actual).isFalse();
    }

    @Test
    public void sizeGrowsWhenAddedNewNode() throws Exception {
        map.put("Four", 4);
        int expected = 4;
        int actual = map.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sizeDecreasesAfterRemovingTheNode() throws Exception {
        map.remove("One");
        int expected = 2;
        int actual = map.size();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getReturnsProperValueWhenKeyExists() throws Exception {
        int expected = 1;
        int actual = map.get("One");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getReturnsNullWhenNoKeyFound() throws Exception {
        assertThat(map.get("Krakow")).isNull();
    }
}