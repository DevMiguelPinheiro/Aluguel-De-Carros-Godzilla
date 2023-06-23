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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 */
public class TabelaCarrosController {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public TabelaCarrosController() {
        con = connectionFactory.getConnection();
    }
    
    

    public void atualizarTabela(DefaultTableModel model) throws SQLException {
        String query = "SELECT * FROM carros";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            model.setRowCount(0); // Limpar os dados existentes na tabela

            while (rs.next()) {
                Object[] rowData = new Object[5]; // Adicionei mais um elemento para o array

                // Preencher o array rowData com os dados do ResultSet
                rowData[0] = rs.getString("placa");
                rowData[1] = rs.getString("marca");
                rowData[2] = rs.getString("modelo");
                rowData[3] = rs.getString("status");
                rowData[4] = rs.getDouble("preco");

                model.addRow(rowData);
            }

            rs.close();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }
}
