package pl.isa.backendBoys.zgubaAppWeb.user;

import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private final List<User> users = new ArrayList<>(JsonService.getUsersFromJsonFile());

    public void add(User user) {
        users.add(user);
    }

//    public void update(User currentUser, User newUser) {
//        int currentUserIndex = users.indexOf(currentUser);
//        users.get(currentUserIndex).setName(newUser.getName());
//        users.get(currentUserIndex).setCity(newUser.getCity());
//        users.get(currentUserIndex).setContactNumber(newUser.getContactNumber());
//        update();
//    }

    public void update() {
        JsonService.updateUsersJsonFile(users);
    }

    public List<User> getUsers() {
        return users;
    }
}
