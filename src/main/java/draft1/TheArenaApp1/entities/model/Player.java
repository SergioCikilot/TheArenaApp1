package draft1.TheArenaApp1.entities.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.foots.FootEnum;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.core.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
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

    @Column(name = "player_birthDate")
    private String playerBirthDate;

    @Column(name = "player_height")
    private int playerHeight;

    @Enumerated
    @Column(name = "player_foot")
    private FootEnum playerFoot;

    @Column(name = "player_isForward")
    private boolean playerIsForward;
    @Column(name = "player_isMidfielder")
    private boolean playerIsMidfielder;
    @Column(name = "player_isDefender")
    private boolean playerIsDefender;
    @Column(name = "player_isGoalkeeper")
    private boolean playerIsGoalkeeper ;
    @ManyToOne()
    @JoinColumn(name="team_id")
    @JsonIgnore
    private Team team;

    @OneToMany(mappedBy = "player")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "player")
    private List<Comment> remarkedComments;

    @OneToMany(mappedBy = "player")
    private List<PitchRating> remarkedRatings ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnore
    private User user;

    /*@ManyToMany()
    @JoinColumn(name="position_id")
    private List<Position> playerPositions;*/

    /*@Enumerated
    @Column(name = "player_position")
    private PositionEnum playerPosition;*/

}
