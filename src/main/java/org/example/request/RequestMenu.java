package org.example.request;

import org.example.applicationMenu.AppMenu;
import org.example.user.User;
import org.example.user.UserController;

import java.util.List;

public class RequestMenu extends AppMenu {
    private static final int LOGIN_REGISTER = 1;
    private static final int SENT_REQUEST = 2;
    private static final int SHOW_ALL_REQUESTS = 3;
    private static final int SEARCH_REQUESTS = 4;
    private static final int EXIT_APP = 5;
    public static User loggedUser;
    private final RequestController requestController;

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
                case LOGIN_REGISTER -> userController.getUserMenu().runMenu();
                case SENT_REQUEST -> sendRequestData();
                case SHOW_ALL_REQUESTS -> printRequests(requestController.getAllRequests());
                case SEARCH_REQUESTS -> System.out.println("////// in progress");
                case EXIT_APP -> isRunning = false;
            }
            if (userChoice == 5) {
                System.out.println("Goodbye! Maybe next time you will find what you lost or help others to do so.");
            }
        }
    }


    public void printOptions() {
        System.out.println("MENU\n  1. Login/Register\n  2. Sent request\n  3. Show all requests\n  4. Search requests\n  5. Exit");
    }


    public void sendRequestData() {
        if (loggedUser == null) {
            System.out.println("--------\nPlease login/register first if you want to send requests!\n---------");
            return;
        }
        String lostOrFound = getInputRequestLostOrFound();
        requestController.addRequest(loggedUser, lostOrFound, getInputObjectName(lostOrFound), getInputObjectDescription(), getCity(lostOrFound));
    }

    private String getInputObjectName(String lostOrFound) {
        return getStringFromUser("What have you " + lostOrFound + "? ");
    }

    private String getCity(String lostOrFound) {
        return getStringFromUser("In what city you " + lostOrFound + " that?");
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
            System.out.print("He/She " + request.getLostOrFound() + ": ");
            System.out.println(request.getObjectName() + " in city: " + request.getCity() + ".");
            System.out.println("Description: " + request.getDescription() + ".");
            System.out.println("Date: " + request.getRequestDate() + ".");
            System.out.println("-----------------------------------------------------");
        }
    }


}
