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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * data class object usado para acessar / interagir com o sql a partir de uma classe
 * @author migue
 */
public class CarrosDao {
    private Connection con;
    private PreparedStatement st;

    public CarrosDao() {
    }
    
    
    public boolean conectar(){
    
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");//indica driver
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod","root", "1234");
            return true;
        }  catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

    
    public boolean salvar(Carros carros) {
        
        try {
        String sql = "INSERT INTO carros (placa, marca, status, preco, Chassi) VALUES (?, ?, ?, ?, ?)";
        st = con.prepareStatement(sql);
        st.setString(1, carros.getPlaca());
        st.setString(2, carros.getMarca());
        st.setString(3, carros.getStatus());
        st.setDouble(4, carros.getPreco());
        st.setString(5, carros.getChassi());
        st.executeUpdate();
        return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            dc();
        }


    }
    
    public void dc(){
    try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    }
    
    

