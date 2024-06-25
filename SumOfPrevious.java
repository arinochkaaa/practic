package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array) {
        if (array.length < 2) {
            return new boolean[array.length];  // Возвращаем массив false такой же длины как и исходный
        }

        boolean[] result = new boolean[array.length];
        result[0] = false;  // Первый элемент не может быть суммой предыдущих, так как предыдущих нет
        result[1] = false;  // Второй элемент не может быть суммой предыдущих, так как только один предыдущий

        for (int i = 2; i < array.length; i++) {
            if (array[i] == array[i - 1] + array[i - 2]) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
