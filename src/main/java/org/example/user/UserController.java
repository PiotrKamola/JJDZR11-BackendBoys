package org.example.user;

import org.example.request.RequestMenu;

public class UserController {

    private UserDatabase userDatabase = new UserDatabase();
    private final UserMenu userMenu = new UserMenu();


    public boolean loginUser(String loginEmail, String password) {
        for (User user : userDatabase.users) {
            if (user.getLoginEmail().equals(loginEmail) || user.getPassword().equals(password)) {
                RequestMenu.loggedUser = user;
                return true;
            }
        }
        return false;
    }

    public void registerUser() {
        String name = userMenu.getUserName();

        String contactNumber = userMenu.getUserContactNumber();

        String loginEmail = userMenu.getUserLoginEmail();
        while (isLoginTaken(loginEmail)) {
            System.out.print("This login is already taken, please type different one:");
            loginEmail = userMenu.getUserLoginEmail();
        }

        String password = userMenu.getUserPassword();

        User newUser = new User(name, contactNumber, loginEmail, password);
        userDatabase.add(newUser);
        RequestMenu.loggedUser = newUser;


    }

    private boolean isLoginTaken(String login) {
        for (User user : userDatabase.users) {
            if (user.getLoginEmail().equals(login)) {
                return true;
            }

        }
        return false;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

}
