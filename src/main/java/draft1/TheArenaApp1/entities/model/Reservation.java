package draft1.TheArenaApp1.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.utils.status.DoneStatus;
import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.utils.status.WaitingStatus;
import draft1.TheArenaApp1.entities.model.Pitch;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int reservationId;

    @Column(name = "reservation_time")
    private String reservationTime;

    @Column(name = "reservation_date")
    private String reservationDate;

    @NotEmpty
    @Transient
    private Status status;

    @ManyToOne()
    @JoinColumn(name="pitch_id")
    private Pitch pitch;

    @ManyToOne()
    @JoinColumn(name="player_id")
    private Player player;

    public Status getStatus() {
        return status;
    }


    public void setStatus() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        LocalDate date = LocalDate.parse(reservationDate);
        LocalTime time = LocalTime.parse(reservationDate);

        if (date.isAfter(dateNow)){

            this.status = new WaitingStatus();

        } else if (date.isBefore(dateNow)) {

            this.status = new DoneStatus();

        } else if (date.isEqual(dateNow)) {

            if (time.isAfter(timeNow)){

                this.status = new WaitingStatus();

            } else if (time.isBefore(timeNow)) {

                this.status = new DoneStatus();

            }

            this.status = new Status();

        }
        this.status = new Status();


    }
}
