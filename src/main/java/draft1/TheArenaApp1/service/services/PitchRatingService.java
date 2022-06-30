package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.PitchRating;

import java.util.List;

public interface PitchRatingService {

    void addPitchRating (PitchRating pitchRating);
    void updatePitchRating(PitchRating pitchRating);
    void deletePitchRating(int id);
    List<PitchRating> getPitchRatingsByPitchId(int id);

}
