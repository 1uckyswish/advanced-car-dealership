package com.yearup.dealership.UtilityMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UtilityMethods {
    /**
     * Validates user input to ensure it is an integer.
     * Prompts the user with the given message until a valid integer is entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter an integer
     * @return The valid integer entered by the user
     */
    public static int validateIntInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        int input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for an Int, and it feeds it, then apply it
            // to the variable
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                // Break out the loop when it matches
                break;
            } else {
                // If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        // return the user input
        return input;
    }

    /**
     * Validates user input to ensure it is a non-empty string.
     * Prompts the user with the given message until a valid non-empty string is
     * entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter a string
     * @return The valid non-empty string entered by the user
     */
    public static String validateStringInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        String input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for a String, and it feeds it, then apply
            // it to the variable
            if (scanner.hasNextLine()) {
                // Break out the loop when it matches
                input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    break;
                }
            }
            // If user types something else then Int it will alert the user
            System.out.println("\n==== Sorry, that input is invalid. Please enter a valid non-empty string ===\n");
        }
        // return the user input
        return input;
    }

    /**
     * Validates user input to ensure it is a valid double value.
     * Prompts the user with the given message until a valid double value is
     * entered.
     *
     * @param scanner The Scanner object used to read user input
     * @param prompt  The message prompting the user to enter a double value
     * @return The valid double value entered by the user
     */
    public static double validateDoubleInput(Scanner scanner, String prompt) {
        // Set a starter value to use for returning
        double input;
        // Use a while loop to keep prompting till it breaks out the loop
        while (true) {
            // Print out the question for user to respond to
            System.out.print(prompt);
            // If the scanner notices its asking for a Double, and it feeds it, then apply
            // it to the variable
            if (scanner.hasNextDouble()) {
                // Break out the loop when it matches
                input = scanner.nextDouble();
                break;
            } else {
                // If user types something else then Int it will alert the user
                System.out.println("\n==== Sorry, that input is invalid. Please enter a valid numeric value ===\n");
                scanner.next(); // Consume invalid input
            }
        }
        // return the user input
        return input;
    }

    /**
     * Gets the current date and returns it as a formatted string.
     * @return A string representation of the current date in the format 'yyyyMMdd'.
     */
    public static String contractDateStamp() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the date as 'yyyyMMdd'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);

        return formattedDate;
    }

}
