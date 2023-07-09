package pl.isa.backendBoys.zgubaAppWeb.request;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestService {

    private final RequestDatabase requestDatabase;

    public RequestService(RequestDatabase requestDatabase) {
        this.requestDatabase = requestDatabase;
    }

    public void addRequest(String requesterLogin, Request.LostOrFound lostOrFound, String objectName, String description, String city) {
        requestDatabase.add(new Request(requesterLogin, lostOrFound, objectName, description, city));
    }

    public void addRequest(Request request) {
        requestDatabase.add(request);
        requestDatabase.update();
    }

    public List<Request> getAllRequests() {
        return requestDatabase.getAllRequests();
    }

    public void changeRequesterLogin(String currentLoginEmail, String newLoginEmail) {
        requestDatabase.getAllRequests().stream()
                .filter(request -> request.getRequesterLogin().equals(currentLoginEmail))
                .forEach(request -> request.setRequesterLogin(newLoginEmail));
        requestDatabase.update();
    }
}