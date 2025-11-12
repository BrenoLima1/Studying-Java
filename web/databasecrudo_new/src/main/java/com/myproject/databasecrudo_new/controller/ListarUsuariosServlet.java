package com.myproject.databasecrudo_new.controller;

import java.io.IOException;
import java.util.List;

import com.myproject.databasecrudo_new.dao.UserDAO;
import com.myproject.databasecrudo_new.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Define a URL de acesso ao Servlet: http://localhost:8080/databasecrudo_new/listar
@WebServlet("/listar")
public class ListarUsuariosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Chama o DAO para obter a lista de usuários do banco de dados
            List<User> listaUsuarios = userDAO.listarTodos();

            // 2. Armazena a lista de usuários no escopo da requisição
            // O nome do atributo (por exemplo, "usuarios") será usado no JSP
            request.setAttribute("usuarios", listaUsuarios);

            // 3. Encaminha (Forward) a requisição e a resposta para a página JSP
            // A requisição será processada pelo JSP no lado do servidor
            request.getRequestDispatcher("listaUsuarios.jsp").forward(request, response);

        } catch (ServletException | IOException e) {
            // Em caso de erro (ex: falha de conexão), mostra a exceção e retorna um erro 500
            System.err.println("Erro ao listar usuários no Servlet: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro interno ao processar a lista de usuários.");
        }
    }

    // Implementação básica para post (pode ser ignorada para listar)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
