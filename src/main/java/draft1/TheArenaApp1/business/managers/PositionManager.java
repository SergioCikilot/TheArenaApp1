package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.PositionService;
import draft1.TheArenaApp1.core.dataAccess.PositionDao;
import draft1.TheArenaApp1.core.entities.positions.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionManager implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public void add(Position position) {

        this.positionDao.save(position);

    }
}
