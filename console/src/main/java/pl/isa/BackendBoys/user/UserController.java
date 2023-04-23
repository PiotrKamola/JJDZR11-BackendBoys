package pl.isa.BackendBoys.user;

import pl.isa.BackendBoys.request.RequestMenu;

public class UserController {

    private final UserDatabase userDatabase = new UserDatabase();
    private final UserMenu userMenu = new UserMenu();

    public boolean loginUser(String loginEmail, String password) {
        for (User user : userDatabase.getUsers()) {
            if (user.getLoginEmail().equals(loginEmail) && user.getPassword().equals(password)) {
                RequestMenu.loggedUserLogin = user.getLoginEmail();
                return true;
            }
        }
        return false;
    }

    public void registerUser() {
        String name = userMenu.getUserName();
        String city = userMenu.getUserCity();
        String contactNumber = userMenu.getUserContactNumber();

        String loginEmail = userMenu.getUserLoginEmail();
        while (isLoginTaken(loginEmail)) {
            System.out.print("This login is already taken, please type different one:");
            loginEmail = userMenu.getUserLoginEmail();
        }

        String password = userMenu.getUserPassword();

        User newUser = new User(name, contactNumber, loginEmail, password, city);
        userDatabase.add(newUser);
        RequestMenu.loggedUserLogin = newUser.getLoginEmail();

    }

    private boolean isLoginTaken(String login) {
        return userDatabase.getUsers().stream().anyMatch(user -> user.getLoginEmail().equals(login));
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

    public User getUserByLogin(String login) {
        for (User user : userDatabase.getUsers()) {
            if (user.getLoginEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }

}
