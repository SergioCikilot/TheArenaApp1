package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.core.user.User;
import draft1.TheArenaApp1.core.user.UserDao;
import draft1.TheArenaApp1.service.services.PitchService;
import draft1.TheArenaApp1.repository.PitchDao;
import draft1.TheArenaApp1.entities.model.Pitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PitchManager implements PitchService {

    private final PitchDao pitchDao;
    private final UserDao userDao;

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public PitchManager(PitchDao pitchDao, UserDao userDao) {

        this.pitchDao = pitchDao;
        this.userDao = userDao;
    }

    //add---------------------------------------------------------------------------------------------------------------
    @Override
    public void addPitch(Pitch pitch) {

        this.pitchDao
                .save(pitch);
    }
    @Override
    public void addPitchUserId(String userName, int pitchId) {

        Pitch pitch = this.pitchDao
                .getByPitchId(pitchId);

        User user = this.userDao
                .findUserByUsername(userName)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format("Username %s not found", userName)));

        pitch.setUserPitch(user);

        this.pitchDao.save(pitch);

    }
    //update------------------------------------------------------------------------------------------------------------
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



    //delete------------------------------------------------------------------------------------------------------------
    @Override
    public void deletePitch(int id) {

        Pitch pitch = this.pitchDao
                .getByPitchId(id);
        this.pitchDao
                .delete(pitch);
    }
    //get---------------------------------------------------------------------------------------------------------------
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
}
