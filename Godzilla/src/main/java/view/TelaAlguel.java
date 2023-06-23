package view;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import controller.JcomboBoxController;
import factory.ConnectionFactory;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.dao.AlugarDao;
import model.dao.Procura_no_banco;
import model.entities.Aluguel;
import model.entities.Carros;
import model.entities.Cliente;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author js33n
 */
public class TelaAlguel extends javax.swing.JFrame {

    /**
     * Creates new form TelaAlguel
     */
    private DefaultListModel<String> carrosModel;
    private Connection con;
    private Statement st;
    private ResultSetMetaData metaData;
    private ResultSet rs;

    public TelaAlguel() {
        initComponents();
        carrosModel = new DefaultListModel<>();
        Aluguel aluguel = new Aluguel();
        exibirCarros();
        preencherListaClientes(listaClientes);
    
        tabelacarros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabelacarros.getSelectedRow();
                    if (selectedRow != -1) {
                        String placa = tabelacarros.getValueAt(selectedRow, 0).toString();
                        tfCarro.setText(placa);
                    }
                }    
           }
            });
        listaClientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = listaClientes.getSelectedIndex();
                    if (selectedIndex != -1) {
                        String selectedValue = listaClientes.getSelectedValue();
                        String[] parts = selectedValue.split(" - ");
                        String id = parts[0];
                        String nome = parts[1];
                        tfIdCliente.setText(id);
                        tfNome.setText(nome);
                    }
                }    
           }
    });
        lblmenu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            voltarTelaPrincipal();
        }
        });
        tabelacarros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelacarros.getSelectedRow();
            if (selectedRow != -1) {
                String imagePath = tabelacarros.getValueAt(selectedRow, 5).toString(); // Substitua columnIndex pelo índice da coluna que contém o caminho da imagem
                exibirImagem(imagePath);
            }
        }
    }
});
        
}
       
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        alugar = new javax.swing.JButton();
        retorno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfdataRetorno = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelacarros = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList<>();
        tfIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfCarro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CLIENTE = new javax.swing.JLabel();
        lblmenu = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        jLabel1.setText("Aluguel");

        alugar.setText("Alugar");
        alugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alugarActionPerformed(evt);
            }
        });

        retorno.setText("Retorno");
        retorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornoActionPerformed(evt);
            }
        });

        jLabel3.setText(" DATA DE RETORNO:(DD/MM/YYYY)");

        tfdataRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdataRetornoActionPerformed(evt);
            }
        });

        tabelacarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelacarros);

        listaClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaClientes);

        jLabel2.setText("ID DO CLIENTE");

        jLabel4.setText("CLIENTES");

        jLabel5.setText("CARROS");

        jLabel6.setText("PLACA DO CARRO");

        jLabel7.setText("  ");

        CLIENTE.setText("CLIENTE");

        lblmenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblmenu.setText("<");
        lblmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdCliente)
                                    .addComponent(tfdataRetorno)
                                    .addComponent(tfCarro)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(CLIENTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(tfNome)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(alugar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(retorno))
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblmenu)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)
                        .addGap(33, 427, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(tfCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CLIENTE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retorno)
                    .addComponent(alugar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alugarActionPerformed
    AlugarDao dao = new AlugarDao();
    Carros carro = new Carros();
    Cliente cliente = new Cliente();
    Procura_no_banco procura = new Procura_no_banco();
    String placa = tfCarro.getText();
    String idCliente = tfIdCliente.getText();
    String dataRetorno = tfdataRetorno.getText();
    int idClienteInt = Integer.parseInt(idCliente);
    
    String ncliente = tfNome.getText();

    if (placa.isEmpty() || idCliente.isEmpty() || dataRetorno.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        LocalDate dataAluguel = LocalDate.now();
        LocalDate dataRetornoFormatted = LocalDate.parse(dataRetorno, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataRetornoFormatted.isBefore(dataAluguel)) {
            JOptionPane.showMessageDialog(this, "Data de retorno inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setPlacaCarro(placa);
        aluguel.setDataAluguel(dataAluguel);
        aluguel.setDataRetorno(dataRetornoFormatted);
        aluguel.setTaxaAluguel(0.0); // Defina a taxa de aluguel correta aqui

        dao.alugarCarro(aluguel, idClienteInt, placa);

        // Limpar campos
        tfCarro.setText("");
        tfIdCliente.setText("");
        tfNome.setText("");
        tfdataRetorno.setText("");

        JOptionPane.showMessageDialog(this, "Carro alugado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Gerar o PDF com os dados do aluguel
        dao.gerarNota(placa, idCliente, dataRetorno,ncliente);

        // Informar que o PDF foi gerado
        JOptionPane.showMessageDialog(this, "Relatório PDF gerado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            dao.atualizarTabela((DefaultTableModel) tabelacarros.getModel());
            tabelacarros.revalidate();
            tabelacarros.repaint();
    } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Formato de data inválido! Use o formato: dd/MM/yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
    }   catch (SQLException ex) {
            Logger.getLogger(TelaAlguel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alugarActionPerformed

    private void retornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornoActionPerformed
 
    }//GEN-LAST:event_retornoActionPerformed

    private void tfdataRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdataRetornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdataRetornoActionPerformed

    private void lblmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmenuMouseClicked

    }//GEN-LAST:event_lblmenuMouseClicked
    

    private Cliente getSelectedCliente() {
    String selectedValue = listaClientes.getSelectedValue();
    if (selectedValue != null) {
        String[] parts = selectedValue.split(" - ");
        int id = Integer.parseInt(parts[0]);
        String nome = parts[1];
        return new Cliente(id, nome);
    }
    return null;
}
    
    private Carros getSelectedCarro() {
    int selectedRow = tabelacarros.getSelectedRow();
    if (selectedRow != -1) {
        String placa = tabelacarros.getValueAt(selectedRow, 0).toString();
        // Você precisará obter as informações adicionais do carro do banco de dados ou de algum outro local
        // Aqui, estou apenas retornando um objeto Carros com a placa definida
        return new Carros(placa);
    }
    return null;
}
    
    public void exibirCarros() {
        try {
            con = ConnectionFactory.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM carros WHERE status = 'DISPONIVEL'");
            tabelacarros.setModel(resultSetToTableModel(rs));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    // Método para preencher a JList com os clientes cadastrados
    public void preencherListaClientes(JList<String> listaClientes) {
    DefaultListModel<String> model = new DefaultListModel<>();

    // Estabelecer a conexão com o banco de dados usando a ConnectionFactory
    try {
        con = ConnectionFactory.getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT id, nome FROM clientes");
        ResultSet resultSet = statement.executeQuery();

        // Adicionar os clientes na lista
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            model.addElement(id + " - " + nome);
        }

        // Fechar os recursos
        resultSet.close();
        statement.close();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Definir o modelo da JList
    listaClientes.setModel(model);
}

    public DefaultTableModel resultSetToTableModel(ResultSet rs) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();
    int columnCount = metaData.getColumnCount();

    // Obter os nomes das colunas
    String[] columnNames = new String[columnCount];
    for (int column = 1; column <= columnCount; column++) {
        columnNames[column - 1] = metaData.getColumnName(column);
    }

    // Criar o modelo de tabela vazio
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    // Preencher o modelo de tabela com os dados do ResultSet
    while (rs.next()) {
        Object[] rowData = new Object[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            rowData[column - 1] = rs.getObject(column);
        }
        model.addRow(rowData);
    }

    return model;
}
    private void exibirImagem(String imagePath) {
    // Carregue a imagem do caminho especificado e atribua-a ao JLabel lblfoto
    // Por exemplo:
     
    ImageIcon imageIcon = new ImageIcon(imagePath);
    Image img = imageIcon.getImage().getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
    ImageIcon imagemRedimensionada = new ImageIcon(img);
    lblfoto.setIcon(imagemRedimensionada);
}
    public String getTextFieldIdCliente() {
    return tfIdCliente.getText();
}
    private void voltarTelaPrincipal() {
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
    this.dispose(); // Fecha a janela atual
}
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        try {
    UIManager.setLookAndFeel( new FlatDarkPurpleIJTheme());
    } catch( Exception ex ) {
    System.err.println( "Failed to initialize LaF" );
}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlguel().setVisible(true);
            }
        });
    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CLIENTE;
    private javax.swing.JButton alugar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblfotoaluguel;
    private javax.swing.JLabel lblfotoaluguel1;
    private javax.swing.JLabel lblmenu;
    private javax.swing.JList<String> listaClientes;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JButton retorno;
    private javax.swing.JTable tabelacarros;
    private javax.swing.JTextField tfCarro;
    private javax.swing.JTextField tfIdCliente;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfdataRetorno;
    // End of variables declaration//GEN-END:variables
}
