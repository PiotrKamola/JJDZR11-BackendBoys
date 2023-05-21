package pl.isa.backendBoys.zgubaAppWeb.user;

import pl.isa.backendBoys.zgubaAppWeb.abstractMenu.AppMenu;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestMenu;

public class UserMenu extends AppMenu {

    private static final int LOG_IN_OR_OUT = 1;
    private static final int REGISTER = 2;
    private static final int BACK_TO_MENU = 3;

    public void runMenu(UserController userController) {
        System.out.println("\nOnly registered users could send requests.");

        boolean isRunning = true;

        while (isRunning) {
            if (RequestMenu.loggedUserLogin == null) {
                System.out.println("You are NOT logged in");
            } else {
                System.out.println("You (" + RequestMenu.loggedUserLogin + ") are logged in");
            }
            printOptions();

            int userChoice = getIntFromUser(1, 3, "Please choose option");

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case LOG_IN_OR_OUT -> isRunning = !logIn(userController);
                case REGISTER -> {
                    userController.registerUser();
                    isRunning = false;
                }
                case BACK_TO_MENU -> isRunning = false;
            }
        }
    }

    @Override
    public void printOptions() {
        System.out.println("1. Log " + (RequestMenu.loggedUserLogin == null ? "in" : "out") + "\n2. Register\n3. Back to MENU");
    }

    public String getUserLoginEmail() {
        return getStringFromUser("Please enter your login (e-mail):");
    }

    private boolean logIn(UserController userController) {
        if (RequestMenu.loggedUserLogin == null) {
            if (userController.loginUser(getUserLoginEmail(), getUserPassword())) {
                System.out.println("You log in successfully.");
                return true;
            } else {
                System.out.println("______________________________\nEmail or password was not correct! You are NOT log in! \n");
                RequestMenu.loggedUserLogin = null;
                return false;
            }
        } else {
            System.out.println("______________________________\nYou have been succesfully LOG OUT! \n");
            RequestMenu.loggedUserLogin = null;
            return false;
        }
    }

    public String getUserName() {
        return getStringFromUser("Please enter your name:");
    }

    public String getUserCity() {
        return getStringFromUser("Please enter your city:");
    }

    public String getUserPassword() {
        return getStringFromUser("Please enter your password:");
    }

    public String getUserContactNumber() {
        return getStringFromUser("Please enter your contact number:");
    }

}
