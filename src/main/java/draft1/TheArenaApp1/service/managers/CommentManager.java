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

    //cons--------------------------------------------------------------------------------------------------------------
    @Autowired
    public CommentManager(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    //add---------------------------------------------------------------------------------------------------------------
    @Override
    public void addComment(Comment comment) {

        this.commentDao
                .save(comment);
    }
    //update------------------------------------------------------------------------------------------------------------
    @Override
    public void updateComment(Comment comment) {

        this.commentDao
                .save(comment);
    }
    //delete------------------------------------------------------------------------------------------------------------
    @Override
    public void deleteComment(int id) {

        Comment comment = this.commentDao
                .getById(id);
        this.commentDao
                .delete(comment);
    }
    //get---------------------------------------------------------------------------------------------------------------
    @Override
    public List<Comment> findCommentsByCommentTarget(int id) {

        return this.commentDao
                .findCommentsByPitchPitchId(id);
    }
}
