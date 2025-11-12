/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dbexample.controller;

import java.util.List;

import com.dbexample.DAO.UserDAO;
import com.dbexample.model.User;

/**
 *
 * @author Breno
 */
public class UserController {

    private final UserDAO userDAO = new UserDAO();

    public boolean createUser(User user) {
        return userDAO.create(user);
    }

    public User readUser(int id) {
        return userDAO.readUser(id);
    }

    public boolean updateUser(int id, User user) {
        return userDAO.updateUser(id, user);
    }

    public boolean deleteUser(int id) {
        return userDAO.delete(id);
    }

    public List<User> readAllUsers() {
        return userDAO.readAllUsers();
    }

    public boolean validateUser(String username, String password) {
        return userDAO.validateUser(username, password);
    }
}
