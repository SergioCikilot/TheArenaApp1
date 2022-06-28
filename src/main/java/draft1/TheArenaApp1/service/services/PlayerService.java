package draft1.TheArenaApp1.service.services;


import draft1.TheArenaApp1.entities.model.Player;

import java.util.List;

public interface PlayerService {

     void addPlayer(Player player);
     void updatePlayer(Player player);
     void deletePlayer(int id);
     List<Player> getAll();
     List<Player> getPlayersByTeamId(int teamId);
     Player getByPlayerPlayerId(int playerId);
     String getPlayerAge(Player player);
     void addTeam(int teamId, int playerId);
     Player getPlayerByUserId(int id);
     Player getPlayerByPlayerName(String name);
     List<Player> getPlayersByPlayerName(String name);

}
