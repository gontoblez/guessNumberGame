package com.example.guessnumber;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to the game!");
        System.out.print("Please enter your name: ");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Would you like to play? note: enter y to play or any other input to abort");
        Scanner consentScanner = new Scanner(System.in);
        String consent = consentScanner.next();

        // let the user play if they want to play :P
        if (Objects.equals(consent, "y")) {
            System.out.println(" ");
            System.out.println("Alright. Let's begin!");

            // generate random number
            Random randomNum = new Random();
            int number = randomNum.nextInt(50) + 1;

            // instructions
            System.out.println("A random number between 1 and 50 has been generated.");
            System.out.println("You have 5 tries to guess the number.");
            System.out.println("With every wrong guess, the game will give you a hint to raise or lower your guess");
            System.out.println("Good luck!");

            // ask the user
            for (int i=0; i<5; i++) {
                System.out.println(" ");
                System.out.print("Enter your guess: ");
                Scanner answer = new Scanner(System.in);
                int guess = answer.nextInt();

                if (guess > 50 || guess < 1) {
                    System.out.println("The number is between 1 and 50!");
//                    System.out.println("You still have 5 chances. You're outstandingly stupid.");
//                    System.out.println("Therefore, none of your chances has been utilized, silly ;).");
                    System.out.println("You still have 5 chances.");
                    System.out.println("Try again...");
                    i--;
                    continue;
                }

                int triesLeft = 4-i;

                // processing input
                if (guess > number) {
                    System.out.println("Wrong!");
                    if (triesLeft != 0) {
                        System.out.println("Guess lower!");
                    }
                    System.out.println("Note: You got " + triesLeft + " more chance(s).");
                    if (triesLeft == 0) {
                        System.out.println("You lost the game.");
                        System.out.println("The correct answer was: " + number);
//                        System.out.println("You're a mistake. Your entire life is a joke!");
                    }
                } else if (guess < number) {
                    System.out.println("Wrong!");
                    if (triesLeft != 0) {
                        System.out.println("Guess higher!");
                    }
                    System.out.println("Note: You got " + triesLeft + " more chance(s).");
                    if (triesLeft == 0) {
                        System.out.println("You lost the game.");
                        System.out.println("The correct answer was: " + number);
//                        System.out.println("You're a mistake. Your entire life is a joke!");
                    }
                } else {
                    System.out.println("Congratulations, you have guessed the number!");
                    break;
                }
            }

        } else {
            System.out.println("Alright.");
            System.out.println("See you next time!");
        }

    }
}
