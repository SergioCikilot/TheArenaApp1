package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.service.services.PlayerService;
import draft1.TheArenaApp1.core.utils.dateTime.AgeManager;
import draft1.TheArenaApp1.repository.PlayerDao;
import draft1.TheArenaApp1.entities.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerManager implements PlayerService {

    private final PlayerDao playerDao;
    private final AgeManager ageManager;

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public PlayerManager(PlayerDao playerDao, AgeManager ageManager) {

        this.playerDao = playerDao;
        this.ageManager = ageManager;
    }
    //add---------------------------------------------------------------------------------------------------------------
    @Override
    public void addPlayer(Player player) {

        this.playerDao
                .save(player);
    }
    //update------------------------------------------------------------------------------------------------------------
    @Override
    public void updatePlayer(Player player) {

        this.playerDao
                .save(player);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @Override
    public void deletePlayer(int id) {

        Player player = this.playerDao
                .getByPlayerId(id);
        this.playerDao
                .delete(player);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @Override
    public List<Player> getAll() {

        return this.playerDao
                .findAll();
    }
    @Override
    public List<Player> getPlayersByTeamId(int teamId) {
        return this.playerDao
                .getByTeamTeamId(teamId);
    }
    @Override
    public Player getByPlayerPlayerId(int playerId) {
        return this.playerDao
                .getByPlayerId(playerId);
    }
    @Override
    public String getPlayerAge(Player player) {//Not finished returns null

        return null ;
    }
    @Override
    public void addTeam(int teamId, int playerId) {

        this.playerDao
                .addTeam(teamId,playerId);
    }
    @Override
    public Player getPlayerByUserId(int id) {

        return this.playerDao
                .getPlayerByUserUserId(id);
    }

    @Override
    public Player getPlayerByPlayerName(String name) {

        return this.playerDao
                .getPlayerByPlayerName(name);
    }
    @Override
    public List<Player> getPlayersByPlayerName(String name) {
        return this.playerDao
                .getPlayersByPlayerName(name);
    }


}
