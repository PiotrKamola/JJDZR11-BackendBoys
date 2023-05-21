package pl.isa.backendBoys.zgubaAppWeb.search;

import pl.isa.backendBoys.zgubaAppWeb.request.Request;

import java.util.List;

public class SearchController {

    public List<Request> searchByCity(List<Request> allRequests, String city) {

        List<Request> foundRequests;
        foundRequests = allRequests.stream().filter(request -> request.getCity().equals(city)).toList();

        return foundRequests;
    }

    public List<Request> searchByWord(List<Request> allRequests, String word) {

        List<Request> foundRequests;
        foundRequests = allRequests.stream()
                .filter(request -> request.toString().toLowerCase().contains(word.toLowerCase()))
                .toList();

        return foundRequests;
    }

}
