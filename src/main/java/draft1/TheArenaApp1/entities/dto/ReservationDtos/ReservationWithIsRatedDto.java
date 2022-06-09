package draft1.TheArenaApp1.entities.dto.ReservationDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationWithIsRatedDto {

    private int reservationId;
    private Boolean reservationIsRated;

}
