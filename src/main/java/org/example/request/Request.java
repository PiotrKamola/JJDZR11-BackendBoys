package org.example.request;
import org.example.user.User;
import org.example.user.UserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request {

    private final String requesterLogin;
    private final String objectName;
    private final String description;
    private final String lostOrFound;
    private final String city;
    private final String requestDate;

    Request(String requesterLogin, String lostOrFound, String objectName, String description, String city) {
        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.city = city;
        this.requesterLogin = requesterLogin;
        this.lostOrFound = lostOrFound;
        this.objectName = objectName;
        this.description = description;
    }

    public String getRequester() {
        return requesterLogin;
    }

    public String getContactNumber(User loggedUSer) {
        return loggedUSer.getContactNumber();
    }

    public String getDescription() {
        return description;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getLostOrFound() {
        return lostOrFound;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getCity() {
        return city;
    }

}
