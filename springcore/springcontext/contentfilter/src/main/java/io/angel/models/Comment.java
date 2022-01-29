package io.angel.models;

import java.util.UUID;

public class Comment {
    private final String ID;
    private Post post;
    private String content;

    public Comment(Post post, String content) {
        ID = UUID.randomUUID().toString();
        this.post = post;
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }
}