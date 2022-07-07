package draft1.TheArenaApp1.core.user;

import draft1.TheArenaApp1.core.user.User;
import draft1.TheArenaApp1.entities.model.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository <User,Integer> {

    User findUserByUserId(int id);
    Optional<User> findUserByUsername(String username);
    List<User> findUsersByEmail(String email);
    List<User> findUsersByUsername(String username);
    @Transactional
    @Modifying
    @Query("update User p set p.userPitches=:userPitches where p.userId =:userId")
    void updateUserPitches(@Param("userPitches") List<Pitch> userPitches, @Param("userId") int userId);

}
