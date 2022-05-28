package draft1.TheArenaApp1.entities.dto;


import draft1.TheArenaApp1.entities.dto.CommentDtos.CommentDto;
import draft1.TheArenaApp1.entities.dto.PitchRatingDtos.PitchRatingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentAndPitchRatingDto {

    private CommentDto commentDto;

    private PitchRatingDto pitchRatingDto;

}
