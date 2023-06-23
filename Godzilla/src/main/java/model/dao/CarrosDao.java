/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import factory.ConnectionFactory;
import java.awt.Image;
import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import model.entities.Carros;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * data class object usado para acessar / interagir com o sql a partir de uma
 * classe
 *
 * @author migue
 */
public class CarrosDao extends Carros {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public CarrosDao() {
        con = connectionFactory.getConnection();
    }

    public List<Carros> getCarros() {

        String sql = "SELECT * FROM sistemagod.carros";

        List<Carros> carros = new ArrayList<Carros>();

        try {
            con = ConnectionFactory.getConnection();

            ps = (PreparedStatement) con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Carros carro = new Carros();

                //Recuperar placa
                carro.setPlaca(rs.getString("placa"));;
                //Recuperar marca
                carro.setMarca(rs.getString("marca"));
                //Recuperar modelo
                carro.setModelo(rs.getString("modelo"));
                //Recuperar status do carro
                carro.setStatus(rs.getString("status_carro"));
                //Recuperar preco
                carro.setPreco(rs.getDouble("preco"));

                carros.add(carro);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carros;
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

    public boolean editarCarro(String placaAntiga, String novaPlaca, String novaMarca, String novoModelo, double novoValor, String novoStatus) {
        try {
            String query = "UPDATE carros SET placa = ?, marca = ?, modelo = ?, status = ?, preco = ? WHERE placa = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, novaPlaca);
            ps.setString(2, novaMarca);
            ps.setString(3, novoModelo);
            ps.setString(4, novoStatus);
            ps.setDouble(5, novoValor);
            ps.setString(6, placaAntiga);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (atualizada)
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
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

    public String getStatus(String placa) throws SQLException {
        String status = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT status FROM carros WHERE placa = ?";
            statement = con.prepareStatement(query);
            statement.setString(1, placa);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                status = resultSet.getString("status");
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return status;
    }

    public boolean editarStatusCarro(String placa, String novoStatus) {
        try {
            String query = "UPDATE carros SET status = ? WHERE placa = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, novoStatus);
            ps.setString(2, placa);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void selecionarImagem(JLabel lblfoto, JTextField tfimg) {
    JFileChooser arquivo = new JFileChooser();
    arquivo.setDialogTitle("Selecione uma imagem");
    arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
    arquivo.setFileFilter(filter);

    int op = arquivo.showOpenDialog(null);
    if (op == JFileChooser.APPROVE_OPTION) {
        File file = arquivo.getSelectedFile();
        String caminho = file.getAbsolutePath();
        
        // Armazena o caminho da imagem no JTextField tfimg
        tfimg.setText(caminho);

        ImageIcon imagem = new ImageIcon(file.getPath());
        Image img = imagem.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon imagemRedimensionada = new ImageIcon(img);
        lblfoto.setIcon(imagemRedimensionada);
    }
}

}
