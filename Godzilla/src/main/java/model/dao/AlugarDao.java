/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;
import java.sql.SQLException;
import factory.ConnectionFactory;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.entities.Aluguel;
import model.entities.Retorno;

/**
 *
 * @author migue
 */
public class AlugarDao extends Aluguel {

    private Connection con;
    private PreparedStatement ps;
    private PreparedStatement ps2;
    private ResultSet rs;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public AlugarDao() {
        con = connectionFactory.getConnection();
    }

    public void alugarCarro(Aluguel aluguel, int id_cliente, String placa) {

        PreparedStatement pstm2 = null;
        try {
            String sql = "INSERT INTO aluguel2(id_do_cliente, placa_do_carro, data_aluguel, data_retorno, taxa) VALUES(?, ?, ?, ?, ?)";
            String sql2 = "UPDATE carros SET status = ?"
                    + "WHERE placa = ?";
            //cria uma PreparedStatement para executar uma query
            ps = (PreparedStatement) con.prepareStatement(sql);
            pstm2 = con.prepareStatement(sql2);

            pstm2.setString(1, "ALUGADO");
            pstm2.setString(2, aluguel.getPlacaCarro());

            ps.setInt(1, id_cliente);
            ps.setString(2, placa);
            ps.setString(3, aluguel.getDataAluguel().toString());
            ps.setString(4, aluguel.getDataRetorno().toString());
            ps.setDouble(5, aluguel.getTaxaAluguel());

            //Executa query
            ps.execute();
            pstm2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public List<Aluguel> getAlugueis() {

        String sql = "SELECT * FROM alugueis";

        List<Aluguel> listaAluguel = new ArrayList<Aluguel>();

        try {

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Aluguel aluguel = new Aluguel();

                //Recuperar id aluguel
                aluguel.setId_aluguel(rs.getInt("id"));
                //Recuperar id cliente
                aluguel.setIdCliente(rs.getInt("id_cliente"));
                //Recuperar placa
                aluguel.setPlacaCarro(rs.getString("placa_carro"));
                //Recuperar nome
                aluguel.setNomeCliente(rs.getString("nome"));
                //Recuperar da
                aluguel.setDataAluguel(LocalDate.parse(rs.getString("data_aluguel")));
                //Recuperar dr
                aluguel.setDataRetorno(LocalDate.parse(rs.getString("data_retorno")));
                //Recuperar taxa
                aluguel.setTaxaAluguel(rs.getDouble("taxa"));

                listaAluguel.add(aluguel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaAluguel;
    }

    public boolean retornarCarro(Retorno rent) {

        try {
            String sql = "INSERT INTO retorno(id_aluguel, placa, nome, data_retorno, atraso,multaConta) VALUES(?, ?, ?, ?, ?, ?)";
            String sql2 = "UPDATE carros SET status = ?"
                    + "WHERE placa = ?";
            //cria uma PreparedStatement para executar uma query
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps2 = con.prepareStatement(sql2);
            
           
            ps2.setString(1, "DISPONIVEL");
            ps2.setString(2, rent.getPlaca());
            
           
            ps.setInt(1, rent.getId_aluguel());
            ps.setString(2, rent.getPlaca());
            ps.setString(3,rent.getNome());
            ps.setString(4, rent.getData_retorno().toString());
            ps.setLong(5, rent.getAtraso());
            ps.setDouble(6, rent.getMultaConta());

            //Executa query
            ps.execute();
            ps2.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public List<Retorno> getRetornos() {

        String sql = "SELECT * FROM listas.retorno";

        List<Retorno> listaRetorno = new ArrayList<Retorno>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco. ***SELECT****
        ResultSet rset = null;

        try {

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {

                Retorno retorno = new Retorno();

                //Recuperar id retorno
                retorno.setId_retorno(rs.getInt("id"));
                //Recuperar id aluguel
                retorno.setId_aluguel(rs.getInt("id_aluguel"));
                //Recuperar placa
                retorno.setPlaca(rs.getString("placa"));
                //Recuperar nome
                retorno.setNome(rs.getString("nome"));
                //Recuperar dr
                retorno.setData_retorno(LocalDate.parse(rs.getString("data_retorno")));
                //Recuperar atraso
                retorno.setAtraso(rs.getLong("atraso"));
                //Recuperar multaConta
                retorno.setMultaConta(rs.getDouble("multaConta"));

                listaRetorno.add(retorno);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaRetorno;
    }

    public void gerarRelatorioPDF(List<Aluguel> alugueis) {
        Document document = new Document();

        try {
            // Obter o diretório padrão de downloads do sistema
            String diretorioDownloads = System.getProperty("user.home") + File.separator + "Downloads";

            // Nome do arquivo PDF a ser gerado
            String arquivoPDF = diretorioDownloads + File.separator + "relatorio.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));

            document.open();

            // Título do relatório
            document.add(new Paragraph("Relatório de Aluguéis"));

            // Informações dos aluguéis
            for (Aluguel aluguel : alugueis) {
                document.add(new Paragraph("ID do Aluguel: " + aluguel.getId_aluguel()));
                document.add(new Paragraph("ID do Cliente: " + aluguel.getIdCliente()));
                document.add(new Paragraph("Placa do Carro: " + aluguel.getPlacaCarro()));
                document.add(new Paragraph("Nome do Cliente: " + aluguel.getNomeCliente()));
                document.add(new Paragraph("Data de Aluguel: " + aluguel.getDataAluguel().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                document.add(new Paragraph("Data de Retorno: " + aluguel.getDataRetorno().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                document.add(new Paragraph("Taxa de Aluguel: " + aluguel.getTaxaAluguel()));
                document.add(new Paragraph("\n"));
            }

            document.close();

            System.out.println("Relatório gerado com sucesso no arquivo " + arquivoPDF);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void gerarNota(String textField1Value, String textField2Value, String textField3Value, String textField4Value) {
        Document document = new Document();

        try {
            // Obter o diretório padrão de downloads do sistema
            String diretorioDownloads = System.getProperty("user.home") + File.separator + "Downloads";

            // Nome do arquivo PDF a ser gerado
            String arquivoPDF = diretorioDownloads + File.separator + "relatorio.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));

            document.open();

            // Adicionar os valores dos campos de texto ao documento PDF
            document.add(new Paragraph("Locadora Godzilla - Contrato de Aluguel de Carro\n"
                    + "\n"
                    + "Este documento representa o contrato de aluguel de carro entre a Locadora Godzilla e o cliente abaixo mencionado. Leia atentamente todas as cláusulas antes de assinar."));

            document.add(new Paragraph("Placa do Carro Alugado: " + textField1Value));
            document.add(new Paragraph("ID do Cliente: " + textField2Value));
            document.add(new Paragraph("Data de Retorno do Automóvel: " + textField3Value));
            document.add(new Paragraph("Nome do Cliente: " + textField4Value));
            document.add(new Paragraph(""));
            document.add(new Paragraph("1.O cliente se compromete a utilizar o veículo alugado apenas para fins legais e de acordo com as leis de trânsito vigentes."));
            document.add(new Paragraph("2.O cliente é responsável por quaisquer danos causados ao veículo durante o período de locação."));
            document.add(new Paragraph("3.A locação é válida até a data de retorno mencionada acima. Qualquer atraso na devolução estará sujeito a cobranças adicionais."));
            document.add(new Paragraph("4.A taxa de aluguel será calculada com base no valor total do aluguel, acrescida de 10%."));
            document.add(new Paragraph("5.O cliente concorda em devolver o veículo com o tanque de combustível na mesma quantidade em que foi fornecido no início da locação."));
            document.add(new Paragraph("6.A locadora não se responsabiliza por quaisquer objetos pessoais deixados no veículo após a devolução."));
            document.add(new Paragraph("7.Em caso de acidentes, o cliente deve informar imediatamente a locadora e seguir as instruções fornecidas."));
            document.add(new Paragraph("Eu," + textField4Value + ", concordo com todos os termos e condições mencionados acima. Declaro ter recebido o veículo com a placa" + textField1Value + "e me comprometo a devolvê-lo até a data de retorno mencionada."));
            //pega data atual

            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataAtualFormatada = dataAtual.format(formatoData);

            document.add(new Paragraph("Assinatura do Cliente: _______________________ Data: " + dataAtualFormatada + ""));
            document.add(new Paragraph("Assinatura da Locadora: ______________________ Data: ______________"));

            document.close();

            System.out.println("PDF gerado com sucesso no arquivo " + arquivoPDF);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void gerarNotaRetorno(String placa, String idCliente, String dataRetorno, String nomeCliente) {
    Document document = new Document();

    try {
        // Obter o diretório padrão de downloads do sistema
        String diretorioDownloads = System.getProperty("user.home") + File.separator + "Downloads";

        // Nome do arquivo PDF a ser gerado
        String arquivoPDF = diretorioDownloads + File.separator + "relatorio_retorno.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(arquivoPDF));

        document.open();

        // Adicionar os valores dos campos de texto ao documento PDF
        document.add(new Paragraph("Locadora Godzilla - Retorno de Carro\n"
                + "\n"
                + "Este documento representa o retorno do carro alugado pelo cliente abaixo mencionado. Confira os detalhes do retorno:"));

        document.add(new Paragraph("Placa do Carro: " + placa));
        document.add(new Paragraph("ID do Cliente: " + idCliente));
        document.add(new Paragraph("Data de Retorno: " + dataRetorno));
        document.add(new Paragraph("Nome do Cliente: " + nomeCliente));
        document.add(new Paragraph(""));
        document.add(new Paragraph("Agradecemos por utilizar nossos serviços. Por favor, verifique e assine abaixo confirmando o retorno do veículo alugado."));

        // Pega data atual
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualFormatada = dataAtual.format(formatoData);

        document.add(new Paragraph("Assinatura do Cliente: _______________________ Data: " + dataAtualFormatada + ""));
        document.add(new Paragraph("Assinatura da Locadora: ______________________ Data: ______________"));

        document.close();

        System.out.println("PDF gerado com sucesso no arquivo " + arquivoPDF);
    } catch (DocumentException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
