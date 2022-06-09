package draft1.TheArenaApp1.service.managers;

import draft1.TheArenaApp1.entities.model.Comment;
import draft1.TheArenaApp1.repository.CommentDao;
import draft1.TheArenaApp1.service.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentManager implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentManager(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public void addComment(Comment comment) {

        this.commentDao
                .save(comment);
    }

    @Override
    public void deleteComment(int id) {

        Comment comment = this.commentDao
                .getById(id);
        this.commentDao
                .delete(comment);
    }

    @Override
    public void updateComment(Comment comment) {

        this.commentDao
                .save(comment);
    }

    @Override
    public List<Comment> findCommentsByCommentTarget(int id) {

        return this.commentDao
                .findCommentsByPitchPitchId(id);
    }
}
