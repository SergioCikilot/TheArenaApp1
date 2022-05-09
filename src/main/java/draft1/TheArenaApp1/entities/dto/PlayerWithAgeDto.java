package draft1.TheArenaApp1.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerWithAgeDto {

    private int id;
    private String playerName;
    private String playerAge;

}
