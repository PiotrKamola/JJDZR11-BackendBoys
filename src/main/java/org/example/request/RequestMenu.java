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

    private String getRequestLostOrFound() {
        String lostOrFound;
        while (true) {
            lostOrFound = getUserInput("You found or lost something (you can choose \"lost\" or \"found\").\n");
            if(lostOrFound.equals("lost") || lostOrFound.equals("found")){
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
        System.out.print("You "+request.getLostOrFound()+" :");
        System.out.println(request.getObjectName() + ".");

        System.out.println("Description: " + request.getDescription() + ".");

        System.out.println("Date: " + request.getRequestDate() + ".");

        System.out.println("-----------------------------------------------------\n");
    }
}
