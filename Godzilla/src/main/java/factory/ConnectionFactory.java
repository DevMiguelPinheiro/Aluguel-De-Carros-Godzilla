/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author migue
 */
public class ConnectionFactory {
    private  static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    

    public ConnectionFactory() {
    }
    //conectar
     public static boolean conectar(){
    
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");//indica driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod","root", "1234");
            return true;
        }  catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     // desconectar
    public void dc(){
    try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
     
     
    
    
    
}
