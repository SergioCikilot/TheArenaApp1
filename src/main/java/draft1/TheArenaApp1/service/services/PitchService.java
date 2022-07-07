package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Pitch;

import java.util.List;

public interface PitchService {

    void addPitch(Pitch pitch);
    void updatePitch(Pitch pitch);
    void updatePitchOpeningTime(String openingTime, int pitchId);
    void updatePitchClosingTime(String closingTime, int pitchId);
    void updatePitchMatchDuration(String matchDuration, int pitchId);
    void addPitchUserId(String userName, int pitchId);
    void deletePitch(int id);
    List<Pitch> getAllPitches();
    List<Pitch> getAllPitchesWithPage(int pageNo, int pageSize);
    Pitch getByPitchId(int id);

    //List<Pitch> findByPitchName(String name);



}
