package org.example.user;

public class User {
    private final String loginEmail;
    private final String password;
    private final String name;
    private final String city;
    private final String contactNumber;

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

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

}
