package pl.isa.backendBoys.zgubaAppWeb.user;

public class UserDto {
    private String loginEmail;
    private String password;
    private String currentLoginEmail;
    private String currentPassword;

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentLoginEmail() {
        return currentLoginEmail;
    }

    public void setCurrentLoginEmail(String currentLoginEmail) {
        this.currentLoginEmail = currentLoginEmail;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
