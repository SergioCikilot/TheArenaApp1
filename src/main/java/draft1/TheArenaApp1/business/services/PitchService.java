package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Pitch;

import java.util.List;

public interface PitchService {

    List<Pitch> getAll();
    void add(Pitch pitch);
    void delete(Pitch pitch);
    void addPitchOpeningTime(String openingTime,int pitchId);
    void addPitchClosingTime(String closingTime,int pitchId);

    void addPitchMatchDuration(String matchDuration,int pitchId);



}
