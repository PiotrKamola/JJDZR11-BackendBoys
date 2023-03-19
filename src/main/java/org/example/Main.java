package org.example;

public class Main {
    public static void main(String[] args) {

        RequestController requestController = new RequestController();
        RequestMenu requestMenu = new RequestMenu(requestController);
        requestMenu.sendRequestData();
        requestMenu.sendRequestData();
        requestMenu.sendRequestData();


        for(Request request : requestController.getAllRequests()){
            requestMenu.printRequest(request);
        }
    }
}