package pl.isa.backendBoys.zgubaAppWeb.abstractMenu;

import pl.isa.backendBoys.zgubaAppWeb.request.RequestMenu;

import java.util.Scanner;

public abstract class AppMenu {
    private static String loggedUserLogin;

    public abstract void printOptions();

    protected String getStringFromUser(String inputMessage) {
        String errorInputMessage = "No text was entered! Try again...";
        String userInputString;
        boolean isAllowedInput = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print(inputMessage);

        do {
            userInputString = scanner.nextLine();
            if (userInputString.length() == 0) {
                System.out.print(errorInputMessage);
            } else {
                isAllowedInput = true;
            }
        } while (!isAllowedInput);

        return userInputString;
    }

    protected int getIntFromUser(int minAllowedInt, int maxAllowedInt, String InputMessage) {
        Scanner scanner = new Scanner(System.in);
        String errorInputMessage = "Not allowed value! Try again... ";
        int intFromUser = -1;
        boolean isAllowedInput = false;

        do {
            System.out.print(InputMessage + " (allowed are only integers from " + minAllowedInt + " to " + maxAllowedInt + "): ");
            if (scanner.hasNextInt()) {
                intFromUser = scanner.nextInt();
                if (intFromUser >= minAllowedInt && intFromUser <= maxAllowedInt) {
                    isAllowedInput = true;
                }
            } else {
                scanner.next(); //clean scanner buffer
            }
            if (!isAllowedInput) {
                System.out.print(errorInputMessage);
            }

        } while (!isAllowedInput);

        return intFromUser;
    }

    protected void printLoggedUserInformation() {
        if (RequestMenu.loggedUserLogin == null) {
            System.out.println("You are NOT logged in.");
        } else {
            System.out.println("You (" + RequestMenu.loggedUserLogin + ") are logged in.");
        }
    }
}
