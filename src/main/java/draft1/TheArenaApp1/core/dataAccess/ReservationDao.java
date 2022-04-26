package draft1.TheArenaApp1.core.dataAccess;

import draft1.TheArenaApp1.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationDate=:reservationDate where p.reservationId =:reservationId")
    void addReservationDate(@Param("reservationDate")String reservationDate, @Param("reservationId") int reservationId);

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationTime=:reservationTime where p.reservationId =:reservationId")
    void addReservationTime(@Param("reservationTime")String reservationTime, @Param("reservationId") int reservationId);

}
