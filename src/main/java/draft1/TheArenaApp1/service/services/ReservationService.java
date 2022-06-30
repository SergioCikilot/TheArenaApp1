package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.entities.model.Reservation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void updateReservationIsRated(boolean reservationIsRated ,int reservationId);
    void updateReservationTime(LocalTime reservationTime, int reservationId);
    void updateReservationDate(LocalDate reservationDate, int reservationId);
    void deleteReservation(int id);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByPlayerId(int id);
    List<Reservation> getReservationsByReservationDate(LocalDate reservationDate);
    List<Reservation> getReservationsByReservationTime(LocalTime reservationTime);
    List<Reservation> findReservationsByPitchPitchId(int pitchId);
    Status getReservationStatus(int id);
    Reservation getByReservationId(int id);
}
