package draft1.TheArenaApp1.core.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository <User,Integer> {

    Optional<User> findUserByUsername(String username);

}
