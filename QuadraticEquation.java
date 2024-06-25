package com.epam.rd.autotasks;

import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double a, b, c;


            while (true) {
                if (scanner.hasNextDouble()) {
                    a = scanner.nextDouble();
                    break;
                } else {

                    scanner.next(); 
                }
            }

            while (true) {
                if (scanner.hasNextDouble()) {
                    b = scanner.nextDouble();
                    break;
                } else {

                    scanner.next();
                }
            }

            while (true) {
                if (scanner.hasNextDouble()) {
                    c = scanner.nextDouble();
                    break;
                } else {

                    scanner.next();
                }
            }
            double D = b * b - 4 * a * c;

            if (D > 0) {
                double sqrtD = Math.sqrt(D);
                double x1 = (-b + sqrtD) / (2 * a);
                double x2 = (-b - sqrtD) / (2 * a);
                System.out.printf("%.6f %.6f\n", Math.min(x1, x2), Math.max(x1, x2));
            } else if (D == 0) {
                double x = -b / (2 * a);
                System.out.printf("%.6f\n", x);
            } else {
                System.out.println("no roots");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

