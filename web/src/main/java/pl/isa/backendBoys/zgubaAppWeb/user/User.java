package pl.isa.backendBoys.zgubaAppWeb.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String loginEmail;
    private String password;
    private String name;
    private String city;
    private String contactNumber;

    public User() {
        this.name = null;
        this.city = null;
        this.contactNumber = null;
        this.loginEmail = null;
        this.password = null;
    }

    public User(String name, String contactNumber, String loginEmail, String password, String city) {
        this.name = name;
        this.city = city;
        this.contactNumber = contactNumber;
        this.loginEmail = loginEmail;
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + loginEmail + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


}
