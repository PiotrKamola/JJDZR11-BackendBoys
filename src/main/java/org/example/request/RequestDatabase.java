package org.example.request;

import java.util.ArrayList;
import java.util.List;

public class RequestDatabase {
    private final List<Request> allRequests = new ArrayList<>();

    public void add(Request request) {
        allRequests.add(request);
        System.out.println("Added request to database.\n");
    }

    public List<Request> getAllRequests() {
        return allRequests;
    }
}
