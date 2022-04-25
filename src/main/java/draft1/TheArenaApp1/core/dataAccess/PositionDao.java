package draft1.TheArenaApp1.core.dataAccess;

import draft1.TheArenaApp1.core.entities.positions.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Integer> {
}
