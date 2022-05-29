package draft1.TheArenaApp1.repository;

import draft1.TheArenaApp1.entities.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team,Integer> {

    Team getByTeamId(int id);


}
