package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LocalMaximaRemove {
    public static int[] removeLocalMaxima(int[] inputArray) {
        if (inputArray == null || inputArray.length <= 1) {
            throw new IllegalArgumentException("Input array must not be null and must have more than 1 element.");
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (isLocalMaximum(inputArray, i)) {
                continue;
            }
            result.add(inputArray[i]);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private static boolean isLocalMaximum(int[] array, int index) {
        if (index == 0) {
            return array[index] > array[index + 1];
        } else if (index == array.length - 1) {
            return array[index] > array[index - 1];
        } else {
            return array[index] > array[index - 1] && array[index] > array[index + 1];
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {18, 1, 3, 6, 7, -5};
        int[] resultArray = removeLocalMaxima(inputArray);
        System.out.println(Arrays.toString(resultArray));
    }
}
