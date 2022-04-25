package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Player;
import draft1.TheArenaApp1.entities.Team;

import java.util.List;

public interface TeamService {

    void add(Team team);

    void delete(Team team);

    List<Team> getAll();


}
