package draft1.TheArenaApp1.core.utils.DateAndTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeManager {

    @Autowired
    private DateAdapter dateAdapter;


    public AgeManager(DateAdapter dateAdapter) {

        this.dateAdapter = dateAdapter;
    }

    public String AgeCalculator(){


        return null;

    }

}
