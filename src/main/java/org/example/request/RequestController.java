package org.example.request;

import java.util.List;

public class RequestController {
    private final RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(String requesterLogin, String lostOrFound, String objectName, String description, String city) {
        requestDatabase.add(new Request(requesterLogin, lostOrFound, objectName, description, city));
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }
}