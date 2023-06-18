/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Date;
import java.sql.SQLException;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entities.Alugar;
import model.entities.Carros;

/**
 *
 * @author migue
 */
public class AlugueisRetornoDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public AlugueisRetornoDao() {
        con = connectionFactory.getConnection();
    }
    
    public boolean inserirAluguel(Alugar aluguel) {
        try {            
            // Consultar o nome do cliente pelo ID
            String nome = retorna_nome_pelo_Id(aluguel.getIdCliente());
            // taxa
            
            
            // Obter a data atual do sistema
            LocalDate dataAluguel = LocalDate.now();
         
            
            String sql = "INSERT INTO aluguel (id_carro, id_cliente, nome_cliente, data_aluguel, data_retorno, taxa_aluguel) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, aluguel.getPlacaCarro());
            st.setInt(2, aluguel.getIdCliente());
            st.setString(3, nome);
            st.setDate(4, java.sql.Date.valueOf(dataAluguel)); 
            st.setDate(5, java.sql.Date.valueOf(aluguel.getDataRetorno()));
            st.setDouble(6, aluguel.getTaxaAluguel());           
            st.executeUpdate();           
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String retorna_nome_pelo_Id(int id) {
    String nome = "";

    try {
        // Cria conexão com o banco de dados
        con = ConnectionFactory.getConnection();

        // Prepara a query para buscar o nome do cliente pelo ID
        String sql = "SELECT nome FROM clientes WHERE id_cliente = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        // Executa a query
        rs = ps.executeQuery();

        // Verifica se encontrou um resultado
        if (rs.next()) {
            nome = rs.getString("nome");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nome;
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
    
    public boolean retorno(String placa) {
    try {
        String sql1 = "UPDATE aluguel SET retorno = ?, WHERE placa = ?";
        ps = con.prepareStatement(sql1);
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ps.setString(2, placa);
        ps.executeUpdate();

        String sql2 = "UPDATE carros SET status = 'DISPONIVEL' WHERE placa = ?";
        ps = con.prepareStatement(sql2);
        ps.setString(1, placa);
        ps.executeUpdate();

        return true;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
    
}
    

    
}