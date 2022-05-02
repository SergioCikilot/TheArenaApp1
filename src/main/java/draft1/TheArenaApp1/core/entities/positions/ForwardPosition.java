package draft1.TheArenaApp1.core.entities.positions;

import draft1.TheArenaApp1.entities.Player;

import javax.persistence.OneToMany;
import java.util.List;

public class ForwardPosition extends Position {

    public ForwardPosition() {
        super(4, "Forward");
    }
}
