package draft1.TheArenaApp1.entities.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.entities.positions.PositionEnum;
import draft1.TheArenaApp1.entities.Reservation;
import draft1.TheArenaApp1.entities.Team;
import draft1.TheArenaApp1.security.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerWithoutUserDto {

    private int playerId;

    private String playerName;

    private String playerSirName;

    private PositionEnum positionEnum;





}
