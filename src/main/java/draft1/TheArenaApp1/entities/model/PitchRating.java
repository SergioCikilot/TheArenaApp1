package draft1.TheArenaApp1.entities.model;

import draft1.TheArenaApp1.entities.model.Pitch;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PitchRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating_score")
    @Min(0)
    @Max(5)
    private double ratingScore;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name="pitch_id")
    private Pitch pitch;

// burdan devam et




}
