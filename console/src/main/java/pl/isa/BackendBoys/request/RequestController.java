package pl.isa.BackendBoys.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class RequestController {

    private final RequestDatabase requestDatabase = new RequestDatabase();

    public void addRequest(String requesterLogin, Request.LostOrFound lostOrFound, String objectName, String description, String city) {
        requestDatabase.add(new Request(requesterLogin, lostOrFound, objectName, description, city));
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }
}