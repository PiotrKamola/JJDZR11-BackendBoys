package pl.isa.backendBoys.zgubaAppWeb.user;

import org.springframework.stereotype.Controller;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.util.List;

@Controller
public class UserService {
    private final MySqlService mySqlService;
    private String loggedUserEmail;

    public UserService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }

    public List<User> getNotAdminUsers() {
        return mySqlService.getUsers().stream().filter(user -> !user.getLoginEmail().equals("ADMIN@ADMIN")).toList();
    }

    public String getLoggedUserEmail() {
        return loggedUserEmail;
    }

    public boolean loginUser(String loginEmail, String password) {
        for (User user : mySqlService.getUsers()) {
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

    public void registerUser(User user) {
        mySqlService.addNewUser(user);
    }

    public boolean isLoginTaken(String login) {
        return mySqlService.getUsers().stream().anyMatch(user -> user.getLoginEmail().equals(login));
    }

    public User getUserByLogin(String login) {
        for (User user : mySqlService.getUsers()) {
            if (user.getLoginEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void changeUserName(User user, String newName) {
        mySqlService.updateUserName(user, newName);
    }

    public void changeUserCity(User user, String newCity) {
        mySqlService.updateUserCity(user, newCity);
    }

    public void changeUserContactNumber(User user, String newContactNumber) {
        mySqlService.updateUserContactNumber(user, newContactNumber);
    }

    public void changeUserPassword(User loggedUser, String newPassword) {
        mySqlService.updateUserPassword(loggedUser, newPassword);
    }

    public void changeUserLoginAndRequests(User loggedUser, String newLogin) {
        String currentLogin = loggedUser.getLoginEmail();
        changeUserLoginAndRequests(currentLogin, newLogin);
    }

    public void changeUserLoginAndRequests(String currentLogin, String newLogin) {
        User currentUser = getUserByLogin(currentLogin);
        currentUser.setLoginEmail(newLogin);
        mySqlService.updateUserEmailLogin(currentUser, newLogin);
    }

    public void deleteUserAndRequests(User userToDelete) {
        mySqlService.deleteUser(userToDelete);
    }

    public void deleteUserAndRequests(String userLoginEmailToDelete) {
        User userToDelete = getUserByLogin(userLoginEmailToDelete);
        deleteUserAndRequests(userToDelete);
    }
}


