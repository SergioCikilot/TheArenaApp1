package draft1.TheArenaApp1;

import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.utils.status.WaitingStatus;
import draft1.TheArenaApp1.entities.model.Reservation;
import org.junit.jupiter.api.Test;

public class StatusTest {

    private Status underTest = new Status();
    private Status waitingStatus = new WaitingStatus();

    @Test
    void itShouldReturnTrue(){
        //given
        Reservation reservation = new Reservation();
        //when-underTest
        boolean isExist = underTest.statusFieldExists(reservation);
        //then-assertThat
        assert isExist = true;

    }
    @Test
    void itShouldReturnStatusWaiting(){
        //given
        //Reservation reservation = new Reservation();
        //when-underTest
        //reservation.setReservationDate("2023-01-01");
        //reservation.setStatus();
        //then-assertThat
        //assert reservation.getStatus().equals(waitingStatus);

    }


}
