package draft1.TheArenaApp1.core.dataAccess;

import draft1.TheArenaApp1.entities.Player;
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

    Player getByPlayerId(int playerId);


}
