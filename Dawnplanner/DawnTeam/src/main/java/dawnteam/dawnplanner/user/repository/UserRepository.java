package dawnteam.dawnplanner.user.repository;


import dawnteam.dawnplanner.user.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String email);
}