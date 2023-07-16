package pl.isa.backendBoys.zgubaAppWeb.user;

import jakarta.persistence.*;
import lombok.*;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import java.util.List;

@Entity
@Table(name = "USERS", schema = "zgubaDatabase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String loginEmail;

    private String password;

    private String name;

    private String city;

    private String contactNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<Request> request;

    public User(String name, String contactNumber, String loginEmail, String password, String city) {
        this.name = name;
        this.city = city;
        this.contactNumber = contactNumber;
        this.loginEmail = loginEmail;
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " (" + loginEmail + ")";
    }

}
