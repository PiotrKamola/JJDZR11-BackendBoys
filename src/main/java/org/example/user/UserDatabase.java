package org.example.user;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
        System.out.println("_______________________\nUser '" + user.getName() + "' (email: " + user.getLoginEmail() + ") added to database and logged.\n");
    }

}
