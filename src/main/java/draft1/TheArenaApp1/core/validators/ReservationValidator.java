package draft1.TheArenaApp1.core.validators;

import draft1.TheArenaApp1.entities.model.Reservation;
import draft1.TheArenaApp1.service.services.ReservationService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
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

        ArrayList<Reservation> list = new ArrayList<>(this.reservationService
                .findReservationsByPitchPitchId(
                        reservation
                                .getPitch()
                                .getPitchId()));

        List<Reservation> listForDateMatches = new ArrayList<>();


        for (Reservation r : list) {

            LocalDate date = r.getReservationDate();
            LocalDate resDate =reservation.getReservationDate();
            boolean match =  resDate
                    .isEqual(date);
            if (match){

                listForDateMatches.add(r);
            }
            boolean isExist = listForDateMatches
                    .stream()
                    .anyMatch(reservation1 ->
                            reservation1
                                    .getReservationTime()
                                    .equals(reservation
                                            .getReservationTime()));
            if (isExist){

                return false;

            }
        }

        return true;

    }




}
