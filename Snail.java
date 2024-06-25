package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // ввод скорости восхождения
        int b = scanner.nextInt(); // ввод скорости спуска
        int h = scanner.nextInt(); // ввод общей высоты столба
        scanner.close();

        int days = calculateDays(a, b, h);

        if (days == -1) {
            System.out.println("Impossible"); // вывод результата в случае невозможности достижения высоты
        } else {
            System.out.println(days); // вывод числа дней
        }
    }

    public static int calculateDays(int a, int b, int h) {
        if (a <= b) {
            return -1; // случай, когда улитка не может достичь высоты
        }

        int days = (h - b - 1) / (a - b) + 1;
        return days;
    }
}
