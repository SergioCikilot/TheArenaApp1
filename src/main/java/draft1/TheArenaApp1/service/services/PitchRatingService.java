package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.PitchRating;

import java.util.List;

public interface PitchRatingService {

    void addPitchRating (PitchRating pitchRating);
    void deletePitchRating(int id);
    void updatePitchRating(PitchRating pitchRating);
    List<PitchRating> getPitchRatingsByPitchId(int id);

}
