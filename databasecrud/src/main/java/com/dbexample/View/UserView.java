/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dbexample.View;

import java.util.List;
import java.util.Scanner;

import com.dbexample.model.User;

/**
 *
 * @author Breno
 */
public class UserView {

    public final Scanner scanner = new Scanner(System.in);

    public int readUserID() {
        System.out.print("Enter the user id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public int readMenuOption() {
        System.out.println("1 - List all users");
        System.out.println("2 - New user");
        System.out.println("3 - Update user");
        System.out.println("4 - Delete user");
        System.out.println("5 - Search user by id");
        System.out.println("6 - Login");
        System.out.println("0 - Exit");

        System.out.print("Option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consome o ENTER
        return option; // devolve a escolha para o Main/Controller
    }

    public void printAllUsers(List<User> users) {
        for (User user : users) {
            System.out.println("\n" + user + "\n");
        }
    }

    public User readUser() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return new User(0, name, username, email, password);

    }

    public void printUser(User user) {
        System.out.println(user);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void closeScanner() {
        scanner.close();
    }

    public String readUsername() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        return username;
    }

    public String readPassword() {
        System.out.print("Password: ");
        String password = scanner.nextLine();
        return password;
    }

}
