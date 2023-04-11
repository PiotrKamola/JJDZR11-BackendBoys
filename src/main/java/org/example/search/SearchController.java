package org.example.search;

import org.example.request.Request;

import java.util.List;

public class SearchController {

    public List<Request> searchByCity(List<Request> allRequests, String city) {

        List<Request> foundRequests;
        foundRequests = allRequests.stream().filter(r -> r.getCity().equals(city)).toList();

        return foundRequests;
    }

}
