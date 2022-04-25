package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.TeamService;
import draft1.TheArenaApp1.core.dataAccess.TeamDao;
import draft1.TheArenaApp1.entities.Team;
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
    public void add(Team team) {

        this.teamDao.save(team);

    }

    @Override
    public void delete(Team team) {
        this.teamDao.delete(team);
    }

    @Override
    public List<Team> getAll() {
        return this.teamDao.findAll();
    }




}
