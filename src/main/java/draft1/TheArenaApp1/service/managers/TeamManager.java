package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.service.services.TeamService;
import draft1.TheArenaApp1.repository.TeamDao;
import draft1.TheArenaApp1.entities.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamManager implements TeamService {

    private TeamDao teamDao;

    @Autowired
    public TeamManager(TeamDao teamDao) {
        this.teamDao = teamDao;
    }


    @Override
    public void addTeam(Team team) {

        this.teamDao.save(team);

    }

    @Override
    public void deleteTeam(int id) {
        Team team = teamDao.getById(id);
        this.teamDao.delete(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return this.teamDao.findAll();
    }

    @Override
    public void updateTeam(Team team) {

        this.teamDao.save(team);

    }


}
