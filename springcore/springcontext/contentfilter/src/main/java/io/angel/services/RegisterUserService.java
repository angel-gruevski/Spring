package io.angel.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.angel.memorydatabase.Database;
import io.angel.models.Author;
import io.angel.models.User;

@Component
public class RegisterUserService {
    @Autowired
    private Database database;
    private Scanner scanner = new Scanner(System.in);
    
    public void requestInformation() {
        System.out.print("Enter your first name: ");
        String fname = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lname = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("For Author enter 1, otherwise anter any number?");
        try {
            int typeOfUser = scanner.nextInt();
            registerUser(fname, lname, username, password, typeOfUser);
        } catch(InputMismatchException exception) {
            System.out.println("Entered data was not an integer, please try again !");
        }
    }
    
    public void registerUser(String fname, String lname, String username, String password, int typeOfUser) {
        if(typeOfUser == 1) {
            Author author = new Author(fname, lname, username, password);
            database.getAuthors().add(author);
        } else {
            User user = new User(fname, lname, username, password);
            database.getUsers().add(user);
        } 
    }
}