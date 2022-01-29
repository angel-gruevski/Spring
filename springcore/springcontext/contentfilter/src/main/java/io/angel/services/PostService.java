package io.angel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.angel.annotations.DeletePostPermission;
import io.angel.memorydatabase.Database;
import io.angel.models.Post;

@Component
public class PostService {
    @Autowired
    private Database database;

    public Post getPost(String id) {
        List<Post> posts = database.getPosts();
        Post post = null;

        for(Post p : posts) {
            if(p.getPostId().equals(id)) {
                post = p;
                break;
            }
        }

        return post;
    }

    public List<Post> getPosts() {
        return database.getPosts();
    }

    public void createPost(Post post) {
        database.getPosts().add(post);
    }

    @DeletePostPermission
    public void deletePost(String id) {
        Post post = getPost(id);
        getPosts().remove(post);
    }
}