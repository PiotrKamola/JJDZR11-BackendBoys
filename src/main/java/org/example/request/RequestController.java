package org.example.request;

import java.util.List;

public class RequestController {
    private final RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(String requester, String contactNumber, String description, String objectName, String lostOrFound) {
        requestDatabase.add(new Request(requester, contactNumber, description, objectName, lostOrFound));
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }
}