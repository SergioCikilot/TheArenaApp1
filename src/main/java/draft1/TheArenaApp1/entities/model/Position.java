package draft1.TheArenaApp1.entities.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Table(name = "position")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","players"})
public class Position <T>
{

    @Id
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "position")
    private String position;


}
