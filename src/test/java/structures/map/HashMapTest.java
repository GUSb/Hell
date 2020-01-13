package structures.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class HashMapTest {

  private HashMap<String, Integer> map;

  @Before
  public void setUp() throws Exception {
    // table[0] = 1
    // table[4] = 3 -> 2
    map = new HashMap<>();
    map.put("One", 1);
    map.put("Two", 2);
    map.put("Three", 3);
  }

  @Test
  public void putReturnsNullWhenKeyValuePairCurrentlyNotExist() throws Exception {
    Integer actual = map.put("Four", 4);
    assertThat(actual).isNull();
  }

  @Test
  public void putReturnsPreviouslyAssociatedValueIfMapContainsKey() throws Exception {
    Integer actual = map.put("One", 11);
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void putAlreadyExistedKeyOverridesValue() throws Exception {
    map.put("One", 11);
    assertThat(map.get("One")).isEqualTo(11);
  }

  @Test
  public void putAlreadyExistedKeyDoNotIncrementSize() throws Exception {
    map.put("One", 11);
    assertThat(map.size()).isEqualTo(3);
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
  public void removeDeletesNodeMappedToInputKeyWhenPairSizeIsOne() throws Exception {
    map.remove("One");
    assertThat(map.contains("One")).isFalse();
  }

  @Test
  public void removeDeletesNodeMappedToInputKeyWhenPairSizeIsMoreThanOne() throws Exception {
    map.remove("Two");
    assertThat(map.contains("Two")).isFalse();
  }

  @Test
  public void removeReturnsDeletedNodeValueWhenPairSizeIsOne() throws Exception {
    Integer actual = map.remove("One");
    assertThat(actual).isEqualTo(1);
  }

  @Test
  public void removeReturnsDeletedNodeValueWhenPairSizeIsMoreThanOne() throws Exception {
    Integer actual = map.remove("Two");
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void removeReturnsDeletedNodeValueWhenPairSizeIsMoreThanOneAndTargetedNodeIsFirstInList()
      throws Exception {
    Integer actual = map.remove("Three");
    assertThat(actual).isEqualTo(3);
  }

  @Test
  public void removeFewElementsDecreasesSize() throws Exception {
    map.remove("One");
    map.remove("Two");
    assertThat(map.size()).isEqualTo(1);
  }

  @Test
  public void removeAllElementsReturnsZeroSize() throws Exception {
    map.remove("One");
    map.remove("Two");
    map.remove("Three");
    assertThat(map.size()).isEqualTo(0);
  }

  @Test
  public void removeReturnsNullIfNoKeyFound() throws Exception {
    Integer actual = map.remove("Krakow");
    assertThat(actual).isNull();
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