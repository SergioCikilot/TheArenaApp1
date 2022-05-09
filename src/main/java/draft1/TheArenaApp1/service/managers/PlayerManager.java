package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.service.services.PlayerService;
import draft1.TheArenaApp1.core.utils.DateAndTime.AgeManager;
import draft1.TheArenaApp1.repository.PlayerDao;
import draft1.TheArenaApp1.entities.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerManager implements PlayerService {

    private PlayerDao playerDao;
    private AgeManager ageManager;

    @Autowired
    public PlayerManager(PlayerDao playerDao, AgeManager ageManager) {

        this.playerDao = playerDao;
        this.ageManager = ageManager;
    }

    @Override
    public void add(Player player) {

        this.playerDao.save(player);

    }

    @Override
    public void delete(int id) {

        Player player = this.playerDao.getByPlayerId(id);
        this.playerDao.delete(player);

    }

    @Override
    public void updatePlayer(Player player) {

        this.playerDao.save(player);

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
    public String getPlayerAge(Player player) {//Not finished returns null

        //String age = this.ageManager.AgeCalculator(player);

        return null ;

    }

    @Override
    public void addTeam(int teamId, int playerId) {

        this.playerDao.addTeam(teamId,playerId);

    }

}
