package com.epam.rd.autotasks.pizzasplit;
import java.util.Scanner;

public class PizzaSplit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = scanner.nextInt();
        int piecesPerPizza = scanner.nextInt();

        int totalPiecesNeeded = numberOfPeople * piecesPerPizza;
        int currentPieces = piecesPerPizza;
        int numberOfPizzas = 1;

        while (currentPieces < totalPiecesNeeded) {
            currentPieces += piecesPerPizza;
            numberOfPizzas++;
        }

        System.out.println(numberOfPizzas);
    }
}
