package draft1.TheArenaApp1.entities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.utils.status.DoneStatus;
import draft1.TheArenaApp1.core.utils.status.Status;
import draft1.TheArenaApp1.core.utils.status.WaitingStatus;
import draft1.TheArenaApp1.entities.model.Pitch;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    //@Temporal(TemporalType.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "reservation_time")
    private LocalTime reservationTime;
    @FutureOrPresent
    //@Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "reservation_date")
    private LocalDate reservationDate;


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

    public Reservation(int reservationId, LocalTime reservationTime, LocalDate reservationDate, Pitch pitch, Player player) {
        this.reservationId = reservationId;
        this.reservationTime = reservationTime;
        this.reservationDate = reservationDate;
        this.status = setStatus();
        this.pitch = pitch;
        this.player = player;
    }

    public Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        this.status = setStatus();
    }

    public Status setStatus() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        if (reservationDate.isAfter(dateNow)){

            return this.status = new WaitingStatus();

        } else if (reservationDate.isBefore(dateNow)) {

            return this.status = new DoneStatus();

        } else if (reservationDate.isEqual(dateNow)) {

            if (reservationTime.isAfter(timeNow)){

                return this.status = new WaitingStatus();

            } else if (reservationTime.isBefore(timeNow)) {

                return this.status = new DoneStatus();

            }

            return this.status = new Status();

        }
        return this.status = new Status();


    }
}
