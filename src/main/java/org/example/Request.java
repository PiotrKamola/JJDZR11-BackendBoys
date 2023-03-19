package org.example;

import java.time.LocalDate;

public class Request {
//    private enum lostOrFound {
//    Lost(0),
//    Found(1);
//
//    lostOrFound(int i) {
//        this.
//    }
//}
    private String requester;
    private String contactNumber;
    private String description;
    private String objectName;
    private int lostOrFound; // 0 - lost | 1 - found

    private java.time.LocalDate requestDate;

    Request(String requester, String contactNumber, String description, String objectName, int lostOrFound){
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

    public int getLostOrFound() {
        return lostOrFound;
    }

    public void setLostOrFound(int lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
}
