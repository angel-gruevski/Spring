package io.angel.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post {
    private String postID;
    private Author author;
    private String title;
    private String content;
    private List<Comment> comments;

    public Post(Author author, String title, String content) {
        postID = UUID.randomUUID().toString();
        this.author = author;
        this.title = title;
        this.content = content;
        comments = new ArrayList<>();
    }

    public String getPostId() {
        return postID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }
}