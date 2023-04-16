package pl.isa.BackendBoys.request;

import pl.isa.BackendBoys.abstractMenu.AppMenu;
import pl.isa.BackendBoys.search.SearchMenu;
import pl.isa.BackendBoys.user.UserController;

import java.util.List;

public class RequestMenu extends AppMenu {
    private static final int SIGN_REGISTER = 1;
    private static final int SENT_REQUEST = 2;
    private static final int SHOW_ALL_REQUESTS = 3;
    private static final int SEARCH_REQUESTS = 4;
    private static final int EXIT_APP = 5;
    public static String loggedUserLogin;
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
            System.out.println("Requester name: " + request.getRequesterLogin() + ", Login(e-mail): " + userController.getUserByLogin(request.getRequesterLogin()).getContactNumber() + ".");
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
            if (loggedUserLogin == null) {
                System.out.println("You are NOT logged in");
            } else {
                System.out.println("You (" + loggedUserLogin + ") are logged in");
            }

            printOptions();
            int userChoice = getIntFromUser(1, 5, "Please choose option");

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case SIGN_REGISTER -> userController.getUserMenu().runMenu(userController);
                case SENT_REQUEST -> sendRequestData();
                case SHOW_ALL_REQUESTS -> printRequests(requestController.getAllRequests());
                case SEARCH_REQUESTS -> searchMenu.runMenu(this);
                case EXIT_APP -> isRunning = false;
            }
        }
        System.out.println("Goodbye!");
    }

    @Override
    public void printOptions() {
        System.out.println("MENU\n  1. Log" + (loggedUserLogin == null ? " in" : " out") + "/Register\n  2. Sent request\n  3. Show all requests\n  4. Search requests\n  5. Exit");
    }

    public void sendRequestData() {
        if (loggedUserLogin == null) {
            System.out.println("--------\nPlease login/register first if you want to send requests!\n---------");
            return;
        }
        String lostOrFound = getInputRequestLostOrFound();
        requestController.addRequest(loggedUserLogin, Request.LostOrFound.valueOf(lostOrFound), getInputObjectName(lostOrFound), getInputObjectDescription(), getCity(lostOrFound));
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
        boolean running = true;
        String lostOrFound = null;
        while (running) {
            try {
                int option = Integer.parseInt(getStringFromUser(showLostOrFoundOptions()));
                switch (Request.LostOrFound.values()[option]) {
                    case LOST -> {
                        lostOrFound = Request.LostOrFound.LOST.name();
                        running = false;
                    }
                    case FOUND -> {
                        lostOrFound = Request.LostOrFound.FOUND.name();
                        running = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Wrong option, choose again.");
            }
        }
        return lostOrFound;
    }

    public String showLostOrFoundOptions() {
        StringBuilder strBuilder = new StringBuilder();
        for (Request.LostOrFound option : Request.LostOrFound.values()) {
            strBuilder.append(option.ordinal()).append(". ").append(option.getText()).append("\n");
        }
        return strBuilder.toString();
    }


}
