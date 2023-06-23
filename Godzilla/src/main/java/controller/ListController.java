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
import javax.swing.DefaultListModel;

/**
 *
 * @author migue
 */
public class ListController {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public ListController() {
        con = connectionFactory.getConnection();
    }

    public void listarCarrosDisponiveis(DefaultListModel<String> model) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT modelo, placa, preco FROM carros WHERE status = ?");
            ps.setString(1, "DISPONIVEL");
            ResultSet rs = ps.executeQuery();

            model.clear(); // Limpa o modelo da JList

            while (rs.next()) {
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");
                double preco = rs.getDouble("preco");

                String item = modelo + " - Placa: " + placa + " - R$" + preco;
                model.addElement(item); // Adiciona o item ao modelo da JList
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarCarrosIndisponiveis(DefaultListModel<String> model) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT modelo, placa, preco FROM carros WHERE status = ?");
            ps.setString(1, "ALUGADO");

            ResultSet rs = ps.executeQuery();

            model.clear(); // Limpa o modelo da JList

            while (rs.next()) {
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");
                double preco = rs.getDouble("preco");

                String item = modelo + " - Placa: " + placa + " - R$" + preco;
                model.addElement(item); // Adiciona o item ao modelo da JList
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
