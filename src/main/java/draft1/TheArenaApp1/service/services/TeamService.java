package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Team;

import java.util.List;

public interface TeamService {

    Team getByTeamId(int id);

    void addTeam(Team team);

    void deleteTeam(int id);

    List<Team> getAllTeams();

    void updateTeam(Team team);


}
