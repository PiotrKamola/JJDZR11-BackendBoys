package org.example;

import org.example.request.RequestController;
import org.example.request.RequestMenu;
import org.example.request.Request;

public class ZgubaApp {
    public static void main(String[] args) {



        RequestController requestController = new RequestController();
        RequestMenu requestMenu = new RequestMenu(requestController);
//        requestMenu.sendRequestData();
//        requestMenu.sendRequestData();
//        requestMenu.sendRequestData();

        requestMenu.runMenu(true);

        for (Request request : requestController.getAllRequests()) {
            requestMenu.printRequest(request);
        }
    }
}