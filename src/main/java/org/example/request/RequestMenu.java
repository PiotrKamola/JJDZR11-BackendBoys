package org.example.request;

import java.util.InputMismatchException;
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

    private int getRequestLostOrFound() {
        int lostOrFound;
        System.out.println("You found or lost something? (0 - lost | 1 - found) " +
                "(temporary, later choose from list)");
        while (true) {
            try {
                String userInput = getUserInput("");
                lostOrFound = Integer.parseInt(userInput);
                if (lostOrFound != 0 && lostOrFound != 1) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Wrong number.");
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
            requestController.addRequest(getRequestRequesterData(),
                    getRequestContactNumberData(),
                    getObjectDescription(),
                    getObjectName(),
                    getRequestLostOrFound());
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
        if (request.getLostOrFound() == 0) {
            System.out.print("You lost ");
        } else {
            System.out.print("You found ");
        }
        System.out.println(request.getObjectName() + ".");

        System.out.println("Description: " + request.getDescription() + ".");

        System.out.println("Date: " + request.getRequestDate() + ".");

        System.out.println("-----------------------------------------------------\n");
    }
}
