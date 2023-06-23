/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import controller.TabelaCarrosController;
import factory.ConnectionFactory;
import java.sql.ResultSetMetaData;
import model.entities.Carros;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import model.dao.CRUD;


/**
 *
 * @author migue
 */
public class gerenciarCarro extends javax.swing.JFrame {

    /**
     * Creates new form gerenciarCarro
     */
    public gerenciarCarro() {
        initComponents();
        exibirDados();
        JRootPane rootPane;
        rootPane = SwingUtilities.getRootPane(this);
        rootPane.setWindowDecorationStyle(JRootPane.FRAME);
        JLayeredPane layeredPane = rootPane.getLayeredPane();
        layeredPane.setBackground(Color.RED);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabelacarros.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = tabelacarros.getSelectedRow();
    if (selectedRow != -1) {
        PLACA.setText(tabelacarros.getValueAt(selectedRow, 0).toString());
        MARCA.setText(tabelacarros.getValueAt(selectedRow, 1).toString());
        MODELO.setText(tabelacarros.getValueAt(selectedRow, 2).toString());
        PRECO.setText(tabelacarros.getValueAt(selectedRow, 4).toString());

    }
}

});
        lblmenu.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            voltarTelaPrincipal();
        }
        });
    
    
    }
    
    

    private Connection con;
    private Statement st;
    private ResultSetMetaData metaData;
    private ResultSet rs;
    private String caminhoImagem = "";
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        GERENCIAR = new javax.swing.JLabel();
        MODELO = new javax.swing.JTextField();
        PLACA = new javax.swing.JTextField();
        MARCA = new javax.swing.JTextField();
        PRECO = new javax.swing.JTextField();
        ADICIONAR = new javax.swing.JButton();
        EXCLUIR = new javax.swing.JButton();
        EDITAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelacarros = new javax.swing.JTable();
        LIMPAR1 = new javax.swing.JButton();
        cbstatus = new javax.swing.JComboBox<>();
        SELECIONAR = new javax.swing.JButton();
        lblmenu = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        tfimg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aluguel de carros ");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                fechar(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fechar(evt);
            }
        });

        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        GERENCIAR.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        GERENCIAR.setText("Gerenciar Carros");

        MODELO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MODELOActionPerformed(evt);
            }
        });

        ADICIONAR.setText("ADICIONAR");
        ADICIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADICIONARActionPerformed(evt);
            }
        });

        EXCLUIR.setText("EXCLUIR");
        EXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXCLUIRActionPerformed(evt);
            }
        });

        EDITAR.setText("EDITAR");
        EDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITARActionPerformed(evt);
            }
        });

        jLabel1.setText("PLACA");

        jLabel2.setText("MARCA");

        jLabel3.setText("MODELO");

        jLabel4.setText("R$");

        jLabel5.setText("STATUS");

        tabelacarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "PLACA", "MARCA", "CHASSI", "VALOR", "STATUS"
            }
        ));
        tabelacarros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelacarrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelacarros);

        LIMPAR1.setText("LIMPAR CAMPOS");
        LIMPAR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LIMPAR1ActionPerformed(evt);
            }
        });

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIVEL", "ALUGADO" }));
        cbstatus.setMinimumSize(new java.awt.Dimension(100, 20));
        cbstatus.setPreferredSize(new java.awt.Dimension(100, 20));
        cbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbstatusActionPerformed(evt);
            }
        });

        SELECIONAR.setText("SELECIONAR IMAGEM");
        SELECIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SELECIONARActionPerformed(evt);
            }
        });

        lblmenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblmenu.setText("<");
        lblmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblmenuMouseClicked(evt);
            }
        });

        jLabel6.setText("CAMINHO DA IMAGEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PLACA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MARCA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MODELO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(ADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(EXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblmenu)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(GERENCIAR)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LIMPAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfimg))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SELECIONAR)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GERENCIAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PLACA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MARCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MODELO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SELECIONAR)
                    .addComponent(tfimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EXCLUIR)
                    .addComponent(ADICIONAR)
                    .addComponent(EDITAR)
                    .addComponent(LIMPAR1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbstatusActionPerformed

    private void LIMPAR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LIMPAR1ActionPerformed
        PLACA.setText("");
        PRECO.setText("");
        MODELO.setText("");
        MARCA.setText("");
        lblfoto.setText("");
    }//GEN-LAST:event_LIMPAR1ActionPerformed

    private void tabelacarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelacarrosMouseClicked

    }//GEN-LAST:event_tabelacarrosMouseClicked

    private void EXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXCLUIRActionPerformed
        CRUD dao;
        dao = new CRUD() {};
        int selectedRow = tabelacarros.getSelectedRow(); // Obtém a linha selecionada

        if (selectedRow != -1) { // Verifica se alguma linha foi selecionada
            String placa = tabelacarros.getValueAt(selectedRow, 0).toString(); // Obtém o valor da coluna "PLACA" da linha selecionada

            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o carro com a placa: " + placa + "?", "Excluir Carro", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) { // Confirmação do usuário
                try {
                    if (!ConnectionFactory.getConnectionb()) {
                        JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
                    } else {
                        if (dao.delete(placa)) { // Exclui o carro com a placa especificada
                            JOptionPane.showMessageDialog(null, "Carro excluído com sucesso!");
                            DefaultTableModel model = (DefaultTableModel) tabelacarros.getModel();
                            model.removeRow(selectedRow); // Remove a linha da tabela
                        } else {
                            JOptionPane.showMessageDialog(null, "Não foi possível excluir o carro");
                        }
                    }
                } catch (HeadlessException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao excluir o carro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um carro para excluir");
        }

    }//GEN-LAST:event_EXCLUIRActionPerformed

    private void ADICIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADICIONARActionPerformed
    Carros carros = new Carros();
    CRUD dao;
    TabelaCarrosController dao3;
    carros.setPlaca(PLACA.getText());
    carros.setMarca(MARCA.getText());
    carros.setModelo(MODELO.getText());
    carros.setPreco(Double.parseDouble(PRECO.getText()));
    String statusSelecionado = "DISPONIVEL";
    carros.setStatus(statusSelecionado);
    carros.setImagem(tfimg.getText());
    dao3 = new TabelaCarrosController();
    dao = new CRUD() {};

    try {
        if (!ConnectionFactory.getConnectionb()) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        } else {
            if (dao.save(carros)) {
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados do carro");
            }

            dao3.atualizarTabela((DefaultTableModel) tabelacarros.getModel());
            tabelacarros.revalidate();
            tabelacarros.repaint();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela de carros");
    } finally {
        ConnectionFactory.closeConnection();
    }
    }//GEN-LAST:event_ADICIONARActionPerformed

    private void MODELOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODELOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MODELOActionPerformed

    private void SELECIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SELECIONARActionPerformed
    CRUD dao = new CRUD() {};
    dao.selecionarImagem(lblfoto,tfimg);

    }//GEN-LAST:event_SELECIONARActionPerformed

    private void fechar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fechar

    }//GEN-LAST:event_fechar

    private void EDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITARActionPerformed
        try {
            editarDados();
        } catch (SQLException ex) {
            Logger.getLogger(gerenciarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EDITARActionPerformed

    private void lblmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblmenuMouseClicked
       
    }//GEN-LAST:event_lblmenuMouseClicked
    
    private void editarDados() throws SQLException {
    CRUD dao = new CRUD() {};
    Carros carro = new Carros();
    int selectedRow = tabelacarros.getSelectedRow();

    if (selectedRow != -1) {
        String placa = tabelacarros.getValueAt(selectedRow, 0).toString();
        String novoPlaca = PLACA.getText();
        String novoMarca = MARCA.getText();
        String novoModelo = MODELO.getText();
        double novoPreco = Double.parseDouble(PRECO.getText());
        String novaImg = tfimg.getText();
        
        carro.setPlaca(placa);
        carro.setPreco(novoPreco);
        carro.setModelo(novoModelo);
        carro.setMarca(novoMarca);
        carro.setImagem(novaImg);

        if (!ConnectionFactory.getConnectionb()) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
            return;
        }

        try {
            if (dao.update(carro)) {
                JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");
                DefaultTableModel model = (DefaultTableModel) tabelacarros.getModel();
                model.setValueAt(novoPlaca, selectedRow, 0);
                model.setValueAt(novoMarca, selectedRow, 1);
                model.setValueAt(novoModelo, selectedRow, 2);
                model.setValueAt(novoPreco, selectedRow, 3);
                tabelacarros.clearSelection();
                PLACA.setText("");
                MARCA.setText("");
                MODELO.setText("");
                PRECO.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível editar os dados do carro");
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao editar os dados do carro");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Selecione um carro para editar");
    }
}

    public void exibirDados() {
        try {
            con = ConnectionFactory.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM carros");
            tabelacarros.setModel(resultSetToTableModel(rs));
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection();
        }
    }
  //metodo para adaptar a tabela ao banco de dados
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

    private void voltarTelaPrincipal() {
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
    this.dispose(); // Fecha a janela atual
}
    



    
    // init componentes metodo

    public static void main(String args[]) {
        try {
    UIManager.setLookAndFeel( new FlatDarkPurpleIJTheme());
    } catch( Exception ex ) {
    System.err.println( "Failed to initialize LaF" );
}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gerenciarCarro().setVisible(true);
            }
        });
    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADICIONAR;
    private javax.swing.JButton EDITAR;
    private javax.swing.JButton EXCLUIR;
    private javax.swing.JLabel GERENCIAR;
    private javax.swing.JButton LIMPAR1;
    private javax.swing.JTextField MARCA;
    private javax.swing.JTextField MODELO;
    private javax.swing.JTextField PLACA;
    private javax.swing.JTextField PRECO;
    private javax.swing.JButton SELECIONAR;
    private javax.swing.JComboBox<String> cbstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblmenu;
    private javax.swing.JTable tabelacarros;
    private javax.swing.JTextField tfimg;
    // End of variables declaration//GEN-END:variables


}
