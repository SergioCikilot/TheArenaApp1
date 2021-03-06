package draft1.TheArenaApp1.core.utils.dateTime;


import java.time.LocalDate;

public interface DateAdapter  {

    String getFormattedCurrentTime12Hour();
    String getFormattedCurrentTime24Hour();
    String getFormattedCurrentTimeIstanbul24Hour();
    String getFormattedCurrentDateIstanbul();
    LocalDate getUnformattedCurrentDateIstanbul();

}

