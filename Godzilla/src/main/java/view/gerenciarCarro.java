/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.sql.ResultSetMetaData;
import model.entities.Carros;
import model.dao.CarrosDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;


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
        
        // Alteração para exibir o valor do campo "PRECO" ao invés do campo "STATUS"
        PRECO.setText(tabelacarros.getValueAt(selectedRow, 4).toString());

    }
}

});

    
    
    }
    
    

    private Connection con;
    private Statement st;
    private ResultSetMetaData metaData;
    private ResultSet rs;
    


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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
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
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GERENCIAR)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LIMPAR1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(SELECIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GERENCIAR)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(SELECIONAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EXCLUIR)
                    .addComponent(ADICIONAR)
                    .addComponent(EDITAR)
                    .addComponent(LIMPAR1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
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
    }//GEN-LAST:event_LIMPAR1ActionPerformed

    private void tabelacarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelacarrosMouseClicked

    }//GEN-LAST:event_tabelacarrosMouseClicked

    private void EXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXCLUIRActionPerformed
        int selectedRow = tabelacarros.getSelectedRow(); // Obtém a linha selecionada

        if (selectedRow != -1) { // Verifica se alguma linha foi selecionada
            String placa = tabelacarros.getValueAt(selectedRow, 0).toString(); // Obtém o valor da coluna "PLACA" da linha selecionada

            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o carro com a placa: " + placa + "?", "Excluir Carro", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) { // Confirmação do usuário
                CarrosDao dao = new CarrosDao();

                try {
                    if (!dao.conectar()) {
                        JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
                    } else {
                        if (dao.excluirCarro(placa)) { // Exclui o carro com a placa especificada
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
    CarrosDao dao;
    boolean sts;
    carros.setPlaca(PLACA.getText());
    carros.setMarca(MARCA.getText());
    carros.setModelo(MODELO.getText());
    carros.setPreco(Double.parseDouble(PRECO.getText()));
    String statusSelecionado = (String) cbstatus.getSelectedItem();
    carros.setStatus(statusSelecionado);
    

    dao = new CarrosDao();

    try {
        if (!dao.conectar()) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
        } else {
            if (dao.salvar(carros)) {
                JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados do carro");
            }

            dao.atualizarTabela((DefaultTableModel) tabelacarros.getModel());
            tabelacarros.revalidate();
            tabelacarros.repaint();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela de carros");
    }
    }//GEN-LAST:event_ADICIONARActionPerformed

    private void MODELOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MODELOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MODELOActionPerformed

    private void SELECIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SELECIONARActionPerformed
        selecionarImagem();
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
    
    private void editarDados() throws SQLException {
    CarrosDao dao = new CarrosDao();
    int selectedRow = tabelacarros.getSelectedRow();

    if (selectedRow != -1) {
        String placa = tabelacarros.getValueAt(selectedRow, 0).toString();
        String novoPlaca = PLACA.getText();
        String novoMarca = MARCA.getText();
        String novoModelo = MODELO.getText();
        double novoPreco = Double.parseDouble(PRECO.getText());

        if (!dao.conectar()) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados");
            return;
        }

        try {
            // Get the current status from the database
            String currentStatus = dao.getStatus(placa);

            String novoStatus = cbstatus.getSelectedItem().toString();
            
            if (!novoStatus.equals(currentStatus)) {
                // Update the status in the database
                if (dao.editarStatusCarro(placa, novoStatus)) {
                    JOptionPane.showMessageDialog(null, "Status do carro editado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível editar o status do carro");
                }
            }

            if (dao.editarCarro(placa, novoPlaca, novoMarca, novoModelo, novoPreco, novoStatus)) {
                JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");
                DefaultTableModel model = (DefaultTableModel) tabelacarros.getModel();
                model.setValueAt(novoPlaca, selectedRow, 0);
                model.setValueAt(novoMarca, selectedRow, 1);
                model.setValueAt(novoModelo, selectedRow, 2);
                model.setValueAt(novoPreco, selectedRow, 3);
                model.setValueAt(novoStatus, selectedRow, 4);
                tabelacarros.clearSelection();
                PLACA.setText("");
                MARCA.setText("");
                MODELO.setText("");
                PRECO.setText("");
                // Update the status in the JComboBox
                cbstatus.setSelectedItem(novoStatus);
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
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemagod", "root", "1234");
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM carros");
        tabelacarros.setModel(resultSetToTableModel(rs));
    } catch (SQLException ex) {
        ex.printStackTrace();
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

    // selecionar imagem
    // Variável para armazenar o caminho da imagem selecionada
    private String caminhoImagem = "";

    private void selecionarImagem() {
    JFileChooser fileChooser = new JFileChooser();
    int resultado = fileChooser.showOpenDialog(this);

    if (resultado == JFileChooser.APPROVE_OPTION) {
        File arquivoSelecionado = fileChooser.getSelectedFile();
        String nomeArquivo = arquivoSelecionado.getName();

        // Defina o diretório de destino
        String diretorioDestino = "images/";

        // Copie o arquivo para o diretório de destino
        try {
            Files.copy(arquivoSelecionado.toPath(), new File(diretorioDestino + nomeArquivo).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado com sucesso para " + diretorioDestino + nomeArquivo);
            
            // Armazena o caminho da imagem selecionada na variável
            caminhoImagem = diretorioDestino + nomeArquivo;
        } catch (IOException e) {
            System.out.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelacarros;
    // End of variables declaration//GEN-END:variables


}
