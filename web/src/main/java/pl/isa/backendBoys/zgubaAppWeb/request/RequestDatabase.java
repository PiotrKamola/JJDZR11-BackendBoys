package pl.isa.backendBoys.zgubaAppWeb.request;

import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;

import java.util.ArrayList;
import java.util.List;

public class RequestDatabase {
    private final List<Request> allRequests = new ArrayList<>(JsonService.getRequestsfromJsonFile());

    public void add(Request request) {
        allRequests.add(request);
        JsonService.updateRequestsJsonFile(allRequests);
    }

    public List<Request> getAllRequests() {
        return allRequests;
    }
}
