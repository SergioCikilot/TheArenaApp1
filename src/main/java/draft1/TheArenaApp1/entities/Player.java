package draft1.TheArenaApp1.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import draft1.TheArenaApp1.core.entities.positions.Position;
import draft1.TheArenaApp1.core.entities.positions.PositionEnum;
import draft1.TheArenaApp1.security.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations"})


public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_sirName")
    private String playerSirName;

    @Column(name = "age_birthDate")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate ageBirthDate;
    /*@ManyToMany()
    @JoinColumn(name="position_id")
    private List<Position> playerPositions;*/
    @Enumerated
    @Column(name = "player_position")
    private PositionEnum positionEnum;
    @ManyToOne()
    @JoinColumn(name="team_id")
    @JsonIgnore
    private Team team;

    @OneToMany(mappedBy = "player")
    private List<Reservation> reservations;

    @OneToOne(mappedBy = "player")
    private User user;

}
