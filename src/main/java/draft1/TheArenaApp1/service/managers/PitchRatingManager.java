package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.entities.model.PitchRating;
import draft1.TheArenaApp1.repository.PitchRatingDao;
import draft1.TheArenaApp1.service.services.PitchRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitchRatingManager implements PitchRatingService {

    private final PitchRatingDao pitchRatingDao;

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public PitchRatingManager(PitchRatingDao pitchRatingDao) {
        this.pitchRatingDao = pitchRatingDao;
    }

    //add---------------------------------------------------------------------------------------------------------------
    @Override
    public void addPitchRating(PitchRating pitchRating) {

        this.pitchRatingDao
                .save(pitchRating);
    }
    //update------------------------------------------------------------------------------------------------------------
    @Override
    public void updatePitchRating(PitchRating pitchRating) {

        this.pitchRatingDao
                .save(pitchRating);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @Override
    public void deletePitchRating(int id) {

        PitchRating pitchRating = this.pitchRatingDao
                .getById(id);
        this.pitchRatingDao
                .delete(pitchRating);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @Override
    public List<PitchRating> getPitchRatingsByPitchId(int id) {

        return this.pitchRatingDao.getPitchRatingsByPitchPitchId(id);
    }
}
