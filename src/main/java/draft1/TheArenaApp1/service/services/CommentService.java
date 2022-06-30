package draft1.TheArenaApp1.service.services;

import draft1.TheArenaApp1.entities.model.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(int id);
    List<Comment> findCommentsByCommentTarget(int id);

}
