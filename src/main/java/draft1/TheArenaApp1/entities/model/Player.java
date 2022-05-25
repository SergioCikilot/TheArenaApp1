package draft1.TheArenaApp1.entities.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.foots.FootEnum;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.core.user.User;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","reservations","remarkedComments","remarkedRatings"})
@Document(indexName = "players")



public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    @Field(type = FieldType.Auto)
    @org.springframework.data.annotation.Id
    private int playerId;

    @Field(type = FieldType.Auto)
    @Column(name = "player_name")
    private String playerName;

    @Field(type = FieldType.Auto)
    @Column(name = "player_sirName")
    private String playerSirName;

    @Field(type = FieldType.Auto)
    @Column(name = "player_birthDate")
    private LocalDate playerBirthDate;

    @Field(type = FieldType.Auto)
    @Column(name = "player_height")
    private int playerHeight;

    @Field(type = FieldType.Auto)
    @Enumerated
    @Column(name = "player_foot")
    private FootEnum playerFoot;

    @Field(type = FieldType.Auto)
    @Column(name = "player_isForward")
    private boolean playerIsForward;

    @Field(type = FieldType.Auto)
    @Column(name = "player_isMidfielder")
    private boolean playerIsMidfielder;

    @Field(type = FieldType.Auto)
    @Column(name = "player_isDefender")
    private boolean playerIsDefender;

    @Field(type = FieldType.Auto)
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
