package org.example.request;

import org.example.abstractMenu.AppMenu;
import org.example.search.SearchMenu;
import org.example.user.UserController;

import java.util.List;

public class RequestMenu extends AppMenu {
    private static final int LOGIN_REGISTER = 1;
    private static final int SENT_REQUEST = 2;
    private static final int SHOW_ALL_REQUESTS = 3;
    private static final int SEARCH_REQUESTS = 4;
    private static final int EXIT_APP = 5;
    private final RequestController requestController = new RequestController();
    private final UserController userController = new UserController();
    private final SearchMenu searchMenu = new SearchMenu();

    public RequestController getRequestController() {
        return requestController;
    }

    public void printRequests(List<Request> requests) {
        if (requests.isEmpty()) {
            System.out.println("There are no requests in database\n---------------------");
            return;
        }

        for (Request request : requests) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Customer name: " + request.getRequester() + ", number: " + request.getContactNumber(userController.getUserByLogin(request.getRequester())) + ".");
            System.out.print("He/She " + request.getLostOrFound() + ": ");
            System.out.println(request.getObjectName() + " in city: " + request.getCity() + ".");
            System.out.println("Description: " + request.getDescription() + ".");
            System.out.println("Date: " + request.getRequestDate() + ".");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void runMenu() {
        System.out.println("Welcome in ZgubaApp!\n");

        boolean isRunning = true;

        while (isRunning) {
            printLoggedUserInformation();

            printOptions();
            int userChoice = getIntFromUser(1, 5, "Please choose option");

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case LOGIN_REGISTER -> userController.getUserMenu().runMenu(userController);
                case SENT_REQUEST -> sendRequestData();
                case SHOW_ALL_REQUESTS -> printRequests(requestController.getAllRequests());
                case SEARCH_REQUESTS -> searchMenu.runMenu(this);
                case EXIT_APP -> isRunning = false;
            }
        }
        System.out.println("Goodbye!");
    }

    public void printOptions() {
        System.out.println("MENU\n  1. Log" + (getLoggedUserLogin() == null ? " in" : " out") + "/Register\n  2. Sent request\n  3. Show all requests\n  4. Search requests\n  5. Exit");
    }

    public void sendRequestData() {
        if (getLoggedUserLogin() == null) {
            System.out.println("--------\nPlease login/register first if you want to send requests!\n---------");
            return;
        }
        String lostOrFound = getInputRequestLostOrFound();
        requestController.addRequest(getLoggedUserLogin(), lostOrFound, getInputObjectName(lostOrFound), getInputObjectDescription(), getCity(lostOrFound));
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


}
