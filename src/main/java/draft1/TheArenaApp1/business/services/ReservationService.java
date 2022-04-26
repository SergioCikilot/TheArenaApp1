package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Player;
import draft1.TheArenaApp1.entities.Reservation;

import java.util.List;

public interface ReservationService {

    void add(Reservation reservation);
    void delete(Reservation reservation);
    List<Reservation> getAll();
    void addReservationTime(String reservationTime,int reservationId);
    void addReservationDate(String reservationDate,int reservationId);

}
