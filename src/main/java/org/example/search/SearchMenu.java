package org.example.search;

import org.example.applicationMenu.AppMenu;
import org.example.user.UserController;

import java.util.List;

public class SearchMenu extends AppMenu {
    private static final int SEARCH_BY_CITY = 1;
    private static final int BACK_TO_MENU = 2;

    private List<String> foundRecords;

    @Override
    public void runMenu() {
        boolean isRunning = true;

        while (isRunning) {
            printOptions();
            int userChoice = getIntFromUser(1, 2, "Please choose option");
            UserController userController = new UserController();

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case SEARCH_BY_CITY -> userController.getUserMenu().runMenu();
                case BACK_TO_MENU -> isRunning = false;
            }
        }
    }

    public void printOptions() {
        System.out.println("1. Search by city\n2. Back to MENU");
    }

    public String getSearchedCityFromUser() {
        return getStringFromUser("Please enter city to search requests: ");
    }
}