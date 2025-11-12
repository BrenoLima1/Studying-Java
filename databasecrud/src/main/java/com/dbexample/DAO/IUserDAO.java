/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.dbexample.DAO;

import java.util.List;

import com.dbexample.model.User;

/**
 *
 * @author Buddha
 */
public interface IUserDAO {
    public List<User> readAllUsers();
    public boolean create(User user);
    public User readUser(int id);
    public boolean updateUser(int id, User user);
    public boolean delete(int id);
    public boolean validateUser(String username, String password);
}
