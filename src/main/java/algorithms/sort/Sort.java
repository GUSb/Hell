package algorithms.sort;

import java.util.Arrays;

public class Sort {

    public static int[] bubbleSort(int[] elements) {
        boolean sorted = false;
        int currentElement;
        int nextElement;
        int index;

        // for statistics
        int itr = 0;
        int swaps = 0;

        while (!sorted) {
            printElements(elements);
            sorted = true;
            for (index = 0; index < elements.length - 1; index++) {
                currentElement = elements[index];
                nextElement = elements[index + 1];
                if (currentElement > nextElement) {
                    elements[index] = nextElement;
                    elements[index + 1] = currentElement;
                    sorted = false;
                    swaps++;
                }
                itr++;
            }
        }
        printStatistic(itr, swaps, swaps);
        return elements;
    }

    public static int[] insertionSort(int[] elements) {
        int rightIndex;
        int leftIndex;
        int elementToSort;

        // for statistics
        int itr = 0;

        for (rightIndex = 1; rightIndex < elements.length; rightIndex++) {

            printElements(elements);
            elementToSort = elements[rightIndex];

            for (leftIndex = rightIndex - 1;
                 leftIndex >= 0 && elementToSort < elements[leftIndex];
                 leftIndex--) {

                elements[leftIndex + 1] = elements[leftIndex];
                itr++;
            }
            elements[leftIndex + 1] = elementToSort;
            itr++;
        }
        printElements(elements);
        printStatistic(itr, 0, 0);
        return elements;
    }

    public static int[] selectionSort(int[] elements) {
        int leftIndex;
        int rightIndex;
        int smallestElementIndex;
        int elementToSwap;

        // for statistics
        int itr = 0;
        int swaps = 0;
        int checks = 0;

        for (leftIndex = 0; leftIndex < elements.length - 1; leftIndex++) {
            smallestElementIndex = leftIndex;

            for (rightIndex = leftIndex + 1; rightIndex < elements.length; rightIndex++) {
                if (elements[leftIndex] > elements[rightIndex]) {
                    smallestElementIndex = rightIndex;
                    checks++;
                }
                itr++;
            }
            elementToSwap = elements[leftIndex];
            elements[leftIndex] = elements[smallestElementIndex];
            elements[smallestElementIndex] = elementToSwap;

            itr++;
            swaps++;
            printElements(elements);
        }
        printElements(elements);
        printStatistic(itr, swaps, checks);
        return elements;
    }

    public static int[] quickSort(int[] elements, int lowerIndex, int higherIndex) {
        int startLowerIndex = lowerIndex;
        int startHigherIndex = higherIndex;
        int temp;
        int pivot = elements[lowerIndex + (higherIndex - lowerIndex)/2];

        // for statistics
        int itr = 0;
        int swaps = 0;
        int checks = 0;

        while (lowerIndex <= higherIndex) {
            itr++;
            while (elements[lowerIndex] < pivot) {
                itr++;
                lowerIndex++;
            }
            while (elements[higherIndex] > pivot) {
                itr++;
                higherIndex--;
            }
            if (lowerIndex <= higherIndex) {
                temp = elements[higherIndex];
                elements[higherIndex] = elements[lowerIndex];
                elements[lowerIndex] = temp;

                lowerIndex++;
                higherIndex--;
                swaps++;
                checks++;
            }
            if (lowerIndex < startHigherIndex) {
                checks++;
                quickSort(elements, lowerIndex, startHigherIndex);
            }
            if (higherIndex > startLowerIndex) {
                checks++;
                quickSort(elements, startLowerIndex, higherIndex);
            }
        }
        printElements(elements);
        printStatistic(itr, swaps, checks);
        return elements;
    }

    public static int[] mergeSort(int[] elements) {
        if (elements.length == 1) return elements;

        int middle = (elements.length) / 2;
        int[] left = new int[middle];
        int[] right = new int[elements.length - middle];
        System.arraycopy(elements, 0, left, 0, left.length);
        System.arraycopy(elements, left.length, right, 0, right.length);

        int[] subLeft = mergeSort(left);
        int[] subRight = mergeSort(right);

        return merge(subLeft, subRight);
    }

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int lSize = arrLeft.length;
        int rSize = arrRight.length;
        int[] merge = new int[lSize + rSize];

        int lIndex = 0;
        int rIndex = 0;

        for (int i = 0; i < merge.length; i++) {
            if (rIndex >= rSize || lIndex < lSize && arrLeft[lIndex] <= arrRight[rIndex]) {
                merge[i] = arrLeft[lIndex];
                lIndex++;
            } else {
                merge[i] = arrRight[rIndex];
                rIndex++;
            }
            System.out.println(Arrays.toString(merge));
        }

        return merge;
    }

    private static void printElements(int[] elements) {
        for (int element : elements) {
            System.out.print("[" + element + "] ");
        }
        System.out.println();
    }

    private static void printStatistic(int itr, int swaps, int check) {
        System.out.println(String.format(" itr: %s \n swaps: %s \n checks: %s", itr, swaps, check));
    }
}
