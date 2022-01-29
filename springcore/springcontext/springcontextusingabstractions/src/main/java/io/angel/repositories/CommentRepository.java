package io.angel.repositories;

import io.angel.main.Comment;

public interface CommentRepository {
    public abstract void storeComment(Comment comment);
}
