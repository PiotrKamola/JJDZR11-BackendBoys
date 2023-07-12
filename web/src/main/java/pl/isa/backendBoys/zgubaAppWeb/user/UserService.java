package pl.isa.backendBoys.zgubaAppWeb.user;

import org.springframework.stereotype.Controller;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestService;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserService {
    private final RequestService requestService;
    private final MySqlService mySqlService;
    private String loggedUserEmail;

    public UserService(RequestService requestService,
                       MySqlService mySqlService) {
        this.requestService = requestService;
        this.mySqlService = mySqlService;
    }

    public List<User> getAllUsers() {
        return mySqlService.getUsers();
    }

    public List<User> getNotAdminUsers() {
        return mySqlService.getUsers().stream()
                .filter(user -> !user.getLoginEmail().equals("ADMIN@ADMIN"))
                .toList();
    }

    public String getLoggedUserEmail() {
        return loggedUserEmail;
    }

    public void setLoggedUserEmail(String loggedUserEmail) {
        this.loggedUserEmail = loggedUserEmail;
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

    public void logout(){
        loggedUserEmail = null;
    }

    public void registerUser(String name, String city, String contactNumber, String loginEmail, String password) {
        User newUser = new User(name, contactNumber, loginEmail, password, city);
        mySqlService.addNewUser(newUser);
    }

    public void registerUser(User user) {
        mySqlService.addNewUser(user);
    }

    public boolean isLoginTaken(String login) {
        return mySqlService.getUsers().stream()
                .anyMatch(user -> user.getLoginEmail().equals(login));
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
        requestService.changeRequesterLogin(currentLogin, newLogin);
    }

    public void deleteUserAndRequests(User userToDelete) {
        String deletedLogin = userToDelete.getLoginEmail();
        mySqlService.deleteUser(userToDelete);
        if (requestService.deleteRequestsByLogin(deletedLogin)) {
            requestService.exportRequestDatabaseToJson();
        }
    }

    public void deleteUserAndRequests(String userLoginEmailToDelete) {
        User userToDelete = getUserByLogin(userLoginEmailToDelete);
        deleteUserAndRequests(userToDelete);
    }
}


