package draft1.TheArenaApp1.core.utils.status;

import lombok.Data;

import java.util.HashMap;

@Data
public class DoneStatus extends Status{

    private String status = "Done";

    public DoneStatus() {


    }
    @Override
    public HashMap<String, String> getStatus() {
        HashMap hashMap = new HashMap<>();
        hashMap.put(getMessage(),status);
        return hashMap;
    }
}
