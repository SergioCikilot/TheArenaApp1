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

        int pitchId = reservation
                .getPitch().getPitchId();

        List<Reservation> list = this.reservationService
                .getReservationsByReservationDate(reservation.getReservationDate());

        List<Reservation> list2 = this.reservationService
                .getReservationsByReservationTime(reservation.getReservationTime());

        List<Reservation> list3 = this.reservationService
                .getReservationsByPitchPitchId(pitchId);
        boolean anyMatch3 = false;
        boolean anyMatch2 = false;
        boolean anyMatch1 = false;
        for (Reservation res:list) {

            if (res.equals(reservation)){

                anyMatch1 = true;

            }

        }
        for (Reservation res:list2) {

            if (res.equals(reservation)){

                anyMatch2 = true;

            }

        }
        for (Reservation res:list3) {

            if (res.equals(reservation)){

                anyMatch3 = true;

            }

        }

        if (anyMatch1 && anyMatch2 && anyMatch3){

            return false;

        }
        else
            return true;

    }




}
