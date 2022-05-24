package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.core.entities.ratings.PitchRating;
import draft1.TheArenaApp1.entities.model.Pitch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PitchService {

    List<Pitch> getAllPitches();
    List<Pitch> getAllPitchesWithPage(int pageNo, int pageSize);
    void addPitch(Pitch pitch);
    void deletePitch(int id);
    void updatePitch(Pitch pitch);
    void updatePitchOpeningTime(String openingTime, int pitchId);
    void updatePitchClosingTime(String closingTime, int pitchId);
    void updatePitchMatchDuration(String matchDuration, int pitchId);
    //List<Pitch> findByPitchName(String name);



}
