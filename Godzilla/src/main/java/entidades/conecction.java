/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author migue
 */
public class conecction {

    private static final String URL = "jdbc:mysql://localhost:3306/tutorial";
    private static final String USER = "root";
    private static final String PASS = "admin";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados: " + e);
        }
    }
}


