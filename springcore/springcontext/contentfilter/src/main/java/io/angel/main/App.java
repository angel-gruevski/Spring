package io.angel.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.angel.config.ProjectConfig;
import io.angel.models.Author;
import io.angel.models.Post;
import io.angel.models.Session;
import io.angel.models.User;
import io.angel.services.LoginService;
import io.angel.services.PostService;
import io.angel.services.RegisterUserService;

public class App {
    
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Choose an option: ");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");

            int choiceOne = scanner.nextInt();

            switch(choiceOne) {
                case 1:
                    registerUser(context);
                    break;
                case 2:
                    login(context);
                    break;
                case 3:
                    System.out.println("Exiting program");
                    scanner.close();
                    return;
            }
        }
    }

    static void registerUser(ApplicationContext context) {
        RegisterUserService registerUser = context.getBean(RegisterUserService.class);
        registerUser.requestInformation();
    }

    static void login(ApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = context.getBean(LoginService.class);
        loginService.requestInformation();

        Session session = context.getBean(Session.class);
        if(session.getUserSession() != null) {
            User user = session.getUserSession();

            
            while(true) {
                if(user instanceof Author) {
                    System.out.println("1 - Get posts");
                    System.out.println("2 - Create post");
                    System.out.println("3 - Post a comment");
                    System.out.println("4 - Get post by ID");
                    System.out.println("5 - Delete post");
                    System.out.println("6 - Logoff");

                    int choice = scanner.nextInt();

                    switch(choice) {
                        case 1:
                            getPosts(context);
                            break;
                        case 2:
                            createPosts(context);
                            break;
                        case 3:
                            break;
                        case 4:
                            getPost(context);
                            break;
                        case 5:
                            deletePost(context);
                            break;
                        case 6:
                            logoff(context);
                            return;
                    }
                } else if(user instanceof User) {
                    System.out.println("1 - Get posts");
                    System.out.println("2 - Post a comment");
                    System.out.println("3 - Get post by ID");
                    System.out.println("4 - Log off");

                    int choice = scanner.nextInt();

                    switch(choice) {
                        case 1:
                            getPosts(context);
                            break;
                        case 2:
                            break;
                        case 3:
                            getPost(context);
                        case 4:
                            logoff(context);
                            return;
                    }
                }
            }
        }
    }

    static void deletePost(ApplicationContext context) {
        PostService postService = context.getBean(PostService.class);
        Scanner scanner = new Scanner(System.in);
        String postId = scanner.nextLine();
        postService.deletePost(postId);
    }

    static void logoff(ApplicationContext context) {
        Session session = context.getBean(Session.class);
        session.invalidateSession();
    }

    static void getPosts(ApplicationContext context) {
        PostService postService = context.getBean(PostService.class);
        List<Post> posts = postService.getPosts();

        for(Post p : posts) {
            System.out.println(p.getPostId() + " - " + p.getTitle());
        }
    }

    static void getPost(ApplicationContext context) {
        PostService postService = context.getBean(PostService.class);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter post ID: ");
        String postId = scanner.nextLine();

        Post post = postService.getPost(postId);
        if(post != null) { 
            System.out.println("Title: " + post.getTitle());
            System.out.println(post.getContent());

            System.out.println("\n Author: " + post.getAuthor());
        }
    }

    static void createPosts(ApplicationContext context) {
        Scanner scanner = new Scanner(System.in);
        Session session = context.getBean(Session.class);
        PostService postService = context.getBean(PostService.class);

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter text: ");
        String content = scanner.nextLine();

        Author author = (Author) session.getUserSession();
        if(author != null && author instanceof Author) {
            System.out.println(author);
        }

        Post post = new Post(author, title, content);
        postService.createPost(post);
       
    }
}