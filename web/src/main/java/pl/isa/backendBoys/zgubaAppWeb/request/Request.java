package pl.isa.backendBoys.zgubaAppWeb.request;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;
import pl.isa.backendBoys.zgubaAppWeb.user.User;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "REQUESTS", schema = "zgubaDatabase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    private String objectName;

    private String description;

    @Enumerated(EnumType.STRING)
    private LostOrFound lostOrFound;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String requestDate;

    private String city;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public String myToString() {
        return this.objectName + "\n" + this.description + "\n" + this.lostOrFound.toString() + "\n" + this.requestDate + "\n" + this.city;
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

        @JsonValue
        public String getText() {
            return text;
        }
    }
}
