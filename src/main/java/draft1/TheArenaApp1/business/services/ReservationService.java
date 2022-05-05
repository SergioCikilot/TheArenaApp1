package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Reservation;

import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    void updateReservationTime(String reservationTime, int reservationId);
    void updateReservationDate(String reservationDate, int reservationId);

}
