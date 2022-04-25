package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.PlayerService;
import draft1.TheArenaApp1.core.utilities.DateAndTime.DateAdapter;
import draft1.TheArenaApp1.core.dataAccess.PlayerDao;
import draft1.TheArenaApp1.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class PlayerManager implements PlayerService {

    private PlayerDao playerDao;
    private DateAdapter dateAdapter;



    @Autowired
    public PlayerManager(PlayerDao playerDao,DateAdapter dateAdapter) {

        this.playerDao = playerDao;
        this.dateAdapter = dateAdapter;
    }


    @Override
    public void add(Player player) {

        this.playerDao.save(player);


    }

    @Override
    public void delete(Player player) {

        this.playerDao.delete(player);

    }

    @Override
    public List<Player> getAll() {

        return this.playerDao.findAll();

    }

    @Override
    public List<Player> getPlayersByTeam(int teamId) {
        return this.playerDao.getByTeamTeamId(teamId);
    }

    @Override
    public Player getByPlayerPlayerId(int playerId) {
        return this.playerDao.getByPlayerId(playerId);
    }


    @Override
    public String getPlayerAge(Player player) {



        LocalDate startDate = player.getAgeBirthDate();//repoya çek
        LocalDate endDate = dateAdapter.getUnformattedCurrentdateIstanbul();
        Period period = Period.between(startDate, endDate);
        String age =String.format("%d", period.getYears());

        return age;

    }

    @Override
    public void addTeam(int teamId, int playerId) {

        this.playerDao.addTeam(teamId,playerId);

    }

}
