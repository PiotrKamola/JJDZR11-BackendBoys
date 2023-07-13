package pl.isa.backendBoys.zgubaAppWeb.request;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private Long requestId;
    private String requesterLogin;

    private String objectName;

    private String description;
    private LostOrFound lostOrFound;

    @DateTimeFormat(pattern="yyyy-MM-dd")
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

    public Long getRequestId() {
        return requestId;
    }

    public String getRequesterLogin() {
        return requesterLogin;
    }

    public void setRequesterLogin(String requesterLogin) {
        this.requesterLogin = requesterLogin;
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
        return lostOrFound.getText();
    }

    public void setLostOrFound(LostOrFound lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String myToString() {
        return this.requesterLogin + "\n" + this.objectName + "\n" + this.description + "\n" + this.lostOrFound.toString() + "\n" + this.requestDate + "\n" + this.city;
    }
    public String stringToCompareRequestswhileModify() {
        return this.objectName + "\n" + this.description + "\n" + this.lostOrFound.toString() + "\n" + this.requestDate + "\n" + this.city;
    }


    public enum LostOrFound {
        LOST("Zgubione"), FOUND("Znalezione");

        public final String text;

        LostOrFound(String lostOrFoundString) {
            this.text = lostOrFoundString;
        }

        public static LostOrFound getFromText(String text) {
            for (LostOrFound foundEnum : LostOrFound.values()) {
                if (foundEnum.text.equalsIgnoreCase(text)) {
                    return foundEnum;
                }
            }
            return null;
        }


        @JsonValue
        public String getText() {
            return text;
        }


    }

}
