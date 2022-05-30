package draft1.TheArenaApp1.entities.dto.TeamDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeamWithoutIdDto {

    private int teamId;
    private String teamName;

}
