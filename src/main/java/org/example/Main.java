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

//        Request request1 = new Request();
//        Request request2 = new Request();
//
//        System.out.println("\n\nRequest 1:");
//        Request.printRequest(request1);
//
//        System.out.println("\nRequest 2:");
//        Request.printRequest(request2);
    }
}