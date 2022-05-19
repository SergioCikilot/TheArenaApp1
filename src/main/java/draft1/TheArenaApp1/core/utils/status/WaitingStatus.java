package draft1.TheArenaApp1.core.utils.status;

import lombok.Data;

import java.util.HashMap;

@Data
public class WaitingStatus extends Status {

    public WaitingStatus() {
        super("Waiting");
    }
}
