package com.example.guessnumber;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to the game!");
        System.out.print("Please enter your name: ");
        Scanner scanner = new Scanner(System.in);
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
            int level = 1;
            boolean play = true;

            // instructions
            while (level < 4 && play) {
                System.out.println(level);
                if (level == 3) {
                    play = false;
                }
                // generate random number
                Random randomNum = new Random();
                int number = 0;
                if (level == 1) {
                    number =randomNum.nextInt(50) + 1;
                } else if (level == 2) {
                    number = randomNum.nextInt(70) + 1;
                } else if (level == 3) {
                    number = randomNum.nextInt(100) + 1;
                }

                // ask the user
                System.out.println("Welcome to level " + level + "!");
                System.out.print("A random number between 1 and ");
                if (level == 1) {
                    System.out.print("50");
                } else if (level == 2) {
                    System.out.print("70");
                } else if (level == 3) {
                    System.out.print("100");
                }
                System.out.print(" has been generated.\n");
                System.out.println("You have 5 tries to guess the number.");
                System.out.println("With every wrong guess, the game will give you a hint to raise or lower your guess");
                System.out.println("Good luck!");

                for (int i = 0; i < 5; i++) {
                    System.out.println(number);
                    System.out.println(" ");
                    System.out.print("Enter your guess: ");
                    Scanner answer = new Scanner(System.in);
                    int guess = answer.nextInt();

                    int triesLeft = 4 - i;

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
                            play = false;
                            break;
//                        System.out.println("You're a mistake. Your entire life is a joke!");
                        }
                    } else {
                        System.out.println("Congratulations, you have guessed the number!");
                        triesLeft = 0;
                        System.out.println("You now have " + triesLeft + " tries left. The number of tries will now be reset.");
                        if (level < 3) {
                            System.out.print("Would you like to progress to the next level ?[Y/n]\t");
                            String continu = scanner.next();
                            if (continu.equals("N") || continu.equals("n")) {
                                break;
                            } else if (continu.equals("Y") || continu.equals("y") || continu.equals("")) {
                                level++;
                                System.out.println(level);
                                triesLeft = 4;
                                break;
                            }
                        } else if (level == 3) {
                            System.out.println("You have beaten the game. Congratulations!");
                            play = false;
                            break;
                        }
                    }
                }
            }

        } else {
            System.out.println("Alright.");
            System.out.println("See you next time!");
        }

    }
}
