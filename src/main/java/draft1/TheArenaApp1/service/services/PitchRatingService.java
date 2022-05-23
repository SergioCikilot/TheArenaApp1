package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;

import java.util.List;

public interface PitchRatingService {

    void addPitchRating (PitchRating pitchRating);
    void deletePitchRating(int id);
    void updatePitchRating(PitchRating pitchRating);
    List<Comment> getPitchRatingsByPitchId(int id);

}
