package pl.isa.backendBoys.zgubaAppWeb.request;

import com.fasterxml.jackson.annotation.JsonValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private String requesterLogin;
    private String objectName;
    private String description;
    private LostOrFound lostOrFound;
    private String requestDate;
    private String city;

    public Request() {
        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.city = null;
        this.requesterLogin = null;
        this.lostOrFound = null;
        this.objectName = null;
        this.description = null;
    }

    public Request(String requesterLogin, LostOrFound lostOrFound, String objectName, String description, String city) {
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

        @JsonValue
        public String getText() {
            return text;
        }
    }

    public void setRequesterLogin(String requesterLogin) {
        this.requesterLogin = requesterLogin;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLostOrFound(LostOrFound lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String myToString() {
        return this.requesterLogin + "\n" + this.objectName + "\n" + this.description + "\n" + this.lostOrFound.toString() + "\n" + this.requestDate + "\n" + this.city;
    }

}
