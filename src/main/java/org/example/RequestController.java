package org.example;

import java.util.List;

public class RequestController {
    private RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(String requester, String contactNumber, String description, String objectName, int lostOrFound){
        requestDatabase.add(new Request(requester, contactNumber, description, objectName, lostOrFound));
    }

    public List<Request> getAllRequests(){
        return requestDatabase.getAllRequests();
    }
}