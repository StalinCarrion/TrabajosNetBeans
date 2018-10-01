/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nelson Castiblanco
 */
public class JTable extends javax.swing.JFrame {

    DefaultTableModel modeloUsuarios;
    
    TableRowSorter rowSorter;
    int IDBUSQUEDA = 1;
   
    public JTable() {
        initComponents();
                
        cargarUsuarios();
    }

    public void cargarUsuarios(){
        String sql = "SELECT idusuario, nombre, apellido FROM usuario ORDER BY nombre ASC";
        Conexion con = new Conexion();
        Connection c = con.conectar();
        try {
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            modeloUsuarios = new DefaultTableModel(new Object[][]{}, new String[]{"ID","NOMBRE","APELLIDO"}){
                @Override
                public boolean isCellEditable(int row, int col){
                    return (col!=0);
                }
            };
            
            while(rs.next()){
                modeloUsuarios.addRow(new String[]{
                    rs.getString("idusuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido")
                });
            }
            
            rowSorter = new TableRowSorter(modeloUsuarios);
            jTable1.setRowSorter(rowSorter);
            
            modeloUsuarios.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    if(e.getType() == TableModelEvent.UPDATE){                        
                        String colname = null;
                        if(e.getColumn()==1){
                            colname = "nombre";
                        }
                        else if(e.getColumn()==2){
                            colname = "apellido";
                        }
                        String sql = "UPDATE usuario SET "+colname+"='"+modeloUsuarios.getValueAt(e.getFirstRow(), e.getColumn())+"' WHERE idusuario="+modeloUsuarios.getValueAt(e.getFirstRow(), 0);
                        Conexion con = new Conexion();
                        Connection c = con.conectar();
                        PreparedStatement pst;
                        try {
                            pst = c.prepareStatement(sql);
                            int rows = pst.executeUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(JTable.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR "+ex);
                        }
                    }
                }
            });
            
            jTable1.setCellSelectionEnabled(true);
            jTable1.setSurrendersFocusOnKeystroke(true);
            jTable1.getInputMap(javax.swing.JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "selectNextColumnCell");
            
            jTable1.setModel(modeloUsuarios);
        } catch (SQLException ex) {
            Logger.getLogger(JTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        rowSorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText().toUpperCase(), IDBUSQUEDA));
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
