/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Usuarios;

/**
 *
 * @author migue
 */
public class UsuariosDao extends Usuarios{
    public boolean autenticar(String username, String password) {
    // Configurações de conexão com o banco de dados
    String url = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
    String user = "usuario";
    String pass = "senha";

    // Consulta SQL para verificar a autenticação do usuário
    String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

    try (Connection connection = DriverManager.getConnection(url, user, pass);
         PreparedStatement statement = connection.prepareStatement(query)) {

        // Define os parâmetros da consulta
        statement.setString(1, username);
        statement.setString(2, password);

        // Executa a consulta
        ResultSet resultSet = statement.executeQuery();

        // Verifica se o usuário foi encontrado no banco de dados
        return resultSet.next();

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}




}
