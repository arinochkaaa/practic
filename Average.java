package com.epam.rd.autotasks;
import java.util.Scanner;

public class Average {
    public static int average() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
            count++;
        }
        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }
    public static void main(String[] args) {
        System.out.println(average());
    }
}
