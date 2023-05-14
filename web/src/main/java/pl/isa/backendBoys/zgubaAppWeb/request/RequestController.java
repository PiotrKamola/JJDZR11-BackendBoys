package pl.isa.backendBoys.zgubaAppWeb.request;

import java.util.List;

public class RequestController {

    private final RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(Request request) {
        requestDatabase.add(request);
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }
}