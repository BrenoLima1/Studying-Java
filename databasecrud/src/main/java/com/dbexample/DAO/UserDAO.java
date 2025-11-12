/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dbexample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dbexample.config.Connect;
import com.dbexample.model.User;

/**
 *
 * @author Breno
 */
public class UserDAO implements IUserDAO {

  @Override
public boolean create(User user) {
    String sql = "INSERT INTO user (name, login, email, password) VALUES (?, ?, ?, ?)";
    try (Connection conn = Connect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());

        int rows = stmt.executeUpdate();
        return rows > 0;

    } catch (SQLException e) {
        System.err.println("Insertion error: " + e.getMessage());
        return false;
    }
}

  @Override
public User readUser(int id) {
    String sql = "SELECT * FROM user WHERE iduser = ?";
    try ( Connection conn = Connect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        User user = null;
        try (var rs = stmt.executeQuery()) {
            if (rs.next()) {
                int iduser = rs.getInt("iduser");
                String userName = rs.getString("name");
                String userUsername = rs.getString("login");
                String userEmail = rs.getString("email");
                String userPassword = rs.getString("password");
                user = new User(iduser, userName, userUsername, userEmail, userPassword);
            }
        }
        return user;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
  }

  @Override
  public boolean updateUser(int id, User user) {
    String sql = "UPDATE user SET name = ?, login = ?, email = ?, password = ? WHERE iduser = ?";
    try (Connection conn = Connect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setInt(5, id);

        int rows = stmt.executeUpdate();
        return rows > 0;

    } catch (SQLException e) {
        System.err.println("Update error: " + e.getMessage());
        throw new RuntimeException(e);
    }
  }

}
