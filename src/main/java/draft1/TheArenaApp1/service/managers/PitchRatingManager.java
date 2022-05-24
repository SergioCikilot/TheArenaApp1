package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.repository.PitchRatingDao;
import draft1.TheArenaApp1.service.services.PitchRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitchRatingManager implements PitchRatingService {

    private final PitchRatingDao pitchRatingDao;

    @Autowired
    public PitchRatingManager(PitchRatingDao pitchRatingDao) {
        this.pitchRatingDao = pitchRatingDao;
    }

    @Override
    public void addPitchRating(PitchRating pitchRating) {

        this.pitchRatingDao
                .save(pitchRating);
    }

    @Override
    public void deletePitchRating(int id) {

        PitchRating pitchRating = this.pitchRatingDao
                .getById(id);
        this.pitchRatingDao
                .delete(pitchRating);
    }

    @Override
    public void updatePitchRating(PitchRating pitchRating) {

        this.pitchRatingDao
                .save(pitchRating);
    }

    @Override
    public List<Comment> getPitchRatingsByPitchId(int id) {

        return null;
    }
}
