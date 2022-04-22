package draft1.TheArenaApp1.dataAccess;

import draft1.TheArenaApp1.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository <User,Integer> {

}
