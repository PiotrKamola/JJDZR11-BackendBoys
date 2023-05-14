package pl.isa.backendBoys.zgubaAppWeb.request;

import pl.isa.backendBoys.zgubaAppWeb.jsonService.JsonController;

import java.util.ArrayList;
import java.util.List;

public class RequestDatabase {
    private final List<Request> allRequests = new ArrayList<>(JsonController.getRequestsfromJsonFile());

    public void add(Request request) {
        allRequests.add(request);
        System.out.println("_____________\n Request has been correctly added to database.\n");
        JsonController.updateRequestsJsonFile(allRequests);
    }

    public List<Request> getAllRequests() {
        return allRequests;
    }
}
