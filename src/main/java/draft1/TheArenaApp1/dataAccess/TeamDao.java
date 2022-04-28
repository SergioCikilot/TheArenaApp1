package draft1.TheArenaApp1.dataAccess;

import draft1.TheArenaApp1.entities.Player;
import draft1.TheArenaApp1.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamDao extends JpaRepository<Team,Integer> {



}
