package draft1.TheArenaApp1.core.utils.status;

import java.util.HashMap;

public class CanceledStatus extends Status{

    private final String status = "Cancelled";

    public CanceledStatus() {

    }

    @Override
    public HashMap<String, String> getStatus() {
        HashMap hashMap = new HashMap<>();
        hashMap.put(getMessage(),status);
        return hashMap;
    }
}
