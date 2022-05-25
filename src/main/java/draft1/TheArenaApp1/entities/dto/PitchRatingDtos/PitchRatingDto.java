package draft1.TheArenaApp1.entities.dto.PitchRatingDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PitchRatingDto {


    @JsonIgnore
    private int ratingId;

    private double ratingScore;

    private int playerId;

    private int pitchId;

}
