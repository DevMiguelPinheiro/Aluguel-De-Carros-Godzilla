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
    
     // desconectar
    public static void closeConnection(){
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
    // conectar sem booleano
    public static Connection getConnection() {
       
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");//indica driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod","root", "1234");
            return con;
        }  catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;            
        }
        
    }
    
        public static boolean getConnectionb(){
    
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");//indica driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod","root", "1234");
            return true;
        }  catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
        
    
     
    
    
    

