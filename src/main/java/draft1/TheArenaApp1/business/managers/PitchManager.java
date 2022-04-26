package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.PitchService;
import draft1.TheArenaApp1.core.dataAccess.PitchDao;
import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitchManager implements PitchService {

    private PitchDao pitchDao;

    public PitchManager() {
    }

    @Autowired
    public PitchManager(PitchDao pitchDao) {
        this.pitchDao = pitchDao;
    }

    @Override
    public List<Pitch> getAll() {
        return pitchDao.findAll();
    }

    @Override
    public void add(Pitch pitch) {

        this.pitchDao.save(pitch);

    }

    @Override
    public void delete(Pitch pitch) {

        this.pitchDao.delete(pitch);

    }

    @Override
    public void addPitchOpeningTime(String openingTime,int pitchId) {

        this.pitchDao.addPitchOpeningTime(openingTime,pitchId);

    }

    @Override
    public void addPitchClosingTime(String closingTime, int pitchId) {

        this.pitchDao.addPitchClosingTime(closingTime,pitchId);

    }

    @Override
    public void addPitchMatchDuration(String matchDuration, int pitchId) {

        this.pitchDao.addPitchMatchDuration(matchDuration,pitchId);

    }


}
