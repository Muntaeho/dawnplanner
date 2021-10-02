package dawnteam.user.service;

import dawnteam.user.service.dvo.UserInfo;
import dawnteam.user.service.dvo.UserInfoDto;
import dawnteam.user.service.impl.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.finalByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException((username)));
    }

    /* 회원 가입 */
    public Long save(UserInfoDto inputDto){
        // BCrypt : password 저장 전 암호화
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        inputDto.setPassword(encoder.encode(inputDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .email(inputDto.getEmail())
                .auth(inputDto.getAuth())
                .password(inputDto.getPassword()).build()).getCode();
    }

}
