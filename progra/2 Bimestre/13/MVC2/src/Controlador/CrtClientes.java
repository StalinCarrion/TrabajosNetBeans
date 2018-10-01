/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Oficial;
import Modelo.DataClientes;
import Modelo.DataCuenta;
import Modelo.DataOficial;
import Vista.frmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author UTPL
 */
public class CrtClientes implements ActionListener {

    //DataCuenta ObjDatCue = new DataCuenta();
    private Cliente mod;
    private DataClientes modC;
    private frmCliente frm;

    public CrtClientes() {
    }
    
    

    public CrtClientes(Cliente mod, DataClientes modC, frmCliente frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;

        this.frm.jBBuscar.addActionListener(this);
        this.frm.jBCrear.addActionListener(this);

    }

    public void Iniciar() {
        frm.setTitle("Crear Clientes");
        frm.setLocationRelativeTo(null);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBBuscar) {
            mod.setCedula(frm.jTCedula.getText());
            if (modC.BuscarClienteB(mod)) {
                frm.jTApellidos.setText(String.valueOf(mod.getApellidos()));
                System.out.println("apellidos" + String.valueOf(mod.getApellidos()));
                frm.jTCedula.setText(String.valueOf(mod.getCedula()));
                frm.jTDireccion.setText(String.valueOf(mod.getDireccion()));
                frm.jTNombre.setText(String.valueOf(mod.getNombres()));
                JOptionPane.showMessageDialog(null, "Registro encontrado");
                frm.jBCrear.setEnabled(false);
            } else {

                JOptionPane.showMessageDialog(null, "No existe puede Crearlo");
                frm.jTNombre.setText("");
                frm.jTApellidos.setText("");
                frm.jTCedula.setEnabled(false);
                frm.jTDireccion.setText("");
                frm.jBCrear.setEnabled(true);

            }

        }
        //crear
        if (e.getSource() == frm.jBCrear) {
            mod.setNombres(frm.jTNombre.getText());
            mod.setApellidos(frm.jTApellidos.getText());
            mod.setCedula(frm.jTCedula.getText());
            mod.setDireccion(frm.jTDireccion.getText());
            if (modC.InsertarCliente(mod)) {

                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }

    }

    public Cliente BuscarCliente2(String Cedula){       
        Cliente ObjCli = new Cliente();
        ObjCli.setCedula(Cedula);  
        ObjCli = ObjDatCli.BuscarCliente(ObjCli);
        if (ObjCli.getDireccion() != null) {
            ObjCli.setCuenta(CrtCuenta.ClientesCuenta(ObjCli.getCedula()));
        }
        return ObjCli;
    }
    
    public Cliente BuscarClienteAutorizado(String Cedula){       
        Cliente ObjCli = new Cliente();
        ObjCli.setCedula(Cedula);  
        ObjCli = ObjDatCli.BuscarCliente(ObjCli);
        if (ObjCli.getDireccion() != null) {
            ObjCli.setCuenta(CrtCuenta.ClientesCuentaAutorizado(ObjCli.getCedula()));
        }
        return ObjCli;
    }

    static DataClientes ObjDatCli = new DataClientes();
    static DataOficial ObjDatOfi = new DataOficial();
    
    public static ArrayList<Cliente> ClientesCuentaCliente(String NumCue) {
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        ArrayClientes = ObjDatCli.ClientesCuentaCliente(NumCue);
        return ArrayClientes;
    }
//    
//    public Cliente BuscarCliente2(String Cedula){       
//        Cliente ObjCli = new Cliente();
//        ObjCli.setCedula(Cedula);  
//        ObjCli = ObjDatCli.BuscarCliente(ObjCli);
//        if (ObjCli.getDireccion() != null) {
//            ObjCli.setCuenta(LogicaCuenta.ClientesCuenta(ObjCli.getCedula()));
//        }
//        return ObjCli;
//    }
//
//    public static ArrayList<Cliente> ClientesCuenta(String NumCue) {
//        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
//        ArrayClientes = ObjDatCli.ClientesCuenta(NumCue);
//        return ArrayClientes;
//    }
//
//    public static Cliente ClientesCuentaAutorizado(String NumCue) {
//        Cliente ObjCli = new Cliente();
//        ObjCli = ObjDatCli.ClientesCuentaAutorizado(NumCue);
//        return ObjCli;
//    }
//
//    public static Oficial ClientesCuentaOficial(String NumCue) {
//        Oficial ObjOfi = new Oficial();
//        ObjOfi = ObjDatOfi.BuscarOficialCuenta(NumCue);
//        return ObjOfi;
//    }
//
//    public Cliente BuscarCliente(String Cedula) {
//        Cliente ObjCli = new Cliente();
//        ObjCli.setCedula(Cedula);
//        ObjCli = ObjDatCli.BuscarCliente(ObjCli);
//        return ObjCli;
//    }
//
//    public boolean InsertarCliente(Cliente ObjCli) {
//        boolean x = ObjDatCli.InsertarCliente(ObjCli);
//        return x;
//    }
}
