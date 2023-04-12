package org.example.user;

import org.example.abstractMenu.AppMenu;

public class UserMenu extends AppMenu {

    private static final int LOG_IN_OR_OUT = 1;
    private static final int REGISTER = 2;
    private static final int BACK_TO_MENU = 3;

    public void runMenu(UserController userController) {

        boolean isRunning = true;

        while (isRunning) {
            printLoggedUserInformation();
            printOptions();

            int userChoice = getIntFromUser(1, 3, "Please choose option");

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

    public void printOptions() {
        System.out.println("1. Log " + (getLoggedUserLogin() == null ? "in" : "out") + "\n2. Register\n3. Back to MENU");
    }

    public String getUserLoginEmail() {
        return getStringFromUser("Please enter your login (e-mail):");
    }

    private boolean logIn(UserController userController) {
        if (getLoggedUserLogin() == null) {
            if (userController.loginUser(getUserLoginEmail(), getUserPassword())) {
                System.out.println("You log in successfully.");
                return true;
            } else {
                System.out.println("______________________________\nEmail or password was not correct! You are NOT log in! \n");
                setLoggedUserLogin(null);
                return false;
            }
        } else {
            System.out.println("______________________________\nYou have been succesfully LOG OUT! \n");
            setLoggedUserLogin(null);
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
