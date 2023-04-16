package pl.isa.BackendBoys.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request {
    private final String requesterLogin;
    private final String objectName;
    private final String description;
    private final LostOrFound lostOrFound;
    private final String requestDate;
    private final String city;

    Request(String requesterLogin, LostOrFound lostOrFound, String objectName, String description, String city) {
        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.city = city;
        this.requesterLogin = requesterLogin;
        this.lostOrFound = lostOrFound;
        this.objectName = objectName;
        this.description = description;
    }

    public String getRequesterLogin() {
        return requesterLogin;
    }

    public String getDescription() {
        return description;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getLostOrFound() {
        return lostOrFound.getText();
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getCity() {
        return city;
    }

    public enum LostOrFound {
        LOST("Lost"), FOUND("Found");

        public final String text;

        LostOrFound(String lostOrFoundString) {
            this.text = lostOrFoundString;
        }

        public String getText() {
            return text;
        }
    }

}
