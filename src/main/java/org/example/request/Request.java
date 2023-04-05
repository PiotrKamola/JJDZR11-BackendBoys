package org.example.request;
import org.example.user.User;
import java.time.LocalDate;

public class Request {

    private final User requester;
    private final String objectName;
    private final String description;
    private final String lostOrFound;
    private final LocalDate requestDate;

    Request(User requester, String lostOrFound, String objectName, String description) {
        this.requestDate = LocalDate.now();
        this.requester = requester;
        this.lostOrFound = lostOrFound;
        this.objectName = objectName;
        this.description = description;
    }

    public User getRequester() {
        return requester;
    }

    public String getContactNumber() {
        return requester.getContactNumber();
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

    public LocalDate getRequestDate() {
        return requestDate;
    }

}
