package pl.isa.backendBoys.zgubaAppWeb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    private final List<User> users = new ArrayList<>(JsonService.getUsersFromJsonFile());


    public void add(User user) {
        users.add(user);
        JsonService.updateUsersJsonFile(users);

    }

    public List<User> getUsers() {
        return users;
    }
}
