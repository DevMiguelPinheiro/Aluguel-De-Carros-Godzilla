/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import data.Carros; 
import data.Carros;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 * data class object usado para acessar / interagir com o sql a partir de uma classe
 * @author migue
 */
public class CarrosDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    

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
        ps = con.prepareStatement(sql);
        ps.setString(1, carros.getPlaca());
        ps.setString(2, carros.getMarca());
        ps.setString(3, carros.getStatus());
        ps.setDouble(4, carros.getPreco());
        ps.setString(5, carros.getChassi());
        ps.executeUpdate();
        return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    public void atualizarTabela(DefaultTableModel model) throws SQLException {
         String query = "SELECT * FROM carros";
    try {
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();

        model.setRowCount(0); // Limpar os dados existentes na tabela

        while (rs.next()) {
            Object[] rowData = new Object[6]; // Adicionei mais um elemento para o array

            // Preencher o array rowData com os dados do ResultSet
            rowData[0] = rs.getString("placa");
            rowData[1] = rs.getString("marca");
            rowData[2] = rs.getString("status");
            rowData[3] = rs.getDouble("preco");
            rowData[4] = rs.getString("chassi");
            rowData[5] = rs.getString("img");

            model.addRow(rowData);
        }

        rs.close();
    } finally {
        if (ps != null) {
            ps.close();
        }
    }
        
    }   

    public boolean excluirCarro(String placa) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod", "root", "1234");
            String query = "DELETE FROM carros WHERE PLACA = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, placa);
            int rowsAffected = ps.executeUpdate();
            ps.close();
            con.close();
            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (excluída)
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
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
    
    

