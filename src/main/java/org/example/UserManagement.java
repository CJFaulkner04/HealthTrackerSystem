package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> users;
    private static final String USER_FILE = "users.txt";

    public UserManagement() {
        users = new ArrayList<>();
        loadUsers();
    }

    public void createUser(String username) {
        if (isUserExists(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        User user = new User(username);
        users.add(user);
        saveUsers();

        System.out.println("User created successfully.");
    }

    public User loginUser(String username) {
        for (User user : users) {
            if (user.getUser().equals(username)) {
                System.out.println("Login successful.");
                return user;
            }
        }
        System.out.println("User not found.");
        return null;
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = new User(line);
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                writer.write(user.getUser());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    private boolean isUserExists(String username) {
        for (User user : users) {
            if (user.getUser().equals(username)) {
                return true;
            }
        }
        return false;
    }
}