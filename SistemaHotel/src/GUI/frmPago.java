/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAT.vHabitacion;
import DAT.vPago;
import DAT.vReserva;

import BL.fConsumo;
import BL.fHabitacion;
import BL.fPago;
import BL.fProducto;
import BL.fReserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author CARLOS
 */
public class frmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public frmPago() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        txtIdReserva.setText(idreserva);
        txtCliente.setText(cliente);
        txtHabitacion.setText(habitacion);
        txtIdHabitacion.setText(idhabitacion);
        txtTotalReserva.setText(Double.toString(totalreserva));

        fConsumo func = new fConsumo();
        func.mostrar(idreserva);

        txtTotal_pago.setText(Double.toString(totalreserva + func.totalconsumo));

    }

    private String accion = "guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_columnasconsumo() {
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidPago.setVisible(false);

        txtIdReserva.setVisible(false);
        txtCliente.setEnabled(false);
        txtNum_comprobante.setEnabled(false);
        cboTipo_comprobante.setEnabled(false);
        txtIgv.setEnabled(false);
        txtTotal_pago.setEnabled(false);
        txtTotalReserva.setEnabled(false);
        dcFecha_emision.setEnabled(false);
        dcFecha_pago.setEnabled(false);

        txtIdHabitacion.setVisible(false);
        txtHabitacion.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidPago.setText("");
        txtNum_comprobante.setText("");
        txtIgv.setText("");
        txtTotal_pago.setText("");

    }

    void habilitar() {
        txtidPago.setVisible(false);

        txtIdReserva.setVisible(true);
        txtCliente.setEnabled(true);
        txtNum_comprobante.setEnabled(true);
        cboTipo_comprobante.setEnabled(true);
        txtIgv.setEnabled(true);
        txtTotal_pago.setEnabled(true);
        txtTotalReserva.setEnabled(true);
        dcFecha_emision.setEnabled(true);
        dcFecha_pago.setEnabled(true);

        txtIdHabitacion.setVisible(true);
        txtHabitacion.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidPago.setText("");
        txtNum_comprobante.setText("");
        txtIgv.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fPago func = new fPago();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));

            //Mostrar los datos de los consumos
            fConsumo func2 = new fConsumo();
            modelo = func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();

            lbltotalregistrosconsumo.setText("Total Consumos " + func2.totalregistros);
            lbltotalconsumo.setText("Consumo Total: $." + func2.totalconsumo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttotal_reserva = new javax.swing.JPanel();
        txtidPago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNum_comprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboTipo_comprobante = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalReserva = new javax.swing.JTextField();
        txtIdHabitacion = new javax.swing.JTextField();
        txtHabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal_pago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dcFecha_emision = new com.toedter.calendar.JDateChooser();
        dcFecha_pago = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txttotal_reserva.setBackground(new java.awt.Color(255, 204, 102));
        txttotal_reserva.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagos"));

        jLabel2.setText("Reserva:");

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Habitación:");

        jLabel6.setText("Num Comprobante:");

        txtNum_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum_comprobanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo Comprobante:");

        cboTipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleta", "Factura", "Ticket", "Otro" }));
        cboTipo_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipo_comprobanteActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevo.GIF"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(51, 51, 51));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Total Reserva:");

        txtIdHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdHabitacionActionPerformed(evt);
            }
        });

        jLabel8.setText("Igv:");

        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Pago:");

        txtTotal_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal_pagoActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Emisión:");

        jLabel11.setText("Fecha Pago:");

        javax.swing.GroupLayout txttotal_reservaLayout = new javax.swing.GroupLayout(txttotal_reserva);
        txttotal_reserva.setLayout(txttotal_reservaLayout);
        txttotal_reservaLayout.setHorizontalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txttotal_reservaLayout.createSequentialGroup()
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtidPago, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txttotal_reservaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addComponent(btnnuevo)
                                    .addGap(42, 42, 42)
                                    .addComponent(btnguardar)
                                    .addGap(58, 58, 58)
                                    .addComponent(btncancelar))
                                .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboTipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3)
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dcFecha_emision, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(dcFecha_pago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(99, 99, 99)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(101, 101, 101))
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txttotal_reservaLayout.createSequentialGroup()
                        .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txttotal_reservaLayout.setVerticalGroup(
            txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txttotal_reservaLayout.createSequentialGroup()
                .addComponent(txtidPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboTipo_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNum_comprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotal_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dcFecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(dcFecha_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(txttotal_reservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pagos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pagos"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(51, 51, 51));
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salir.gif"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsalir)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbltotalregistros))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));

        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistadoconsumo);

        lbltotalregistrosconsumo.setText("Registros");

        lbltotalconsumo.setText("jLabel12");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalconsumo)
                        .addGap(48, 48, 48)
                        .addComponent(lbltotalregistrosconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumo)
                    .addComponent(lbltotalconsumo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        // TODO add your handling code here:
        txtIdReserva.transferFocus();
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void txtNum_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum_comprobanteActionPerformed
        // TODO add your handling code here:
        txtNum_comprobante.transferFocus();
    }//GEN-LAST:event_txtNum_comprobanteActionPerformed

    private void cboTipo_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipo_comprobanteActionPerformed
        // TODO add your handling code here:
        cboTipo_comprobante.transferFocus();
    }//GEN-LAST:event_cboTipo_comprobanteActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtIgv.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el igv del Comprobante de pago a generar");
            txtIgv.requestFocus();
            return;
        }
        if (txtTotal_pago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante");
            txtTotal_pago.requestFocus();
            return;
        }

        if (txtNum_comprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Comprobante del Pago");
            txtNum_comprobante.requestFocus();
            return;
        }

        vPago dts = new vPago();
        fPago func = new fPago();

        dts.setIntIdreserva(Integer.parseInt(txtIdReserva.getText()));

        int seleccionado = cboTipo_comprobante.getSelectedIndex();
        dts.setStrTipo_comprobante((String) cboTipo_comprobante.getItemAt(seleccionado));

        dts.setStrNum_comprobante(txtNum_comprobante.getText());
        dts.setDbIgv(Double.parseDouble(txtIgv.getText()));
        dts.setDbTotal_pago(Double.parseDouble(txtTotal_pago.getText()));

        Calendar cal;
        int d, m, a;

        cal = dcFecha_pago.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setDateFecha_pago(new Date(a, m, d));

        cal = dcFecha_emision.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setDateFecha_emision(new Date(a, m, d));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " El pago por $. " + txtTotal_pago.getText()
                        + " del Sr. " + txtCliente.getText() + " Ha sido realizado con Éxito");
                mostrar(idreserva);
                inhabilitar();

                //Desocupar la Habitación
                fHabitacion func2 = new fHabitacion();
                vHabitacion dts2 = new vHabitacion();

                dts2.setIntIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                func2.desocupar(dts2);

                //Cancelar o pagar la reserva
                fReserva func3 = new fReserva();
                vReserva dts3 = new vReserva();

                dts3.setIntIdReserva(Integer.parseInt(txtIdReserva.getText()));
                func3.pagar(dts3);

            }

        } else if (accion.equals("editar")) {
            dts.setIntIdpago(Integer.parseInt(txtidPago.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr. "
                        + txtCliente.getText() + " Ha sido Modificado Correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidPago.setText(tablalistado.getValueAt(fila, 0).toString());
        //txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());

        cboTipo_comprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtNum_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtIgv.setText(tablalistado.getValueAt(fila, 4).toString());
        txtTotal_pago.setText(tablalistado.getValueAt(fila, 5).toString());

        dcFecha_emision.setDate(Date.valueOf(tablalistado.getValueAt(fila, 6).toString()));
        dcFecha_pago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString()));


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidPago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Pago seleccionado?", "Confirmar", 2);

            if (confirmacion == 0) {
                fPago func = new fPago();
                vPago dts = new vPago();

                dts.setIntIdpago(Integer.parseInt(txtidPago.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtIdHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdHabitacionActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotal_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal_pagoActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked




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
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cboTipo_comprobante;
    private com.toedter.calendar.JDateChooser dcFecha_emision;
    private com.toedter.calendar.JDateChooser dcFecha_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNum_comprobante;
    private javax.swing.JTextField txtTotalReserva;
    private javax.swing.JTextField txtTotal_pago;
    private javax.swing.JTextField txtidPago;
    private javax.swing.JPanel txttotal_reserva;
    // End of variables declaration//GEN-END:variables
}
