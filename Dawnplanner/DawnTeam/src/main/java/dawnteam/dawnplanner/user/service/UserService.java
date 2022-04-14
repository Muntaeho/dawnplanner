package dawnteam.dawnplanner.user.service;

import dawnteam.dawnplanner.user.domain.User;
import dawnteam.dawnplanner.user.dto.UserDTO;
import dawnteam.dawnplanner.user.dto.UserUpdateDTO;
import dawnteam.dawnplanner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    /**
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public Long save(UserDTO infoDto) {

        if(userRepository.findUserByEmail(infoDto.getEmail())!=null){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(User.builder()
                .email(infoDto.getEmail())
                .password(infoDto.getPassword())
                .name(infoDto.getName())
                .nickname(infoDto.getNickname())
                .phone_number(infoDto.getPhone_number())
                .gender(infoDto.getGender())
                .age(infoDto.getAge())
                .role("ROLE_USER")
                .build())
                .getId();
    }

    @Transactional
    public void update(UserUpdateDTO UpdateDTO) {
        User user = userRepository.findUserByEmail(UpdateDTO.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.update(
                encoder.encode(UpdateDTO.getPassword()),
                UpdateDTO.getPhone_number(),
                UpdateDTO.getNickname()


        );
    }
    /**
     * Spring Security 필수 메소드 구현f
     *
     * @param email 이메일
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */

    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 User로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public User loadUserByUsername(String email) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email);
        }
        return user;
    }
}
