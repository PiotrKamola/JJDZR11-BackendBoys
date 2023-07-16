package pl.isa.backendBoys.zgubaAppWeb.search;

import org.springframework.stereotype.Component;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;

import java.util.List;

@Component
public class SearchService {

    public List<Request> searchByCity(List<Request> allRequests, String city) {

        List<Request> foundRequests;
        foundRequests = allRequests.stream().filter(request -> request.getCity().equals(city)).toList();

        return foundRequests;
    }

    public List<Request> searchByWord(List<Request> allRequests, String word) {

        List<Request> foundRequests;
        foundRequests = allRequests.stream().filter(request -> request.myToString().toLowerCase().contains(word.toLowerCase())).toList();

        return foundRequests;
    }

}
