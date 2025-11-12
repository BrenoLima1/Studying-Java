<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuários</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        table { width: 80%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { padding: 5px 10px; margin-right: 5px; text-decoration: none; border-radius: 3px; }
        .btn-edit { background-color: #007bff; color: white; }
        .btn-delete { background-color: #dc3545; color: white; }
    </style>
</head>
<body>

    <h1>📝 Lista de Usuários</h1>

    <p>
        <a href="novoUsuario.jsp" class="btn btn-edit">Adicionar Novo Usuário</a>
    </p>

    <c:choose>
        <c:when test="${not empty usuarios}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Login (Username)</th>
                        <th>E-mail</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Itera sobre a lista de usuários ('usuarios') --%>
                    <c:forEach var="user" items="${usuarios}">
                        <tr>
                            <td><c:out value="${user.id}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.username}"/></td> <%-- Mapeado da coluna 'login' no DAO --%>
                            <td><c:out value="${user.email}"/></td>
                            <td>
                                <a href="editar?id=<c:out value='${user.id}'/>" class="btn btn-edit">Editar</a>
                                <a href="deletar?id=<c:out value='${user.id}'/>" class="btn btn-delete">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>

        <%-- Mensagem se a lista estiver vazia --%>
        <c:otherwise>
            <p>Nenhum usuário encontrado no banco de dados.</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
