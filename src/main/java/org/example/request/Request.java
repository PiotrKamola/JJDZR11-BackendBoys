package org.example.request;

import java.time.LocalDate;

public class Request {
    private String requester;
    private String contactNumber;
    private String description;
    private String objectName;
    private String lostOrFound;
    private LocalDate requestDate;

    Request(String requester, String contactNumber, String description, String objectName, String lostOrFound) {
        this.requestDate = LocalDate.now();

        this.requester = requester;
        this.contactNumber = contactNumber;
        this.description = description;
        this.objectName = objectName;
        this.lostOrFound = lostOrFound;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getLostOrFound() {
        return lostOrFound;
    }

    public void setLostOrFound(String lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
