/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Statement;


/**
 *
 * @author migue
 */
public class ClienteDao {
    Connection con;
    Statement st;
        
    public boolean conectar(){
    
        try { 
            Class.forName("com.mysql.jdbc.Driver");//indica driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root", "1234");
            st = con.createStatement();
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
    
}

