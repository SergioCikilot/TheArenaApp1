package draft1.TheArenaApp1.security.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository <User,Integer> {

    Optional<User> findUserByUsername(String username);

}
