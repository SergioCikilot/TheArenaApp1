package draft1.TheArenaApp1.core.entities.positions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import draft1.TheArenaApp1.entities.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "position")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","players"})
public class Position <T>
{

    @Id
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "playerPosition")
    private List<Player> players;


}
