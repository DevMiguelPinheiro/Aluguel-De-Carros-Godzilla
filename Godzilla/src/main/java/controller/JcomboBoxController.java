/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author migue
 */
public class JcomboBoxController {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public JcomboBoxController() {
        con = connectionFactory.getConnection();
    }
    
    
    
    public void loadClientes(JComboBox<String> comboBoxClientes) {
    try {
        String sql = "SELECT nome FROM clientes";
        ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        comboBoxClientes.removeAllItems(); // Limpa os itens existentes no JComboBox

        while (rs.next()) {
            String nomeCliente = rs.getString("nome");
            comboBoxClientes.addItem(nomeCliente); // Adiciona o nome do cliente ao JComboBox
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
}
