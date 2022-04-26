package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.ReservationService;
import draft1.TheArenaApp1.core.dataAccess.ReservationDao;
import draft1.TheArenaApp1.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationManager implements ReservationService {

    private ReservationDao reservationDao;

    @Autowired
    public ReservationManager(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }


    @Override
    public void add(Reservation reservation) {

        this.reservationDao.save(reservation);

    }

    @Override
    public void delete(Reservation reservation) {

        this.reservationDao.delete(reservation);

    }

    @Override
    public List<Reservation> getAll() {
        return this.reservationDao.findAll();
    }

    @Override
    public void addReservationTime(String reservationTime, int reservationId) {

        this.reservationDao.addReservationTime(reservationTime,reservationId);

    }

    @Override
    public void addReservationDate(String reservationDate, int reservationId) {

        this.reservationDao.addReservationDate(reservationDate,reservationId);

    }
}
