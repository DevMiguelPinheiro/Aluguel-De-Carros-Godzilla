/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;


import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Cliente;
/**
 * data class object usado para acessar / interagir com o sql a partir de uma classe
 * @author migue
 */
public class ClientesDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();
    

    public ClientesDao() {
      con = connectionFactory.getConnection();
    }
        

    public boolean salvar(Cliente clientes) {
    try {
        String sql = "INSERT INTO clientes (id, nome, endereco, telefone) VALUES (null, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, clientes.getNome());
        ps.setString(2, clientes.getEndereco());
        ps.setString(3, clientes.getTelefone());
        
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
        } 
    }

    
    public void atualizarTabela(DefaultTableModel model) throws SQLException {
         String query = "SELECT * FROM clientes";
    try {
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();

        model.setRowCount(0); // Limpar os dados existentes na tabela

        while (rs.next()) {
            Object[] rowData = new Object[6]; // Adicionei mais um elemento para o array

            // Preencher o array rowData com os dados do ResultSet
            rowData[0] = rs.getString("id");
            rowData[1] = rs.getString("nome");
            rowData[2] = rs.getString("endereco");
            rowData[3] = rs.getString("telefone");
            model.addRow(rowData);
        }

        rs.close();
    } finally {
        if (ps != null) {
            ps.close();
            }
        }
        
    }
    
    public boolean editarCliente(String idAntigo, String novoNome, String novoEndereco, String novoTelefone) {
    try {
        String query = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ? WHERE id = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, novoNome);
        ps.setString(2, novoEndereco);
        ps.setString(3, novoTelefone);
        ps.setString(4, idAntigo);

        int rowsAffected = ps.executeUpdate();
        ps.close();

        return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (atualizada)
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}


    public boolean excluirCliente(String placa) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod", "root", "1234");
            String query = "DELETE FROM clientes WHERE ID = ?";
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
      
    }
