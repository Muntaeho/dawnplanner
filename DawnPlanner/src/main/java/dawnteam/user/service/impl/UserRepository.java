package dawnteam.user.service.impl;

import dawnteam.user.service.dvo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> finalByEmail(String email);
}
