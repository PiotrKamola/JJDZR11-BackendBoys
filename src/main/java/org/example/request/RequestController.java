package org.example.request;

import org.example.user.User;

import java.util.List;

public class RequestController {
    private final RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(User requester, String lostOrFound, String objectName, String description, String city) {
        requestDatabase.add(new Request(requester, lostOrFound, objectName, description, city));
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }
}