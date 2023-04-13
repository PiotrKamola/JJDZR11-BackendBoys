package org.example.jsonService;

import org.example.request.Request;
import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class ExampleData {
    private List<User> exampleUsers = new ArrayList<>();
    private List<Request> exampleRequests = new ArrayList<>();

    private List<User> createExampleUsers(){
        exampleUsers.add(new User("John", "113-123-123", "john@wp.pl", "john", "Warszawa"));
        exampleUsers.add(new User("Steve", "223-223-223", "steve@wp.pl", "steve", "Szczecin"));

        return exampleUsers;
    }

    private List<Request> createExampleRequests(){
        exampleRequests.add(new Request("john@wp.pl", "lost", "kluczyki", "zgugiono na parkingu przy biedronce", "Warszawa"));
        exampleRequests.add(new Request("john@wp.pl", "lost", "kluczyki", "zgugiono na parkingu przy biedronce", "Warszawa"));

        return exampleRequests;
    }

}
