package algorithms.sort;

public class Sort {

    /**
     * O(n^2)
     */
    public static int[] bubbleSort(int[] elements) {
        boolean sorted = false;
        int currentElement;
        int nextElement;
        int index;

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
                }
            }
        }
        return elements;
    }

    /**
     * O(n^2)
     */
    public static int[] insertionSort(int[] elements) {
        int rightIndex;
        int leftIndex;
        int elementToSort;

        for (rightIndex = 1; rightIndex < elements.length; rightIndex++) {

            printElements(elements);
            elementToSort = elements[rightIndex];

            for (leftIndex = rightIndex - 1;
                 leftIndex >= 0 && elementToSort < elements[leftIndex];
                 leftIndex--) {

                elements[leftIndex + 1] = elements[leftIndex];
            }
            elements[leftIndex + 1] = elementToSort;
        }
        printElements(elements);
        return elements;
    }

    /**
     * O(n^2)
     */
    public static int[] selectionSort(int[] elements) {
        int leftIndex;
        int rightIndex;
        int smallestElementIndex;
        int elementToSwap;

        for (leftIndex = 0; leftIndex < elements.length - 1; leftIndex++) {
            smallestElementIndex = leftIndex;

            for (rightIndex = 1; rightIndex < elements.length; rightIndex++) {
                if (elements[leftIndex] > elements[rightIndex]) {
                    smallestElementIndex = rightIndex;
                }
            }
            elementToSwap = elements[leftIndex];
            elements[leftIndex] = elements[smallestElementIndex];
            elements[smallestElementIndex] = elementToSwap;

            printElements(elements);
        }
        printElements(elements);
        return elements;
    }

    public static int[] quickSort(int[] elements, int lowerIndex, int higherIndex) {
        int startLowerIndex = lowerIndex;
        int startHigherIndex = higherIndex;
        int temp;
        int pivot = elements[lowerIndex + (higherIndex - lowerIndex)/2];

        while (lowerIndex <= higherIndex) {
            while (elements[lowerIndex] < pivot) {
                lowerIndex++;
            }
            while (elements[higherIndex] > pivot) {
                higherIndex--;
            }
            if (lowerIndex <= higherIndex) {
                temp = elements[higherIndex];
                elements[higherIndex] = elements[lowerIndex];
                elements[lowerIndex] = temp;

                lowerIndex++;
                higherIndex--;
            }
            if (lowerIndex < startHigherIndex) {
                quickSort(elements, lowerIndex, startHigherIndex);
            }
            if (higherIndex > startLowerIndex) {
                quickSort(elements, startLowerIndex, higherIndex);
            }
        }
        printElements(elements);
        return elements;
    }

/*    public static int[] mergeSort(int[] elements, int lowerIndex, int higherIndex) {
        int middleIndex;

        if (lowerIndex < higherIndex) {
            middleIndex = elements[lowerIndex + (higherIndex - lowerIndex) / 2];

            mergeSort(elements, lowerIndex, middleIndex);
            mergeSort(elements, middleIndex + 1, higherIndex);

            merge(lowerIndex, higherIndex, middleIndex, elements);
        }

        return elements;
    }

    private static void merge(int lowerIndex, int higherIndex, int middleIndex, int[] elements) {
        int[] temp = new int[elements.length];
        int startLowerIndex = lowerIndex;
        int startHigherIndex = higherIndex;
        int startMiddleIndex = middleIndex;

        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp[i] = elements[i];
        }
        while () {

        }
    }*/

    private static void printElements(int[] elements) {
        for (int element : elements) {
            System.out.print("[" + element + "] ");
        }
        System.out.println();
    }
}
