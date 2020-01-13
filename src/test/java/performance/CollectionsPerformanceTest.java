package performance;

import static util.LogUtils.info;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CollectionsPerformanceTest {

  private CollectionsPerformance performance;
  private int size;
  private int randomization;
  private Integer node;
  private String message;

  public CollectionsPerformanceTest(int size, int randomization, Integer node, String message) {
    this.size = size;
    this.randomization = randomization;
    this.node = node;
    this.message = message;
  }

  @Parameterized.Parameters
  public static Collection timeNodes() {
    final String atStartMessage = "Operate with node at the BEGINNING of the list";
    final String inTheMiddleMessage = "Operate with node in the MIDDLE of the list";
    final String inTheEndMessage = "Operate with node in the END of the list";

    return Arrays.asList(new Object[][]{
        {100_000, 50_000, 0, atStartMessage},
        {1_000_000, 500_000, 0, atStartMessage},
        {10_000_000, 5_000_000, 0, atStartMessage},
        {50_000_000, 25_000_000, 0, atStartMessage},

        {100_000, 50_000, 25_000, inTheMiddleMessage},
        {1_000_000, 500_000, 250_000, inTheMiddleMessage},
        {10_000_000, 5_000_000, 2_500_000, inTheMiddleMessage},
        {50_000_000, 25_000_000, 12_500_000, inTheMiddleMessage},

        {100_000, 50_000, 50_000, inTheEndMessage},
        {1_000_000, 500_000, 500_000, inTheEndMessage},
        {10_000_000, 5_000_000, 5_000_000, inTheEndMessage},
        {50_000_000, 25_000_000, 25_000_000, inTheEndMessage}
    });
  }

  @Before
  public void setUp() {
    performance = new CollectionsPerformance();
  }

  @Test
  public void arrayListPerformance() {
    info(message);
    List<Integer> array = performance.generateArrayList(size, randomization);
    performance.sort(array);
    performance.addNode(array, node);
    performance.sort(array);
    performance.getNode(array, node);
    performance.deleteNode(array, node);
    performance.sort(array);
    performance.toLinkedList(array);
  }

  @Test
  public void linkedListPerformance() {
    info(message);
    List<Integer> linked = performance.generateLinkedList(size, randomization);
    performance.sort(linked);
    performance.addNode(linked, node);
    performance.sort(linked);
    performance.getNode(linked, node);
    performance.deleteNode(linked, node);
    performance.sort(linked);
    performance.toArrayList(linked);
  }
}
