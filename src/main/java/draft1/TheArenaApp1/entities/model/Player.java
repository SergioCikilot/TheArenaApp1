package draft1.TheArenaApp1.entities.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.core.entities.positions.PositionEnum;
import draft1.TheArenaApp1.security.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String playerBirthDate;

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

    @OneToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
