package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        scanner.close(); // исправлено имя переменной на scanner

        int hours = (seconds / 3600) % 24;
        int minutes = (seconds / 60) % 60;
        int remainingSeconds = seconds % 60; // исправлено имя переменной на remainingSeconds

        // Использование printf вместо println для форматированного вывода
        System.out.printf("%d:%02d:%02d\n", hours, minutes, remainingSeconds);
    }
}
