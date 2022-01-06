package dawnteam.dawnplanner.user.dto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class UserDTO {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private String gender;
    private int age;
    private String role;

}