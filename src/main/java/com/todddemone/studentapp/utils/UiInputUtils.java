package com.todddemone.studentapp.utils;

import java.util.Scanner;
import java.util.InputMismatchException;

public final class UiInputUtils {

    private UiInputUtils() {
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        int result = 0;
        while (true) {
            System.out.print(prompt + ": ");
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                // If invalid input was placed in the input buffer by scanner.nextInt() (see
                // above), we need
                // scanner.nextLine() to discard that input from the buffer. Otherwise, the
                // input stays there and the
                // loop keeps seeing invalid input and keeps looping indefinitely.
                scanner.nextLine();
            }
        }
        return result;
    }

    public static String readString(String prompt) {
        String result = "";
        while (true) {
            System.out.print(prompt + ": ");
            try {
                result = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a string.");
                scanner.nextLine();
            }
        }
        return result;
    }
}
