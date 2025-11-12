package com.myproject.databasecrudo_new.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.databasecrudo_new.model.User;
import com.myproject.databasecrudo_new.util.ConnectionFactory;

public class UserDAO {

    // AJUSTADO: Nomes das colunas da sua tabela: iduser, name, login, password, email
    private static final String SELECT_ALL_USERS = "SELECT iduser, name, login, email, password FROM user";

    /**
     * Busca e retorna todos os usuários do banco de dados.
     * @return Uma lista de objetos User.
     */
    public List<User> listarTodos() {
        List<User> users = new ArrayList<>();

        // try-with-resources
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // AJUSTADO: Mapeamento dos nomes das colunas para os atributos do objeto User
                User user = new User();
                user.setId(rs.getInt("iduser"));     // Coluna 'iduser'
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("login")); // Coluna 'login' mapeada para o atributo 'username'
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
            // Lançar RuntimeException ou logar aqui é uma boa prática
        }
        return users;
    }

}
