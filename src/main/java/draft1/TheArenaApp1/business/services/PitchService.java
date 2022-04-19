package draft1.TheArenaApp1.business.services;

import draft1.TheArenaApp1.entities.Pitch;

import java.util.List;

public interface PitchService {

    List<Pitch> getAll();
    void add(Pitch pitch);
    Pitch getByPitchName(String pitchName);

}
