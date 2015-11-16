package algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    public static final int[] EXPECTED = new int[] {1,2,3,4,5};
    public static int[] TESTED_ELEMENTS = new int[] {3,2,4,5,1};

    @Test
    public void testBubbleSort() {
        int[] actual = Sort.bubbleSort(TESTED_ELEMENTS);
        assertArrayEquals(actual, EXPECTED);
    }

    @Test
    public void testInsertionSort() {
        int[] actual = Sort.insertionSort(TESTED_ELEMENTS);
        assertArrayEquals(actual, EXPECTED);
    }

    @Test
    public void testSelectionSort() {
        int[] actual = Sort.selectionSort(TESTED_ELEMENTS);
        assertArrayEquals(actual, EXPECTED);
    }

    @Test
    public void testQuickSort() {
        int[] actual = Sort.quickSort(TESTED_ELEMENTS, 0, TESTED_ELEMENTS.length - 1);
        assertArrayEquals(actual, EXPECTED);
    }

    @Test
    public void testMergeSort() {
        //int[] actual = Sort.mergeSort(TESTED_ELEMENTS, 0, TESTED_ELEMENTS.length - 1);
        //assertArrayEquals(actual, EXPECTED);
    }
}
