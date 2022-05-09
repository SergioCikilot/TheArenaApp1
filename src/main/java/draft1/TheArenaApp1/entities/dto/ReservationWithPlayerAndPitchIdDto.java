package draft1.TheArenaApp1.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationWithPlayerAndPitchIdDto {

    private int reservationId;

    @Future
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime reservationTime;

    @Future
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate reservationDate;

    private int pitchId;

    private int playerId;

}
