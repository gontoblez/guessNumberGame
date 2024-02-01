package com.example.guessnumber;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Level level = new Level("Level 1", 1, 50, 5, true);

        System.out.println("Hello and welcome to the game!");
        System.out.print("Please enter your name: ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println("Would you like to play? (Enter 'y' to play or any other input to abort)");
        String consent = scanner.next();

        if (!consent.equalsIgnoreCase("y")) {
            System.out.println("Alright. See you next time!");
            return;
        }

        // let the user play if they want to play :P
        System.out.println("\nAlright. Let's begin!");

        // instructions
        while (level.getProgress()) {
            // generate random number
            int number = random.nextInt(level.getRange()) + 1;

            // ask the user
            System.out.println("\nWelcome to level " + level.getLevelNumber() + "!");
            System.out.print("A random number between 1 and " + level.getRange() + " has been generated.\n");
            System.out.println("You have " + level.getTries() + " tries to guess the number.");
            System.out.println("With every wrong guess, the game will give you a hint to raise or lower your guess");
            System.out.println("Good luck!");

            for (int i = 0; i < level.getTries(); i++) {
                System.out.println(" ");
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                int triesLeft = level.getTries() - 1 - i;

                if (guess != number) {
                    System.out.println("Wrong");
                    if (triesLeft != 0) {
                        System.out.println("Guess " + (guess > number ? "lower!" : "higher!"));
                    }
                    System.out.println("Note: You have " + triesLeft + " more chance(s).");
                    if (triesLeft == 0) {
                        System.out.println("You lost the game.");
                        System.out.println("The correct answer was: " + number);
                        level.setProgress(false);
                    }
                } else {
                    System.out.println("Congratulations, you have guessed the number!");
                    if (level.getLevelNumber() < 3) {
                        System.out.print("Would you like to progress to the next level ?[Y/n] ");
                        String continueInput = scanner.next();
                        if (!continueInput.equalsIgnoreCase("y")) {
                            System.out.println("Alright. See you soon!");
                            level.setProgress(false);
                            break;
                        }
                        level.setLevelNumber(level.getLevelNumber() + 1);
                        if (level.getLevelNumber() == 2) {
                            level = new Level("Level 2", 2, 70, 4, true);
                        } else if (level.getLevelNumber() == 3) {
                            level = new Level("Level 3", 3, 100, 3, true);
                        }
                        break;
                    } else if (level.getLevelNumber() == 3) {
                        System.out.println("You have beaten the game. Congratulations!");
                        level.setProgress(false);
                        break;
                    }
                }
            }
        }
    }
}
