package draft1.TheArenaApp1.repository;

import draft1.TheArenaApp1.entities.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationDate=:reservationDate where p.reservationId =:reservationId")
    void updateReservationDate(@Param("reservationDate")String reservationDate, @Param("reservationId") int reservationId);

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationTime=:reservationTime where p.reservationId =:reservationId")
    void updateReservationTime(@Param("reservationTime")String reservationTime, @Param("reservationId") int reservationId);

    List<Reservation> getReservationsByReservationDate(String reservationDate);
    List<Reservation> getReservationsByReservationTime(String reservationTime);
    List<Reservation> getReservationsByPitchPitchId(int pitchId);

    List<Reservation> getReservationsByPlayerPlayerId(int id);
    Reservation getByReservationId(int id);

}
