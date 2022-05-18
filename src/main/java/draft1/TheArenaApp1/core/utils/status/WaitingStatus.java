package draft1.TheArenaApp1.core.utils.status;

import lombok.Data;

import java.util.HashMap;

@Data
public class WaitingStatus extends Status {

    private String status = "Waiting";

    public WaitingStatus() {

    }

    @Override
    public HashMap<String, String> getStatus() {
        HashMap hashMap = new HashMap<>();
        hashMap.put(getMessage(),status);
        return hashMap;
    }
}
