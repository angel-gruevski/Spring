package io.angel.models;

import java.util.ArrayList;
import java.util.List;

public class Author extends User {
    List<Post> posts;

    public Author(String fname, String lname, String username, String password) {
        super(fname, lname, username, password);
        posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }
}