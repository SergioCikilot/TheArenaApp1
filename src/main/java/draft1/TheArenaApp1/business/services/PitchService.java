package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Pitch;

import java.util.List;

public interface PitchService {

    List<Pitch> getAllPitches();
    List<Pitch> getAllPitchesWithPage(int pageNo, int pageSize);
    void addPitch(Pitch pitch);
    void deletePitch(Pitch pitch);
    void updatePitchOpeningTime(String openingTime, int pitchId);
    void updatePitchClosingTime(String closingTime, int pitchId);
    void updatePitchMatchDuration(String matchDuration, int pitchId);




}
