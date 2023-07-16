package pl.isa.backendBoys.zgubaAppWeb.request;

import org.springframework.stereotype.Component;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.util.List;

@Component
public class RequestService {

    private final MySqlService mySqlService;

    public RequestService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }

    public void addRequest(Request request) {
        mySqlService.addNewRequest(request);
    }

    public List<Request> getAllRequests() {
        return mySqlService.getRequests();
    }

    public List<Request> getRequestsByUser(String loggedUser) {
        return mySqlService.getRequests().stream().filter(request -> request.getUser().getLoginEmail().equals(loggedUser)).toList();
    }

    public Request getRequestById(Long requestId) {
        return mySqlService.getRequests().stream().filter(request -> request.getRequestId().equals(requestId)).findFirst().orElse(null);
    }

    public void modifyRequest(Request currentRequest, Request requestToModify) {
        currentRequest.setCity(requestToModify.getCity());
        currentRequest.setDescription(requestToModify.getDescription());

        currentRequest.setLostOrFound(requestToModify.getLostOrFound());

        currentRequest.setObjectName(requestToModify.getObjectName());
        currentRequest.setRequestDate(requestToModify.getRequestDate());
    }
}