package com.myproject.databasecrudo_new.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Configuração do Banco de Dados
    // Nome do banco: 'crud'
    private static final String URL = "jdbc:mysql://localhost:3306/crud?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root"; // <-- SUBSTITUA
    private static final String PASS = "";   // <-- SUBSTITUA

    /**
     * Retorna uma nova conexão com o banco de dados 'crud'.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Driver JDBC (para MySQL 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece e retorna a conexão
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado. Verifique as dependências do Maven.");
            throw new SQLException("Driver JDBC não encontrado.", e);
        }
    }

    /**
     * Fecha um objeto Connection (método auxiliar).
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
