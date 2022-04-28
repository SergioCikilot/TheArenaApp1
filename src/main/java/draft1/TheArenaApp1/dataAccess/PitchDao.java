package draft1.TheArenaApp1.dataAccess;

import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface PitchDao extends JpaRepository<Pitch,Integer> {

    @Transactional
    @Modifying
    @Query("update Pitch p set p.pitchOpeningTime=:pitchOpeningTime where p.pitchId =:pitchId")
    void addPitchOpeningTime(@Param("pitchOpeningTime")String pitchOpeningTime, @Param("pitchId") int pitchId);

    @Transactional
    @Modifying
    @Query("update Pitch p set p.pitchClosingTime=:pitchClosingTime where p.pitchId =:pitchId")
    void addPitchClosingTime(@Param("pitchClosingTime")String pitchClosingTime, @Param("pitchId") int pitchId);

    @Transactional
    @Modifying
    @Query("update Pitch p set p.pitchMatchDuration=:pitchMatchDuration where p.pitchId =:pitchId")
    void addPitchMatchDuration(@Param("pitchMatchDuration")String pitchMatchDuration, @Param("pitchId") int pitchId);

}