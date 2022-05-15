package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Reservation;

import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation);
    void deleteReservation(int id);

    void updateReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationByPlayerId(int id);
    void updateReservationTime(String reservationTime, int reservationId);
    void updateReservationDate(String reservationDate, int reservationId);

}
