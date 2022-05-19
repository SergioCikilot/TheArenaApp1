package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.service.services.ReservationService;
import draft1.TheArenaApp1.repository.ReservationDao;
import draft1.TheArenaApp1.entities.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ReservationManager implements ReservationService {

    private ReservationDao reservationDao;

    @Autowired
    public ReservationManager(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }


    @Override
    public void addReservation(Reservation reservation) {

        this.reservationDao
                .save(reservation);

    }

    @Override
    public void deleteReservation(int id) {

        Reservation reservation = this.reservationDao
                .getReservationByReservationId(id);
        this.reservationDao
                .delete(reservation);

    }

    @Override
    public void updateReservation(Reservation reservation) {

        this.reservationDao
                .save(reservation);

    }

    @Override
    public List<Reservation> getAllReservations() {

        return this.reservationDao
                .findAll();
    }

    @Override
    public List<Reservation> getReservationsByPlayerId(int id) {

        return this.reservationDao
                .getReservationsByPlayerPlayerId(id);

    }


    @Override
    public void updateReservationTime(LocalTime reservationTime, int reservationId) {

        this.reservationDao
                .updateReservationTime(reservationTime,reservationId);

    }

    @Override
    public void updateReservationDate(LocalDate reservationDate, int reservationId) {

        this.reservationDao
                .updateReservationDate(reservationDate,reservationId);

    }

    @Override
    public List<Reservation> getReservationsByReservationDate(LocalDate reservationDate) {
        return this.reservationDao
                .getReservationsByReservationDate(reservationDate);
    }

    @Override
    public List<Reservation> getReservationsByReservationTime(LocalTime reservationTime) {
        return this.reservationDao
                .getReservationsByReservationTime(reservationTime);
    }

    @Override
    public List<Reservation> findReservationsByPitchPitchId(int pitchId) {
        return this.reservationDao
                .findReservationsByPitchPitchId(pitchId);
    }

    @Override
    public Status getReservationStatus(int id) {

        Reservation reservation = this.reservationDao.getReservationByReservationId(id);

        return reservation.getStatus();
    }

    @Override
    public Reservation getByReservationId(int id) {
        return this.reservationDao.getReservationByReservationId(id);
    }


}
