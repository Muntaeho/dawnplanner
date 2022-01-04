package dawnteam.dawnplanner.user.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private String gender;
    private int age;
    private String auth;

}