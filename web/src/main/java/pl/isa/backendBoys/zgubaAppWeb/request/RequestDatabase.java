package pl.isa.backendBoys.zgubaAppWeb.request;

import org.springframework.stereotype.Component;
import pl.isa.backendBoys.zgubaAppWeb.database.JsonService;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestDatabase {
    private final List<Request> allRequests = new ArrayList<>(JsonService.getRequestsfromJsonFile());

    public List<Request> getAllRequests() {
        return allRequests;
    }

    public void add(Request request) {
        allRequests.add(request);
    }

    public void delete(Request request) {
        allRequests.remove(request);
    }

    public void exportToJson() {
        JsonService.updateRequestsJsonFile(allRequests);
    }
}
