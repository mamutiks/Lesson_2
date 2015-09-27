package com.diosoft.training;

import java.util.Arrays;

public class MainArrays {

    public static void main(String[] args) {
        testPositiveForLeftUnion();
        //testLeftArrayIsEmpty();
        //testLeftArrayIsNull();
        testPositiveForMerge();
        testPositiveForInnerUnion();
        testPositiveForOuterUnion();
    }

    private static void testPositiveForLeftUnion() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {1, 5, 4, 23, 65, 32, 78, 5, 4, 1, 32, 5};

        System.out.println("testPositiveForLeftUnion");

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    private static void testPositiveForMerge() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 54, 1, 2, 34, 45, 32};
        int[] expectedArrays = {1, 5, 23, 65, 32, 78, 3, 24, 54, 2, 34, 45};

        System.out.println("testPositiveForMerge");

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.merge(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    private static void testPositiveForInnerUnion() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {5, 4, 1, 32};

        System.out.println("testPositiveForInnerUnion");

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.innerUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    private static void testPositiveForOuterUnion() {
        int[] leftArray = {1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {23, 65, 78, 3, 24, 2, 34, 45};

        System.out.println("testPositiveForOuterUnion");

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.outerUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    private static void testLeftArrayIsEmpty() {
        int[] leftArray = {};
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("testLeftArrayIsEmpty");

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    private static void testLeftArrayIsNull() {
        int[] leftArray = null;
        int[] rightArray = {3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedArrays = {};

        System.out.println("LeftArray: " + Arrays.toString(leftArray));
        System.out.println("RightArray: " + Arrays.toString(rightArray));

        MainArrays main = new MainArrays();
        int[] returnValue = main.leftUnion(leftArray, rightArray);

        System.out.println("ReturnValue: " + Arrays.toString(returnValue));
        System.out.println("ExpectedArrays: " + Arrays.toString(expectedArrays));

        System.out.println("-------------------------");
    }

    public int[] leftUnion(int[] leftArray, int[] rightArray) {

        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);

        System.out.println("BuffArray: " + Arrays.toString(buffArray));
        int countOfFoundedElementsInRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    buffArray[leftArray.length + countOfFoundedElementsInRightArray] = rightArrayElement;
                    countOfFoundedElementsInRightArray++;
                }
            }
        }
        System.out.println("Count of founded elements = " + countOfFoundedElementsInRightArray);

        System.out.println("BuffArray after search: " + Arrays.toString(buffArray));

        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundedElementsInRightArray);

        return resultArray;
    }

    public int[] merge(int[] leftArray, int[] rightArray) {

        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);

        System.out.println("BuffArray: " + Arrays.toString(buffArray));
        int countOfFoundedElementsInRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    break;
                } else {
                    if ((rightArrayElement != leftArrayElement) && (leftArrayElement == (leftArray.length - 1))) {
                        buffArray[leftArray.length + countOfFoundedElementsInRightArray] = rightArrayElement;
                        countOfFoundedElementsInRightArray++;
                    }
                }
            }
        }
        System.out.println("Count of founded elements = " + countOfFoundedElementsInRightArray);

        System.out.println("BuffArray after search: " + Arrays.toString(buffArray));

        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundedElementsInRightArray);

        return resultArray;
    }

    public int[] innerUnion(int[] leftArray, int[] rightArray) {

        int[] buffArray = (leftArray.length > rightArray.length) ?  new int[leftArray.length] : new int[rightArray.length];

        System.out.println("BuffArray: " + Arrays.toString(buffArray));
        int countOfFoundedElementsInRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    buffArray[countOfFoundedElementsInRightArray] = rightArrayElement;
                    countOfFoundedElementsInRightArray++;
                } else {
                    continue;
                }
            }
        }
        System.out.println("Count of founded elements = " + countOfFoundedElementsInRightArray);

        System.out.println("BuffArray after search: " + Arrays.toString(buffArray));

        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundedElementsInRightArray);

        return resultArray;
    }

    public int[] outerUnion(int[] leftArray, int[] rightArray) {

        int[] buffArray = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);

        System.out.println("BuffArray: " + Arrays.toString(buffArray));
        int countOfFoundedElementsInRightArray = 0;

        for (int rightArrayElement : rightArray) {
            for (int leftArrayElement : leftArray) {
                if (rightArrayElement == leftArrayElement) {
                    break;
                } else {
                    if ((rightArrayElement != leftArrayElement) && (leftArrayElement == (leftArray.length - 1))) {
                        buffArray[countOfFoundedElementsInRightArray] = rightArrayElement;
                        countOfFoundedElementsInRightArray++;
                    }
                }
            }
        }

        for (int leftArrayElement : leftArray) {
            for (int rightArrayElement : rightArray) {
                if (leftArrayElement == rightArrayElement) {
                    break;
                } else {
                    if ((leftArrayElement != rightArrayElement) && (rightArrayElement == (rightArray.length - 1))) {
                        buffArray[countOfFoundedElementsInRightArray] = leftArrayElement;
                        countOfFoundedElementsInRightArray++;
                    }
                }
            }
        }

        System.out.println("Count of founded elements = " + countOfFoundedElementsInRightArray);

        System.out.println("BuffArray after search: " + Arrays.toString(buffArray));

        int[] resultArray = Arrays.copyOf(buffArray, leftArray.length + countOfFoundedElementsInRightArray);

        return resultArray;
    }

}
