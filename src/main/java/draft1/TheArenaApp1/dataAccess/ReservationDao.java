package draft1.TheArenaApp1.dataAccess;

import draft1.TheArenaApp1.entities.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationDate=:reservationDate where p.reservationId =:reservationId")
    void updateReservationDate(@Param("reservationDate")String reservationDate, @Param("reservationId") int reservationId);

    @Transactional
    @Modifying
    @Query("update Reservation p set p.reservationTime=:reservationTime where p.reservationId =:reservationId")
    void updateReservationTime(@Param("reservationTime")String reservationTime, @Param("reservationId") int reservationId);

    Reservation getByReservationId(int id);

}
