package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Team;

import java.util.List;

public interface TeamService {
    void addTeam(Team team);
    void updateTeam(Team team);
    void deleteTeam(int id);
    List<Team> getAllTeams();
    Team getByTeamId(int id);





}
