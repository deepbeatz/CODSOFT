import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        // generate a random number between 1 and 100
        int answer = (int) (Math.random() * 100) + 1;
        // number of trials that the user has to guess the number
        int k = 10;
        // create a scanner object to read user input
        Scanner input = new Scanner(System.in);
        // TO check if the user has guessed the number
        boolean correct = false;
        System.out.println("Let's play the number guessing game...");
        System.out.println(
                "Do you want to enter your range or go with the range 1 to 100? Enter 1 for former and 2 for latter");
        int want = input.nextInt();
        int f = 0;
        int minRange=0, maxRange=0;
        if (want == 1) {
            minRange=1;
            maxRange=100;
        } else if (want == 2) {
            System.out.println("Enter least number in the range:");
            minRange = input.nextInt();
            System.out.println("Enter maximum number in the range:");
            maxRange = input.nextInt();
        } else {
            System.out.println("wrong input given! Run the program again please.");
            f = 1;
        }
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange
                + ".\nYou have 10 TRIES to guess the number.");
        while (k > 0 && f == 0) {
            System.out.println("Enter your guess (between 1 to 100): ");
            int guess = input.nextInt();
            // if the user guesses out of range, print the appropriate message and reduce no. of tries by 1
            if (guess > maxRange || guess < minRange) {
                System.out.println("The guessed number is not inside the range. You have " + (k - 1) + " tries left.");
                k--;
            }
            // if the user guesses correctly, print the congratulation message and exit the
            // program
            else if (guess == answer) {
                System.out.println("You guessed the number!\nYou win!");
                correct = true;
                input.close();
                break;
            }
            // if the user guesses greater than the number by a large amount, print the
            // message and reduce the number of
            // trials
            else if (guess > answer && (guess - answer) > 5) {
                System.out.println("Your guess is too high.\nYou have " + (k - 1) + " tries left.");
                k--;// after each trial decrease the number of trials by 1
            }
            // if the user guesses greater than the number slightly, print the message and
            // reduce the number of
            // trials
            else if (guess > answer && (guess - answer) <= 5) {
                System.out.println("Your guess is a bit high.\nYou have " + (k - 1) + " tries left.");
                k--;// after each trial decrease the number of trials by 1
            }
            // if the user guesses less than the number by a large amount, print the message
            // and reduce the number of
            // trials
            else if (guess < answer && (answer - guess) >= 5) {
                System.out.println("Your guess is too low.\nYou have " + (k - 1) + " tries left.");
                k--;// after each trial decrease the number of trials by 1
            } else {
                System.out.println("Your guess is a bit low.\nYou have " + (k - 1) + " tries left.");
                k--;// after each trial decrease the number of trials by 1
            }
        }
        // if the user has run out of trials, print the message and exit the program
        if (correct == false) {
            System.out.println("You ran out of tries.\nYou lose!");
            System.out.println("correct answer was: " + answer);
            input.close();
        }
    }
}
