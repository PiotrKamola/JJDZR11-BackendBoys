package org.example.user;


import org.example.applicationMenu.AppMenu;

public class UserMenu extends AppMenu {

    public void runMenu() {
            System.out.println("\nOnly registered users could send requests.");

        UserController userController = new UserController();
        boolean isRunning = true;

        while (isRunning) {
            printOptions();

            int userChoice = getIntFromUser(1, 3, "Please choose option");

            switch (userChoice) {
                case 1 -> {
                    if (userController.loginUser(getUserLoginEmail(), getUserPassword())) {
                        System.out.println("You log in successfully.");
                        isRunning = false;
                    } else {
                        System.out.println("______________________________\nEmail or password was not correct! You are NOT log in! \n");
                    }
                }
                case 2 -> {
                    userController.registerUser();
                    isRunning = false;
                }
                case 3 -> isRunning = false;
                default -> System.out.println("Not expected value");

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

    public String getUserCity(){ return getStringFromUser("Please enter your city:");}

    public String getUserPassword() {
        return getStringFromUser("Please enter your password:");
    }

    public String getUserContactNumber() {
        return getStringFromUser("Please enter your contact number:");
    }

}
