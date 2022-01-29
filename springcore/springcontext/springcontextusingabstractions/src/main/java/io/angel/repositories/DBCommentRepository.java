package io.angel.repositories;

import io.angel.main.Comment;
import static java.lang.System.out;

import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        out.println("Storing comment: " + comment.getText());
    }
}