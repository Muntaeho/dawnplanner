package dawnteam.user.service.dvo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoDto {
    private String email;
    private String password;
    private String auth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
