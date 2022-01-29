package io.angel.models;

import org.springframework.stereotype.Component;

@Component
public class Session {
    private User user;

    public Session() {
        user = null;
    }

    public void createSession(User u) {
        this.user = u;
    }

    public User getUserSession() {
        return user;
    }

    public void invalidateSession() {
        user = null;
    }
}