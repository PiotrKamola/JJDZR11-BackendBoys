package pl.isa.BackendBoys.search;

import pl.isa.BackendBoys.abstractMenu.AppMenu;
import pl.isa.BackendBoys.request.RequestMenu;

public class SearchMenu extends AppMenu {
    private static final int SEARCH_BY_CITY = 1;
    private static final int BACK_TO_MENU = 0;
    private final SearchController searchController = new SearchController();

    public void runMenu(RequestMenu requestMenu) {
        boolean isRunning = true;

        while (isRunning) {
            printOptions();
            int userChoice = getIntFromUser(0, 1, "Please choose option");

            //noinspection SwitchStatementWithoutDefaultBranch
            switch (userChoice) {
                case SEARCH_BY_CITY ->
                        requestMenu.printRequests(searchController.searchByCity(requestMenu.getRequestController().getAllRequests(), getSearchedCityFromUser()));
                case BACK_TO_MENU -> isRunning = false;
            }
        }
    }

    @Override
    public void printOptions() {
        System.out.println("1. Search by city\n0. Back to MENU");
    }

    public String getSearchedCityFromUser() {
        return getStringFromUser("Please enter city to search requests: ");
    }
}