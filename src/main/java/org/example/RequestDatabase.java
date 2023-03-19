package org.example;

import java.util.ArrayList;

public class RequestDatabase {
    private ArrayList<Request> allRequests = new ArrayList<Request>();

    RequestDatabase(){

    }
    public void add(Request request) {
        allRequests.add(request);
        System.out.println("Added request to database.");
    }

    public ArrayList<Request> getAllRequests(){
        return allRequests;
    }
}
