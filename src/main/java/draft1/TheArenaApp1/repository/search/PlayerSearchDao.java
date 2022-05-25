package draft1.TheArenaApp1.repository.search;

import draft1.TheArenaApp1.entities.model.Player;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PlayerSearchDao extends ElasticsearchRepository<Player,Integer> {

    List<Player> findByPlayerNameLike(String name);

}
