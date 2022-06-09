package draft1.TheArenaApp1.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.utils.status.DoneStatus;
import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.utils.status.WaitingStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reservations")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationId;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "reservation_time")
    private LocalTime reservationTime;
    @FutureOrPresent
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @JsonIgnore
    @Transient
    private Status status;

    @Column(name = "reservation_isRated")
    private Boolean reservationIsRated;

    @ManyToOne()
    @JoinColumn(name="pitch_id")
    private Pitch pitch;

    @ManyToOne()
    @JoinColumn(name="player_id")
    private Player player;

    public Status getStatus() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        if (reservationDate.isAfter(dateNow)){

            return this.status = new WaitingStatus();

        } else if (reservationDate.isBefore(dateNow)) {

            if (reservationIsRated){
                return this.status = new DoneStatus(true);
            }
            return this.status = new DoneStatus(false);

        } else if (reservationDate.isEqual(dateNow)) {

            if (reservationTime.isAfter(timeNow)){

                return this.status = new WaitingStatus();

            } else if (reservationTime.isBefore(timeNow)) {

                if (reservationIsRated){
                    return this.status = new DoneStatus(true);
                }
                return this.status = new DoneStatus(false);
            }
            return this.status = new Status();
        }
        return this.status = new Status();
    }

}
