package draft1.TheArenaApp1.dataAccess;

import draft1.TheArenaApp1.entities.Pitch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;




    public interface PitchDao extends MongoRepository<Pitch,String> {

        Pitch getByPitchName(String PitchName);
}