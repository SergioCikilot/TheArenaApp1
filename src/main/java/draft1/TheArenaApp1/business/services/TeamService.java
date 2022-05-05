package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Team;

import java.util.List;

public interface TeamService {

    void addTeam(Team team);

    void deleteTeam(Team team);

    List<Team> getAllTeams();

    void updateTeam(Team team);


}
