package draft1.TheArenaApp1.core.dataAccess;

import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface PitchDao extends JpaRepository<Pitch,Integer> {



}