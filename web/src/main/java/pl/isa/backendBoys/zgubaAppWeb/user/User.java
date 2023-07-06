package pl.isa.backendBoys.zgubaAppWeb.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS", schema = "zgubaDatabase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "loginEmail", unique = true)
    private String loginEmail;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    @Column(name = "contactNumber")
    private String contactNumber;

//    public void setLoginEmail(String loginEmail) {
//        this.loginEmail = loginEmail;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public User() {
//        this.name = null;
//        this.city = null;
//        this.contactNumber = null;
//        this.loginEmail = null;
//        this.password = null;
//    }
//
//
    public User(String name, String contactNumber, String loginEmail, String password, String city) {
        this.name = name;
        this.city = city;
        this.contactNumber = contactNumber;
        this.loginEmail = loginEmail;
        this.password = password;
    }
//
//    public String getCity() {
//        return city;
//    }

    @Override
    public String toString() {
        return name + " (" + loginEmail + ")";
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getLoginEmail() {
//        return loginEmail;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void nicePrint() {
//        System.out.println("Name: " + this.name);
//        System.out.println("City: " + this.city);
//        System.out.println("Contact number: " + this.contactNumber);
//        System.out.println("Login email: " + this.loginEmail);
//        System.out.println("Password: " + this.password);
//    }

}
