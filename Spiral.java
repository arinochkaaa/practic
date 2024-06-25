
package com.epam.rd.autotasks;

public class Spiral {

    public static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Move from left to right
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            // Move from top to bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                // Move from right to left
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                // Move from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] spiral1 = Spiral.spiral(3, 4);
        for (int[] row : spiral1) {
            for (int val : row) {
                System.out.print(String.format("%4d", val));
            }
            System.out.println();
        }

        System.out.println();

        // Test case 2
        int[][] spiral2 = Spiral.spiral(4, 3);
        for (int[] row : spiral2) {
            for (int val : row) {
                System.out.print(String.format("%4d", val));
            }
            System.out.println();
        }

        System.out.println();

        // Test case 3
        int[][] spiral3 = Spiral.spiral(5, 6);
        for (int[] row : spiral3) {
            for (int val : row) {
                System.out.print(String.format("%4d", val));
            }
            System.out.println();
        }

        System.out.println();

        // Test case 4
        int[][] spiral4 = Spiral.spiral(5, 5);
        for (int[] row : spiral4) {
            for (int val : row) {
                System.out.print(String.format("%4d", val));
            }
            System.out.println();
        }
    }
}
