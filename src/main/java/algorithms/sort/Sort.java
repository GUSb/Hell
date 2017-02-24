package algorithms.sort;

import static util.LogUtils.printArray;

public class Sort {

    private Sort() {
    }

    public static int[] bubbleSort(int[] elements) {
        boolean sorted = false;
        int currentElement;
        int nextElement;
        int index;

        while (!sorted) {
            printArray(elements);
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

    public static int[] insertionSort(int[] elements) {
        int rightIndex;
        int leftIndex;
        int elementToSort;

        for (rightIndex = 1; rightIndex < elements.length; rightIndex++) {

            printArray(elements);
            elementToSort = elements[rightIndex];

            for (leftIndex = rightIndex - 1;
                 leftIndex >= 0 && elementToSort < elements[leftIndex];
                 leftIndex--) {

                elements[leftIndex + 1] = elements[leftIndex];
            }
            elements[leftIndex + 1] = elementToSort;
        }
        printArray(elements);
        return elements;
    }

    public static int[] selectionSort(int[] elements) {
        int leftIndex;
        int rightIndex;
        int smallestElementIndex;
        int elementToSwap;

        for (leftIndex = 0; leftIndex < elements.length - 1; leftIndex++) {
            smallestElementIndex = leftIndex;

            for (rightIndex = leftIndex + 1; rightIndex < elements.length; rightIndex++) {
                if (elements[leftIndex] > elements[rightIndex]) {
                    smallestElementIndex = rightIndex;
                }
            }
            elementToSwap = elements[leftIndex];
            elements[leftIndex] = elements[smallestElementIndex];
            elements[smallestElementIndex] = elementToSwap;

            printArray(elements);
        }
        printArray(elements);
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
        printArray(elements);
        return elements;
    }

    public static int[] mergeSort(int[] elements) {
        if (elements.length == 1) {
            return elements;
        }

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
            printArray(merge);
        }

        return merge;
    }
}
