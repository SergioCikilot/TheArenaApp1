package draft1.TheArenaApp1.repository;

import draft1.TheArenaApp1.entities.model.PitchRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PitchRatingDao extends JpaRepository<PitchRating,Integer> {

    List<PitchRating> getPitchRatingsByPitchPitchId(int id);
}
