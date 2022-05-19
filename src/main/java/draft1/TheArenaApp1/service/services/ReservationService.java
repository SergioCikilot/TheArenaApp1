package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation);
    void deleteReservation(int id);

    void updateReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    List<Reservation> getReservationsByPlayerId(int id);
    void updateReservationTime(LocalTime reservationTime, int reservationId);
    void updateReservationDate(LocalDate reservationDate, int reservationId);
    List<Reservation> getReservationsByReservationDate(LocalDate reservationDate);
    List<Reservation> getReservationsByReservationTime(LocalTime reservationTime);
    List<Reservation> findReservationsByPitchPitchId(int pitchId);
    Reservation getByReservationId(int id);
}
