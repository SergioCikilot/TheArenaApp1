package draft1.TheArenaApp1.core.utils.dateAndTime;

import org.springframework.stereotype.Repository;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Repository
public class DateRepository implements DateAdapter{
    @Override
    public String getFormattedCurrentTime12Hour() {

        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate;
    }

    @Override
    public String getFormattedCurrentTime24Hour() {

        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedDate=dateFormat.format(date);

        return formattedDate;
    }

    @Override
    public String getFormattedCurrentTimeIstanbul24Hour() {

        ZoneId zoneId = ZoneId.of("Europe/Istanbul");
        LocalTime localTime=LocalTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime=localTime.format(formatter);

        return formattedTime;
    }

    @Override
    public String getFormattedCurrentDateIstanbul() {

        LocalDate localDate = LocalDate.now(ZoneId.of("UTC+03:00"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = localDate.format(formatter);
        return formattedDate;
    }

    @Override
    public LocalDate getUnformattedCurrentDateIstanbul() {

        LocalDate localDate = LocalDate.now(ZoneId.of("UTC+03:00"));
        return localDate;

    }


}



