package io.angel.services;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.angel.memorydatabase.Database;
import io.angel.models.Author;
import io.angel.models.Session;
import io.angel.models.User;

@Component
public class LoginService {

    @Autowired
    private Database database;

    @Autowired
    private Session session;

    private Scanner scanner = new Scanner(System.in);

    public void requestInformation() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        login(username, password);
    }

    private void login(String username, String password) {
        User user = null;
        List<User> users = database.getUsers();
        List<Author> authors = database.getAuthors();

        for(User u: users) {
            if(u.getUsername().equals(username)) {
                user = u;
                break;
            }
        }

        if(user == null) {
            for(Author a: authors) {
                if(a.getUsername().equals(username)) {
                    user = a;
                    break;
                }
            }
        }
        
        if(user != null && user.getPassword().equals(password)) {
            session.createSession(user);
        } else {
            System.out.println("Invalid login!");
        }
    }
}