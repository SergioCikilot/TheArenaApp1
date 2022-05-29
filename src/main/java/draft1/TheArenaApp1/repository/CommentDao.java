package draft1.TheArenaApp1.repository;

import draft1.TheArenaApp1.core.entities.comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {

    List<Comment> findCommentsByPitchPitchId(int id);

}
