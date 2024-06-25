package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {

    public static int max() {
        Scanner scanner = new Scanner(System.in);
        int maxValue = Integer.MIN_VALUE;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (number > maxValue) {
                maxValue = number;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        System.out.println(max());
    }
}
