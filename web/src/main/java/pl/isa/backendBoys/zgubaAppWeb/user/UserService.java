package pl.isa.backendBoys.zgubaAppWeb.user;

import org.springframework.stereotype.Controller;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

@Controller
public class UserService {

    private final UserDatabase userDatabase = new UserDatabase();

    private String loggedUserEmail;

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

    public void logout(){
        loggedUserEmail = null;
    }

    public void registerUser(String name, String city, String contactNumber, String loginEmail, String password) {
        User newUser = new User(name, contactNumber, loginEmail, password, city);
        userDatabase.add(newUser);
    }

    public void registerUser(User user) {
        userDatabase.add(user);
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

}
