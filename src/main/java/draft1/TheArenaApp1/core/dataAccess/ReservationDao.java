package draft1.TheArenaApp1.core.dataAccess;

import draft1.TheArenaApp1.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {
}
