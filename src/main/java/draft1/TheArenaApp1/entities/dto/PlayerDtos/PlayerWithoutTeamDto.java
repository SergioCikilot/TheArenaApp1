package draft1.TheArenaApp1.entities.dto.PlayerDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import draft1.TheArenaApp1.entities.model.FootEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerWithoutTeamDto {

    private int playerId ;

    private int userId;

    private String playerName;

    private String playerSirName;

    private int playerHeight;

    private boolean playerIsForward;

    private boolean playerIsMidfielder;

    private boolean playerIsDefender;

    private boolean playerIsGoalkeeper;
    @Enumerated
    private FootEnum playerFoot;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate playerBirthDate;


}
