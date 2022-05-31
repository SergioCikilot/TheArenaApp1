package draft1.TheArenaApp1.repository;

import draft1.TheArenaApp1.entities.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PlayerDao extends JpaRepository<Player,Integer> {

    @Transactional
    @Modifying
    @Query("update Player p set p.team.teamId=:teamId where p.playerId =:playerId")
    void addTeam(@Param("teamId")int teamId,@Param("playerId") int playerId);
    List<Player> getByTeamTeamId(int teamId);

    Player getPlayerByUserUserId(int id);

    Player getByPlayerId(int playerId);

    Player getPlayerByPlayerName(String name);
    List<Player> getPlayersByPlayerName(String name);


}
