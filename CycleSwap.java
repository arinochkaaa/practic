package com.epam.rd.autotasks;

import java.util.Arrays;

    public class CycleSwap {

        public static void cycleSwap(int[] array) {
            if (array == null || array.length == 0) {
                return;
            }

            int lastElement = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = lastElement;
        }

        public static void cycleSwap(int[] array, int shift) {
            if (array == null || array.length == 0 || shift == 0) {
                return;
            }

            int length = array.length;
            shift = shift % length; // If shift is greater than the length of the array

            if (shift == 0) {
                return;
            }

            // Create a copy of the array with shifted elements
            int[] temp = Arrays.copyOf(array, length);

            System.arraycopy(temp, length - shift, array, 0, shift);
            System.arraycopy(temp, 0, array, shift, length - shift);
        }

        public static void main(String[] args) {
            int[] array1 = {1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array1);
            System.out.println(Arrays.toString(array1)); // [4, 1, 3, 2, 7]

            int[] array2 = {1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array2, 2);
            System.out.println(Arrays.toString(array2)); // [7, 4, 1, 3, 2]

            int[] array3 = {1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array3, 5);
            System.out.println(Arrays.toString(array3)); // [1, 3, 2, 7, 4]
        }
    }
