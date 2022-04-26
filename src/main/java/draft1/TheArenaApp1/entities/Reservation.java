package draft1.TheArenaApp1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
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

    @JsonIgnore
    @Column(name = "reservation_time")
    private String reservationTime;

    @JsonIgnore
    @Column(name = "reservation_date")
    private String reservationDate;

    @ManyToOne()
    @JoinColumn(name="pitch_id")
    private Pitch pitch;

    @ManyToOne()
    @JoinColumn(name="player_id")
    private Player player;


}
