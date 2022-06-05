package draft1.TheArenaApp1.core.utils.status;

import lombok.Data;


@Data
public class DoneStatus extends Status{

    private boolean isRated;
    public DoneStatus(boolean isRated) {
        super("Done");
        this.isRated= isRated;
    }
}
