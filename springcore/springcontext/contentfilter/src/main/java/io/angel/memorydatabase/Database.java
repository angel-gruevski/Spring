package io.angel.memorydatabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.angel.models.Author;
import io.angel.models.Comment;
import io.angel.models.Post;
import io.angel.models.User;

@Component
public class Database {
    private List<User> users;
    private List<Author> authors;
    private List<Post> posts;
    private List<Comment> comments;

    public Database() {
        users = new ArrayList<>();
        authors = new ArrayList<>();
        posts = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Comment> getComments() {
        return comments;
    }
}