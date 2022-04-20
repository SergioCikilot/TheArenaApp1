package draft1.TheArenaApp1.business.managers;

import draft1.TheArenaApp1.business.services.PitchService;
import draft1.TheArenaApp1.dataAccess.PitchDao;
import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitchManager implements PitchService {

    private PitchDao pitchDao;

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

        pitchDao.save(pitch);

    }




}
