package draft1.TheArenaApp1.entities.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.entities.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","players"})




public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_logo_url")
    private String teamLogoUrl;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "team")//zplayer
    private List<Player> players;

}
