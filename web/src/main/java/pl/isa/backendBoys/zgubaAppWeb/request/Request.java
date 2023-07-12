package pl.isa.backendBoys.zgubaAppWeb.request;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.isa.backendBoys.zgubaAppWeb.user.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "REQUESTS", schema = "zgubaDatabase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requesterLogin")
    private String requesterLogin;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "objectName")
    private String objectName;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private LostOrFound lostOrFound;

    @Column(name = "requestDate")
    private String requestDate;

    @Column(name = "city")
    private String city;

//    public Request() {
//        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        this.city = null;
//        this.requesterLogin = null;
//        this.lostOrFound = null;
//        this.objectName = null;
//        this.description = null;
//    }

    public Request(String requesterLogin, LostOrFound lostOrFound, String objectName, String description, String city) {
        this.requestDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.city = city;
        this.requesterLogin = requesterLogin;
        this.lostOrFound = lostOrFound;
        this.objectName = objectName;
        this.description = description;
    }

//    public String getRequesterLogin() {
//        return requesterLogin;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getObjectName() {
//        return objectName;
//    }
//
//    public String getLostOrFound() {
//        return lostOrFound.getText();
//    }
//
//    public String getRequestDate() {
//        return requestDate;
//    }
//
//    public String getCity() {
//        return city;
//    }
    //    public void setRequesterLogin(String requesterLogin) {
//        this.requesterLogin = requesterLogin;
//    }
//
//    public void setObjectName(String objectName) {
//        this.objectName = objectName;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setLostOrFound(LostOrFound lostOrFound) {
//        this.lostOrFound = lostOrFound;
//    }
//
//    public void setRequestDate(String requestDate) {
//        this.requestDate = requestDate;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }

    public void setCity(String city) {
        this.city = city;
    }

    public String myToString() {
        return this.requesterLogin + "\n" + this.objectName + "\n" + this.description + "\n" + this.lostOrFound.toString() + "\n" + this.requestDate + "\n" + this.city;
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
}
