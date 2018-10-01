/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Transferencia;
import Modelo.DataCuenta;
import Modelo.DataTransferencia;
import Vista.frmTransferencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UTPL
 */
public class CrtTransferencia implements ActionListener, MouseListener {

    private Cuenta modCuenta;

    private Transferencia mod;
    Cliente modCliente = new Cliente();
    CrtClientes modLog = new CrtClientes();
    private DataTransferencia modC;
    private frmTransferencia frm;

    public CrtTransferencia(Transferencia mod, DataTransferencia modC, frmTransferencia frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.jBBuscar.addActionListener(this);
        this.frm.jBtransferir.addActionListener(this);
        this.frm.jTCuenta1.addMouseListener(this);
        this.frm.jTCuenta2.addMouseListener(this);

    }

    public void Iniciar() {
        frm.setTitle("Transferencia");
        frm.setLocationRelativeTo(null);
        frm.jLIdCA.setVisible(false);
        frm.jLidC.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBBuscar) {
            Cliente objClie = new Cliente();
            if (BuscarCuentaCliente()) {

                JOptionPane.showMessageDialog(null, "Registro encontrado");
                ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
                ArrayCuentas = modCliente.getCuenta();
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("idCuenta");
                modelo.addColumn("Numero");
                modelo.addColumn("Tipo");
                modelo.addColumn("Saldo");
                modelo.addColumn("Id del Oficial");
                for (Cuenta cuenta : ArrayCuentas) {
                    Object[] fila = new Object[5];
                    fila[0] = cuenta.getIdCuenta();
                    fila[1] = cuenta.getNumero();
                    fila[2] = cuenta.getTipo();
                    fila[3] = cuenta.getSaldo();
                    fila[4] = cuenta.getIdOficial();
                    modelo.addRow(fila);
                }
                //frm.jTCuenta1.setModel(modelo);
                frm.jTCuenta2.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL cliente no existe");
            }
            //TAbla cuentas Autorizadas
            if (BuscarCuentaClienteAutorizado()) {

                JOptionPane.showMessageDialog(null, "Registro encontrado");
                ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
                ArrayCuentas = modCliente.getCuenta();
                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("idCuenta");
                modelo.addColumn("idCuentaAutorizada");
                modelo.addColumn("Numero");
                modelo.addColumn("Tipo");
                modelo.addColumn("Saldo");
                modelo.addColumn("Id del Oficial");
                for (Cuenta cuenta : ArrayCuentas) {
                    Object[] fila = new Object[6];
                    fila[0] = cuenta.getIdCuenta();
                    fila[1] = cuenta.getIdCuentaAutorizada();
                    fila[2] = cuenta.getNumero();
                    fila[3] = cuenta.getTipo();
                    fila[4] = cuenta.getSaldo();
                    fila[5] = cuenta.getIdOficial();
                    modelo.addRow(fila);
                }
                frm.jTCuenta1.setModel(modelo);
                //frm.jTCuenta2.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, "EL cliente no existe");
            }

        }
        //transferir
        if (e.getSource() == frm.jBtransferir) {
            mod.setNumero(Integer.parseInt(GenerarNumeroTransaccion()));

            mod.setFecha(Date.valueOf(generarFechaActual()));//AAAA-mm-dd

            mod.setValor(Double.parseDouble(frm.jTDineroTransferir.getText()));
            mod.setObservacion(frm.jTOBservacion.getText());
            mod.setIdCuentaAutorizada(Integer.parseInt(frm.jLIdCA.getText()));
            System.out.println("que hay en el label " + frm.jLbl1.getText());
            mod.setIdCuenta(Integer.parseInt(frm.jLidC.getText()));
            System.out.println("ok");
            if (modC.InsertarTransferencia(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

            //mod.setCuentaAutorizada(CuentaAutorizada);
        }

    }

    //sobre las tablas
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frm.jTCuenta1) {
            int row = frm.jTCuenta1.getSelectedRow();
            //int column = (int) jTCuenta1.getSelectedColumn();
            //String strValor = (String) jTCuenta1.getModel().getRowCount(row);
            String aux = frm.jTCuenta1.getValueAt(row, 2).toString();
            frm.jLbl1.setText(aux);

            int row2 = frm.jTCuenta1.getSelectedRow();
            String aux2 = frm.jTCuenta1.getValueAt(row, 0).toString();
            frm.jLIdCA.setText(aux2);
        }

        if (e.getSource() == frm.jTCuenta2) {
            int row = (int) frm.jTCuenta2.getSelectedRow();
            //int column = (int) jTCuenta1.getSelectedColumn();
            //String strValor = (String) jTCuenta1.getModel().getRowCount(row);
            String aux = frm.jTCuenta2.getValueAt(row, 1).toString();
            frm.jLbl2.setText(aux);

            int row2 = frm.jTCuenta2.getSelectedRow();
            String aux2 = frm.jTCuenta2.getValueAt(row, 0).toString();
            frm.jLidC.setText(aux2);

        }
    }

    public boolean BuscarCuentaCliente() {
        modCliente = modLog.BuscarCliente2(frm.jTCedula.getText());
        System.out.println("que hay " + modCliente);
        if (modCliente.getDireccion() != null) //0 se crea con el objeto vacio
        {
            return true;
        } else {
            return false;
        }
    }

    public boolean BuscarCuentaClienteAutorizado() {
        modCliente = modLog.BuscarClienteAutorizado(frm.jTCedula.getText());
        System.out.println("que hay " + modCliente);
        if (modCliente.getDireccion() != null) //0 se crea con el objeto vacio
        {
            return true;
        } else {
            return false;
        }
    }

    public String generarFechaActual() {
        java.util.Date ahora = new java.util.Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
    
    public String GenerarNumeroTransaccion() {
        DataTransferencia modC = new DataTransferencia();
       
        Transferencia ObjTra = new Transferencia();
        ObjTra = modC.BuscarIdTransferencia();
        int calculo = ObjTra.getNumero() + 1;
        System.out.println("");
        String auxNum = "";
        if (calculo <= 9) {
            auxNum = "00" + String.valueOf(calculo);
        }
        if (calculo >= 10 && calculo <= 99) {
            auxNum = "0" + String.valueOf(calculo);
        }
        if (calculo >= 100 && calculo <= 999) {
            auxNum = String.valueOf(calculo);
        }
        return auxNum;
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
