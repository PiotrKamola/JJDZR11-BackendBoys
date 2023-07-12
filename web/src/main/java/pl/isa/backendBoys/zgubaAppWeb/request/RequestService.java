package pl.isa.backendBoys.zgubaAppWeb.request;

import org.springframework.stereotype.Component;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean deleteRequestsByLogin(String loginEmail) {

        boolean isRequestFound = false;

        Iterator<Request> iterator = mySqlService.getRequests().iterator();
        while (iterator.hasNext()) {
            Request request = iterator.next();
            if (request.getUser().getLoginEmail().equals(loginEmail)) {
                iterator.remove();
                isRequestFound = true;
            }
        }
        return isRequestFound;
    }
}