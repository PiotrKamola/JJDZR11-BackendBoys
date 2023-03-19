package org.example;

import java.util.ArrayList;

public class RequestController {
    private RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(String requester, String contactNumber, String description, String objectName, int lostOrFound){
        requestDatabase.add(new Request(requester, contactNumber, description, objectName, lostOrFound));
    }

    public ArrayList<Request> getAllRequests(){
        return requestDatabase.getAllRequests();
    }
}