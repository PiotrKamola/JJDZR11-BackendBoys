package org.example.user;


import org.example.abstractMenu.AppMenu;

public class UserMenu extends AppMenu {

    private static final int LOGIN = 1;
    private static final int REGISTER = 2;
    private static final int BACK_TO_MENU = 3;

    public void runMenu(UserController userController) {
        System.out.println("\nOnly registered users could send requests.");

        boolean isRunning = true;

        while (isRunning) {
            printOptions();

            int userChoice = getIntFromUser(1, 3, "Please choose option");

            switch (userChoice) {
                case LOGIN -> {
                    if (userController.loginUser(getUserLoginEmail(), getUserPassword())) {
                        System.out.println("You log in successfully.");
                        isRunning = false;
                    } else {
                        System.out.println("______________________________\nEmail or password was not correct! You are NOT log in! \n");
                    }
                }
                case REGISTER -> {
                    userController.registerUser();
                    isRunning = false;
                }
                case BACK_TO_MENU -> isRunning = false;
            }
        }
    }


    public void printOptions() {
        System.out.println("1. Login\n2. Register\n3. Back to MENU");
    }

    public String getUserLoginEmail() {
        return getStringFromUser("Please enter your login (e-mail):");
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
