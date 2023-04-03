package org.example.request;

import org.example.interfaces.Menu;
import org.example.user.User;
import org.example.user.UserController;

import java.util.List;

public class RequestMenu implements Menu {
    public static User loggedUser;
    RequestController requestController;

    public RequestMenu(RequestController requestController) {
        this.requestController = requestController;
    }

    @Override
    public void runMenu() {
        System.out.println("Welcome in ZgubaApp!\n");

        boolean isRunning = true;

        while (isRunning) {
            printOptions();

            int userChoice = getIntFromUser(1, 5, "Please choose option");
            UserController userController = new UserController();

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case 1 -> userController.getUserMenu().runMenu();
                case 2 -> sendRequestData();
                case 3 -> printRequests(requestController.getAllRequests());
                case 4 -> System.out.println("////// in progress");
                case 5 -> isRunning = false;
            }
            System.out.println("Goodbye! Maybe next time you will find what you lost or help others to do so.");
        }
    }


    public void printOptions() {
        System.out.println("MENU\n  1. Login/Register\n  2. Sent request\n  3. Show all requests\n  4. Find request\n  5. Exit");
    }


    public void sendRequestData() {
        if (loggedUser == null) {
            System.out.println("--------\nPlease login/register first if you want to send requests!\n---------");
            return;
        }
            String lostOrFound = getInputRequestLostOrFound();
            requestController.addRequest(loggedUser, lostOrFound, getInputObjectName(lostOrFound), getInputObjectDescription());
    }

    private String getInputObjectName(String lostOrFound) {
        return getStringFromUser("What have you " + lostOrFound + "? ");
    }

    private String getInputObjectDescription() {
        return getStringFromUser("Description: ");
    }

    private String getInputRequestLostOrFound() {
        String lostOrFound;
        while (true) {
            lostOrFound = getStringFromUser("You found or lost something (you can choose \"lost\" or \"found\"): ");
            if (lostOrFound.equals("lost") || lostOrFound.equals("found")) {
                break;
            }
            System.out.println("(Only allowed words are 'lost' or 'found'. Please try again...)");
        }
        return lostOrFound;
    }

    public void printRequests(List<Request> requests) {
        if (requests.isEmpty()) {
            System.out.println("There are no requests in database\n---------------------");
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


}
