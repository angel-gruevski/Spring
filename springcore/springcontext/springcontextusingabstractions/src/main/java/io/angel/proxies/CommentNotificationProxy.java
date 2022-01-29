package io.angel.proxies;

import org.springframework.beans.factory.annotation.Qualifier;

import io.angel.main.Comment;

public interface CommentNotificationProxy {
    public abstract void sendComment(Comment comment);
}