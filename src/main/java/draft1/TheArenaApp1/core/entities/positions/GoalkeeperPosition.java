package draft1.TheArenaApp1.core.entities.positions;

import draft1.TheArenaApp1.entities.Player;

import javax.persistence.OneToMany;
import java.util.List;

public class GoalkeeperPosition extends Position{

    public GoalkeeperPosition(List list) {
        super(1, "Goalkeeper", list);
    }
}
