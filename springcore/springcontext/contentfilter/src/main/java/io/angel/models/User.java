package io.angel.models;

import java.util.UUID;

public class User {
    private String fname, lname;
    private String username;
    private String password;
    private final String ID;

    public User(String fname, String lname, String username, String password) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        ID = UUID.randomUUID().toString();
    }

    public String getFullName() {
        return String.format("%s %s", fname, lname);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return fname + " " + lname;
    }

    @Override
    public boolean equals(Object obj) {
        Author a = (Author) obj;
        return this.ID.equals(a.getID());
    }
}