package draft1.TheArenaApp1.entities.dto.PlayerDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.entities.foots.FootEnum;
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
public class PlayerWithIdUser {


    private int playerId ;

    private int userId;

    private String playerName;

    private String playerSirName;

    private int playerHeight;
    /*@Enumerated
    private PositionEnum playerPosition;*/

    private boolean playerIsForward;

    private boolean playerIsMidfielder;

    private boolean playerIsDefender;

    private boolean playerIsGoalkeeper;
    @Enumerated
    private FootEnum playerFoot;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past
    private LocalDate ageBirthDate;

}
