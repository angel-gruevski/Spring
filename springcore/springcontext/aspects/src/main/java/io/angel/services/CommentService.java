package io.angel.services;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import io.angel.annotation.ModifyRequest;
import io.angel.annotation.SecureMethod;
import io.angel.model.Comment;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @SecureMethod
    @ModifyRequest
    public String publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        return "SUCCESS";
    }

    @SecureMethod
    public String deleteComment(Comment comment) {
        logger.info("Deleting comment:" + comment.getText());
        return "SUCCESS";
    }

    @SecureMethod
    public String editComment(Comment comment) {
        logger.info("Editing comment:" + comment.getText());
        return "SUCCESS";
    }
}