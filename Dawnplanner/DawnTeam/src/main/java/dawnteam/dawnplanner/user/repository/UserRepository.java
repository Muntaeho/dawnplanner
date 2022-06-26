package dawnteam.dawnplanner.user.repository;


import dawnteam.dawnplanner.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}