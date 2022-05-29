package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.service.services.PitchService;
import draft1.TheArenaApp1.repository.PitchDao;
import draft1.TheArenaApp1.entities.model.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PitchManager implements PitchService {

    private final PitchDao pitchDao;

    @Autowired
    public PitchManager(PitchDao pitchDao) {
        this.pitchDao = pitchDao;

    }

    @Override
    public List<Pitch> getAllPitches() {

        return pitchDao
                .findAll();
    }

    @Override
    public List<Pitch> getAllPitchesWithPage(int pageNo, int pageSize)
    {
        Pageable pageable = PageRequest
                .of(pageNo,pageSize);
        return this.pitchDao
                .findAll(pageable).getContent();
    }

    @Override
    public void addPitch(Pitch pitch) {

        this.pitchDao
                .save(pitch);
    }

    @Override
    public void deletePitch(int id) {

        Pitch pitch = this.pitchDao
                .getByPitchId(id);
        this.pitchDao
                .delete(pitch);
    }

    @Override
    public void updatePitch(Pitch pitch) {

        this.pitchDao
                .save(pitch);
    }

    @Override
    public void updatePitchOpeningTime(String openingTime, int pitchId) {

        this.pitchDao
                .updatePitchOpeningTime(openingTime,pitchId);
    }

    @Override
    public void updatePitchClosingTime(String closingTime, int pitchId) {

        this.pitchDao
                .updatePitchClosingTime(closingTime,pitchId);
    }

    @Override
    public void updatePitchMatchDuration(String matchDuration, int pitchId) {

        this.pitchDao
                .updatePitchMatchDuration(matchDuration,pitchId);
    }

    /*@Override
    public List<Pitch> findByPitchName(String name) {
        Page<Pitch> pitchPage = pitchSearchDao
                .findByPitchName(
                        name,
                        PageRequest
                                .of(0,20));
        return pitchPage.getContent();

    }*/


}
