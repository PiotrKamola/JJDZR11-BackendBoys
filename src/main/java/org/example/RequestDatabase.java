package org.example;

import java.util.ArrayList;
import java.util.List;

public class RequestDatabase {
    private List<Request> allRequests = new ArrayList<>();

    RequestDatabase(){

    }
    public void add(Request request) {
        allRequests.add(request);
        System.out.println("Added request to database.\n");
    }

    public List<Request> getAllRequests(){
        return allRequests;
    }
}
