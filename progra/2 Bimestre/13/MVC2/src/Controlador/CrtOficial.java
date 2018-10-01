/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Oficial;
import Modelo.DataOficial;
import Vista.frmOficial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author UTPL
 */
public class CrtOficial implements ActionListener {
    
    private Oficial mod;
    private DataOficial modC;
    private frmOficial frm;
    
    public CrtOficial(Oficial mod, DataOficial modC, frmOficial frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        
        this.frm.jBBuscar.addActionListener(this);
        this.frm.jBCrear.addActionListener(this);
    }
    
    public void Iniciar(){
        frm.setTitle("Crear oficial");
        frm.setLocationRelativeTo(null);        
    }
    
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBBuscar) {
            mod.setCedula(frm.jTCedula.getText());

            if (modC.BuscarOficialB(mod)) {
                
                frm.jTNombres.setText(String.valueOf(mod.getNombres()));
                frm.jTApellido.setText(String.valueOf(mod.getApellidos()));
                frm.jTCedula.setText(String.valueOf(mod.getCedula()));
                frm.jTSucursal.setText(String.valueOf(mod.getSucursal()));
                JOptionPane.showMessageDialog(null, "Registro encontrado");
                frm.jBCrear.setEnabled(false);
            } else {
                
                JOptionPane.showMessageDialog(null, "No existe puede Crearlo");
                frm.jTNombres.setText("");
                frm.jTApellido.setText("");
                frm.jTSucursal.setText("");
                frm.jTCedula.setEnabled(false);
                
                frm.jBCrear.setEnabled(true);
            }
        }

        //CREar
        if (e.getSource() == frm.jBCrear) {
            mod.setNombres(frm.jTNombres.getText());
            mod.setApellidos(frm.jTApellido.getText());
            mod.setCedula(frm.jTCedula.getText());
            mod.setSucursal(Integer.parseInt(frm.jTSucursal.getText()));
            if (modC.InsertarOficial(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }

    }
    
    
    
    

//    static DataOficial ObjDatOfi = new DataOficial();
//
//    public static Oficial OficialCuenta(String NumCue) {
//        Oficial ObjOfi = new Oficial();
//        ObjOfi = ObjDatOfi.BuscarOficialCuenta(NumCue);
//        return ObjOfi;
//    }
//
//    public Oficial BuscarOficial(String Cedula) {
//        Oficial ObjOfi = new Oficial();
//        ObjOfi.setCedula(Cedula);
//        ObjOfi = ObjDatOfi.BuscarOficial(ObjOfi);
//        return ObjOfi;
//    }
//
//    public Oficial BuscarOficialId(int idOficial) {
//        Oficial ObjOfi = new Oficial();
//        ObjOfi.setIdOficial(idOficial);
//        ObjOfi = ObjDatOfi.BuscarOficialId(ObjOfi);
//        return ObjOfi;
//    }
//
//    public boolean InsertarOficial(Oficial ObjOfi) {
//        boolean x = ObjDatOfi.InsertarOficial(ObjOfi);
//        return x;
//    }

    
}
