package draft1.TheArenaApp1.core.utilities.DateAndTime;

import draft1.TheArenaApp1.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
@Service
public class AgeManager {

    @Autowired
    private DateAdapter dateAdapter;


    public AgeManager(DateAdapter dateAdapter) {

        this.dateAdapter = dateAdapter;
    }

    public String AgeCalculator(Player player){

        LocalDate startDate = player.getAgeBirthDate();
        LocalDate endDate = dateAdapter.getUnformattedCurrentDateIstanbul();
        Period period = Period.between(startDate, endDate);
        String age =String.format("%d", period.getYears());
        return age;

    }

}
