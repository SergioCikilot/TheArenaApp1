package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.core.entities.comments.Comment;
import draft1.TheArenaApp1.entities.model.Pitch;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);
    void deleteComment(int id);
    void updateComment(Comment comment);
    List<Comment> findCommentsByCommentTarget(int id);

}
