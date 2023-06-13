/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author migue
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setTitle("Aluguel de carros ");
        JRootPane rootPane;
        rootPane = SwingUtilities.getRootPane(this);
        rootPane.setWindowDecorationStyle(JRootPane.FRAME);
        JLayeredPane layeredPane = rootPane.getLayeredPane();
        layeredPane.setBackground(Color.RED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        GERENCIAR = new javax.swing.JLabel();
        btnAlugar = new javax.swing.JButton();
        btnGcarros = new javax.swing.JButton();
        btnGclientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 300));

        GERENCIAR.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        GERENCIAR.setText("Godzilla");

        btnAlugar.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAlugar.setText("ALUGAR/RETORNAR CARRO");

        btnGcarros.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnGcarros.setText("GERENCIAR CARROS");
        btnGcarros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGcarrosActionPerformed(evt);
            }
        });

        btnGclientes.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnGclientes.setText("GERENCIAR CLIENTES");
        btnGclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGclientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGclientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGcarros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlugar))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(GERENCIAR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(GERENCIAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlugar)
                .addGap(18, 18, 18)
                .addComponent(btnGcarros)
                .addGap(18, 18, 18)
                .addComponent(btnGclientes)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGcarrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGcarrosActionPerformed
        new gerenciarCarro().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGcarrosActionPerformed

    private void btnGclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGclientesActionPerformed
        new gerenciarCliente2().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGclientesActionPerformed

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
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GERENCIAR;
    private javax.swing.JButton btnAlugar;
    private javax.swing.JButton btnGcarros;
    private javax.swing.JButton btnGclientes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
