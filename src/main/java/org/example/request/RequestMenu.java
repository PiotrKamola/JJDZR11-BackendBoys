package org.example.request;

import java.util.List;
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

    public void printRequests(List<Request> requests) {
        if (requests.isEmpty()) {
            System.out.println("There is no requests in database");
            return;
        }

        for (Request request : requests) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Customer name: " + request.getRequester() + ", number: " + request.getContactNumber() + ".");
            System.out.print("You " + request.getLostOrFound() + " :");
            System.out.println(request.getObjectName() + ".");
            System.out.println("Description: " + request.getDescription() + ".");
            System.out.println("Date: " + request.getRequestDate() + ".");
            System.out.println("-----------------------------------------------------");
        }

    }

    public void runMenu(boolean printWelcome) {

        if (printWelcome) {
            System.out.println("Welcome in ZgubaApp!\n");
        }

        boolean isRunning = true;

        while (isRunning) {
            printOptions();
            Scanner scanner = new Scanner(System.in);
            int userChoice = getIntFromUser(scanner, 0, 5, "Please choose option");


            switch (userChoice) {
                case 1 -> {
                    System.out.println("/////// in progress");
                }
                case 2 -> {
                    if (sendRequestData()) {
                        System.out.println("Request added.");
                    } else {
                        System.out.println("Some unexpected error has occured, try again...");
                    }
                }
                case 3 -> {
                    System.out.println("Printing all requests...");
                    printRequests(requestController.getAllRequests());
                    System.out.println("END OF PRINTING\n");
                }
                case 4 -> {
                    System.out.println("////// in progress");
                }
                case 5 -> {
                    System.out.println("Goodbye! Maybe next time you will find what you lost or help others to do so.");
                    isRunning = false;
                }
            }
        }
    }

    private int getIntFromUser(Scanner scanner, int minAllowedInt, int maxAllowedInt, String InputMessage) {
        String errorInputMessage = "Not allowed value! Try again... ";
        int intFromUser = -1;
        boolean isAllowedInput = false;

        do {
            System.out.print(InputMessage + " (Allowed are only integers from " + minAllowedInt + " to " + maxAllowedInt + "): ");
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
        System.out.println("MENU\n1. Login/Register\n2. Sent request\n3. Show all requests\n4. Find request\n5. Exit\n");
    }
}
