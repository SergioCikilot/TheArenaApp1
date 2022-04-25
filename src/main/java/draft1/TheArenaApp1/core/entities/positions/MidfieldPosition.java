package draft1.TheArenaApp1.core.entities.positions;

import draft1.TheArenaApp1.entities.Player;

import javax.persistence.OneToMany;
import java.util.List;

public class MidfieldPosition extends Position{

    public MidfieldPosition(int positionId, String position, List list) {
        super(3, "Midfield", list);
    }
}
