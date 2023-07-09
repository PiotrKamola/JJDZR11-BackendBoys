package pl.isa.backendBoys.zgubaAppWeb.user;

import org.springframework.stereotype.Controller;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestService;

@Controller
public class UserService {

    private final UserDatabase userDatabase;
    private final RequestService requestService;
    private String loggedUserEmail;

    public UserService(UserDatabase userDatabase, RequestService requestService) {
        this.userDatabase = userDatabase;
        this.requestService = requestService;
    }

    public String getLoggedUserEmail() {
        return loggedUserEmail;
    }

    public void setLoggedUserEmail(String loggedUserEmail) {
        this.loggedUserEmail = loggedUserEmail;
    }

    public boolean loginUser(String loginEmail, String password) {
        for (User user : userDatabase.getUsers()) {
            if (user.getLoginEmail().equals(loginEmail) && user.getPassword().equals(password)) {
                loggedUserEmail = loginEmail;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        loggedUserEmail = null;
    }

    public void registerUser(String name, String city, String contactNumber, String loginEmail, String password) {
        User newUser = new User(name, contactNumber, loginEmail, password, city);
        userDatabase.add(newUser);
    }

    public void registerUser(User user) {
        userDatabase.add(user);
        userDatabase.update();
    }

    public boolean isLoginTaken(String login) {
        return userDatabase.getUsers().stream().anyMatch(user -> user.getLoginEmail().equals(login));
    }

    public User getUserByLogin(String login) {
        for (User user : userDatabase.getUsers()) {
            if (user.getLoginEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void changeUserName(User user, String newName) {
        user.setName(newName);
        userDatabase.update();
    }

    public void changeUserCity(User user, String newCity) {
        user.setCity(newCity);
        userDatabase.update();
    }

    public void changeUserContactNumber(User user, String newContactNumber) {
        user.setContactNumber(newContactNumber);
        userDatabase.update();
    }

    public void changeUserPassword(User loggedUser, String newPassword) {
        loggedUser.setPassword(newPassword);
        userDatabase.update();
    }

    public void changeUserLoginAndRequests(User loggedUser, String newLogin) {
        String currentLogin = loggedUser.getLoginEmail();
        loggedUser.setLoginEmail(newLogin);
        userDatabase.update();
        requestService.changeRequesterLogin(currentLogin, newLogin);
    }

    public void deleteUserAndRequests(User loggedUser) {
        String deletedLogin = loggedUser.getLoginEmail();
        userDatabase.deleteUser(loggedUser);
        userDatabase.update();
        requestService.deleteRequestsByLogin(deletedLogin);
    }
}
