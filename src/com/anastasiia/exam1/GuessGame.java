package com.anastasiia.exam1;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        int attempts = 0;
        int currentGuess = 0;

        int targetNumberToGuess = generator.nextInt(1000);

        System.out.println("Random number was picked between 0 and 1000");

        while (currentGuess != targetNumberToGuess) {
            attempts++;

            System.out.print("Guess what number it is: ");
            currentGuess = input.nextInt();

            if (currentGuess < targetNumberToGuess) {
                System.out.println("Incorrect! Enter a bigger number");
            } else if (currentGuess > targetNumberToGuess) {
                System.out.println("Incorrect! Enter a smaller number");
            } else {
                System.out.printf("Correct! You guessed it in %d attempts", attempts);
            }
        }
    }
}
