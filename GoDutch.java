package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalAmount = scanner.nextInt();
        if (totalAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        int numberOfFriends = scanner.nextInt();
        if (numberOfFriends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }
        int totalWithTips = totalAmount + (totalAmount / 10);
        int amountPerFriend = totalWithTips / numberOfFriends;
        System.out.println(amountPerFriend);
    }
}

