package org.example.request;

import java.util.Scanner;


public class RequestMenu {
    RequestController requestController;

    public RequestMenu(RequestController requestController) {
        this.requestController = requestController;
    }

    private String getRequestRequesterData() {
        return getUserInput("Tell me your name: (temporary before adding login user)\n");
    }

    private String getRequestContactNumberData() {
        return getUserInput("Tell me your contact number: (temporary before adding login user)\n");
    }

    private String getRequestLostOrFound() {
        String lostOrFound;
        while (true) {
            lostOrFound = getUserInput("You found or lost something (you can choose \"lost\" or \"found\").\n");
            if (lostOrFound.equals("lost") || lostOrFound.equals("found")) {
                break;
            }
        }
        return lostOrFound;
    }

    private String getObjectName() {
        return getUserInput("What have you lost / found?\n");
    }

    private String getObjectDescription() {
        return getUserInput("Description\n");
    }

    public boolean sendRequestData() {
        try {
            requestController.addRequest(getRequestRequesterData(), getRequestContactNumberData(), getObjectDescription(), getObjectName(), getRequestLostOrFound());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String getUserInput(String inputMessage) {
        System.out.print(inputMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printRequest(Request request) {
        System.out.println("-----------------------------------------------------");
        System.out.println("Customer name: " + request.getRequester() + ", number: " + request.getContactNumber() + ".");
        System.out.print("You " + request.getLostOrFound() + " :");
        System.out.println(request.getObjectName() + ".");

        System.out.println("Description: " + request.getDescription() + ".");

        System.out.println("Date: " + request.getRequestDate() + ".");

        System.out.println("-----------------------------------------------------\n");
    }

    public void runMenu(boolean printWelocem) {

        if (printWelocem) {
            System.out.println("Welcome in ZgubaApp!\n");
        }

        printOptions();
        Scanner scanner = new Scanner(System.in);
        int userChoice = getIntFromUser(scanner, 0, 4, "Proszę o wybór opcji");

        switch (userChoice) {
            case 1 -> {
                System.out.println("1");
            }
            case 2 -> {
                System.out.println("2");
            }
            case 3 -> {
                System.out.println("3");
            }
            case 4 -> {
                System.out.println("4");
            }
        }
    }

    private int getIntFromUser(Scanner scanner, int minAllowedInt, int maxAllowedInt, String InputMessage) {
        String errorInputMessage = "Nieprawidłowa wartość! Spróbuj jeszcze raz. ";
        int intFromUser = -1;
        boolean isAllowedInput = false;

        do {
            System.out.print(InputMessage + " (dozwolone są liczby całkowite od " + minAllowedInt + " do " + maxAllowedInt + "): ");
            if (scanner.hasNextInt()) {
                intFromUser = scanner.nextInt();
                if (intFromUser >= minAllowedInt && intFromUser <= maxAllowedInt) {
                    isAllowedInput = true;
                } else {
                    isAllowedInput = false;
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

    public void printOptions() {
        System.out.println("MENU\n" + "1. Zaloguj/Zarejestruj\n" + "2. Wyślij Zgłoszenie\n" + "3. Pokaż wszystkie zgłoszenia\n" + "4. Wyszukaj zgłoszenie\n");
    }
}
