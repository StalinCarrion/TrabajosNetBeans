/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cajero;
import Modelo.DataCajero;
import Vista.frmCajero;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author UTPL
 */
public class CrtCajero implements ActionListener {
//    DataCajero ObjDatCaj = new DataCajero();
//    public Cajero BuscarCajero(String Cedula){       
//        Cajero ObjCaj = new Cajero();
//        ObjCaj.setCedula(Cedula);  
//        ObjCaj = ObjDatCaj.BuscarCajero(ObjCaj);
//        return ObjCaj;
//    }
//    
//    public boolean InsertarCajero(Cajero ObjCaj){       
//        boolean x = ObjDatCaj.InsertarCajero(ObjCaj);
//        return x;
//    }

    private Cajero mod;
    private DataCajero modC;
    private frmCajero frm;

    public CrtCajero(Cajero mod, DataCajero modC, frmCajero frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;

        this.frm.jBBuscar.addActionListener(this);
        this.frm.jBCrear.addActionListener(this);
    }

    public void Iniciar() {
        frm.setTitle("Crear Cajero");
        frm.setLocationRelativeTo(null);
        frm.jTId.setVisible(false);
        frm.jBCrear.setEnabled(false);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBBuscar) {
            mod.setCedula(frm.jTCedula.getText());

            if (modC.BuscarCajeroB(mod)) {
                
                frm.jTNombre.setText(String.valueOf(mod.getNombres()));
                frm.jTApellido.setText(String.valueOf(mod.getApellidos()));
                frm.jTCedula.setText(String.valueOf(mod.getCedula()));
                frm.jTCaja.setText(String.valueOf(mod.getCaja()));
                JOptionPane.showMessageDialog(null, "Registro encontrado");
                frm.jBCrear.setEnabled(false);
            } else {
                
                JOptionPane.showMessageDialog(null, "No existe puede Crearlo");
                frm.jTNombre.setText("");
                frm.jTApellido.setText("");
                frm.jTCaja.setText("");
                frm.jTCedula.setEnabled(false);
                
                frm.jBCrear.setEnabled(true);
            }
        }

        //CREar
        if (e.getSource() == frm.jBCrear) {
            mod.setNombres(frm.jTNombre.getText());
            mod.setApellidos(frm.jTApellido.getText());
            mod.setCedula(frm.jTCedula.getText());
            mod.setCaja(Integer.parseInt(frm.jTCaja.getText()));
            if (modC.InsertarCajero(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }

    }
}
