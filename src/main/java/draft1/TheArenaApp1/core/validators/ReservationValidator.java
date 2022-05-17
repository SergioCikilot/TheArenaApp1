package draft1.TheArenaApp1.core.validators;

import draft1.TheArenaApp1.entities.model.Reservation;
import draft1.TheArenaApp1.service.services.ReservationService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Data
@NoArgsConstructor
public class ReservationValidator {

    private ReservationService reservationService;

    @Autowired
    public ReservationValidator(ReservationService reservationService) {

        this.reservationService = reservationService;
    }

    public boolean IsValid(Reservation reservation){

        String date = reservation
                .getReservationDate();

        String time = reservation
                .getReservationTime();

        int pitchId = reservation
                .getPitch().getPitchId();

        List<Reservation> list = this.reservationService
                .getReservationsByReservationDate(date);

        List<Reservation> list2 = this.reservationService
                .getReservationsByReservationTime(time);

        List<Reservation> list3 = this.reservationService
                .getReservationsByPitchPitchId(pitchId);

        boolean anyMatch1 = list.stream()
                .anyMatch(reservation1 ->
                        reservation
                                .getReservationDate()
                                .equals(date));

        boolean anyMatch2 = list.stream()
                .anyMatch(reservation1 ->
                        reservation
                                .getReservationTime()
                                .equals(time));

        boolean anyMatch3 = list.stream()
                .anyMatch(reservation1 ->
                        reservation
                                .getPitch()
                                .getPitchId() == pitchId);

        if (anyMatch1 && anyMatch2 && anyMatch3){

            return false;

        }
        else
            return true;

    }




}
