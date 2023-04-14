package org.example.request;
import org.example.user.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request {

    private final User requester;
    private final String objectName;
    private final String description;
    private final String lostOrFound;
    private final String requestDate;
    private final String city;

    Request(User requester, String lostOrFound, String objectName, String description, String city) {
        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.city = city;
        this.requester = requester;
        this.lostOrFound = lostOrFound;
        this.objectName = objectName;
        this.description = description;
    }

    public User getRequester() {
        return requester;
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
