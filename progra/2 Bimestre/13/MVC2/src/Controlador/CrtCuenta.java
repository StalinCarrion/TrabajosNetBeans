/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.DataCajero;
import Modelo.DataCuenta;
import Modelo.DataOficial;
import Modelo.Oficial;
import Vista.frmCajero;
import Vista.frmCuenta;
import Vista.frmOficial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author UTPL
 */
public class CrtCuenta implements ActionListener {

    private Cuenta mod;
    private Oficial modOfi;

    private DataCuenta modC;
    private DataOficial modCOfi;

    private frmCuenta frm;
    private frmOficial frmOfi;

    public CrtCuenta(Cuenta mod, DataCuenta modC, frmCuenta frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        
        this.frm.jBCOmprobarOficial.addActionListener(this);
        this.frm.jBComprobarCuenta.addActionListener(this);
        this.frm.jBComprobarSaldo.addActionListener(this);
        this.frm.jBCrearCuenta.addActionListener(this);
    }

    public void Iniciar() {
        frm.setTitle("Crear Cuenta");
        frm.setLocationRelativeTo(null);
        frm.jBCOmprobarOficial.setEnabled(false);
        frm.JRAhorros.setEnabled(false);

        frm.jBComprobarSaldo.setEnabled(false);
        frm.jTNOficial.setEnabled(false);
        frm.jTSaldo.setEnabled(false);
        frm.jRCorriente.setEnabled(false);
        frm.jBCrearCuenta.setEnabled(false);
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.jBComprobarCuenta) {
            System.out.println("ok");
            mod.setNumero(frm.jTNCuenta.getText());

            if (modC.BuscarCuentaB(mod)) {
                JOptionPane.showMessageDialog(null, "Registro encontrado");

            } else {
                JOptionPane.showMessageDialog(null, "No existe, puede Crearlo");
                frm.jBComprobarCuenta.setEnabled(false);
                frm.jTNCuenta.setEditable(false);
                frm.jBCOmprobarOficial.setEnabled(true);
                frm.JRAhorros.setEnabled(true);
                frm.jBComprobarSaldo.setEnabled(false);
                frm.jTNOficial.setEnabled(true);
                frm.jRCorriente.setEnabled(true);
            }
        }
        //Buscar Oficial
        if (e.getSource() == frm.jBCOmprobarOficial) {
            Oficial modOfi = new Oficial();     
            modOfi.setIdOficial(Integer.parseInt(frm.jTNOficial.getText()));            
            if (modC.BuscarOficialIdB(modOfi)) {
                JOptionPane.showMessageDialog(null, "Registro encontrado");
                frm.jBComprobarSaldo.setEnabled(true);
                frm.jTSaldo.setEnabled(true);
                frm.jBCOmprobarOficial.setEnabled(false);
                frm.jTNOficial.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No existe");
            }
        }
        //Comprobar Saldo
        if (e.getSource() == frm.jBComprobarSaldo) {
            String auxTipoCuenta = "";
            int tipo = 0;
            int saldo = Integer.parseInt(frm.jTSaldo.getText());
            if (frm.JRAhorros.isSelected()) {
                // 1 va hacer ahorros 
                // Ahorros va hacer 20
                auxTipoCuenta = "ahorros";
                tipo = 1;
            }
            if (frm.jRCorriente.isSelected()) {
                //2 va hacer corriete
                //Corriente va hacer 50
                auxTipoCuenta = "corriente";
                tipo = 2;
            }

            int NOficial = 0;
            Double saldoA = 0.0;
            saldoA = Double.parseDouble(frm.jTSaldo.getText());
            if (tipo == 1 && saldo < 20) {
                JOptionPane.showMessageDialog(null, "Cuenta Ahorros tiene que tener minimo 20");

            }
            if (tipo == 1 && saldo >= 20) {
                JOptionPane.showMessageDialog(null, "Cuenta Ahorros creada con saldo" + saldo);
                frm.jBCrearCuenta.setEnabled(true);
            }
            if (tipo == 2 && saldo < 50) {
                JOptionPane.showMessageDialog(null, "Cuenta Corriente tiene que tener minimo 50");
            }
            if (tipo == 2 && saldo >= 50) {
                JOptionPane.showMessageDialog(null, "Cuenta Corriente creada con saldo" + saldo);
                frm.jBCrearCuenta.setEnabled(true);
            }
        }
        //CREar
        if (e.getSource() == frm.jBCrearCuenta) {
            String auxTipoCuenta = "";
            int tipo = 0;
            mod.setNumero(frm.jTNCuenta.getText());
            if (frm.JRAhorros.isSelected()) {
                // 1 va hacer ahorros 
                // Ahorros va hacer 20
                auxTipoCuenta = "ahorros";
                tipo = 1;
            }
            if (frm.jRCorriente.isSelected()) {
                //2 va hacer corriete
                //Corriente va hacer 50
                auxTipoCuenta = "corriente";
                tipo = 2;
            }
            mod.setTipo(tipo);
            int NOficial = 0;
            Double saldoA = 0.0;
            NOficial = Integer.parseInt(frm.jTNOficial.getText());
            mod.setIdOficial(NOficial);
            saldoA = Double.parseDouble(frm.jTSaldo.getText());
            mod.setSaldo(saldoA);
            if (modC.InsertarCuenta(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }

    }

    static DataCuenta ObjDatCue = new DataCuenta();
    static Cuenta ObjCue = new Cuenta();

    public static ArrayList<Cuenta> ClientesCuenta(String NumCue) {
        ArrayList<Cuenta> ArrayCuentas= new ArrayList<Cuenta>();
        ArrayCuentas = ObjDatCue.ClientesCuenta(NumCue);
        return ArrayCuentas;
    }
    
    public static ArrayList<Cuenta> ClientesCuentaAutorizado(String NumCue) {
        ArrayList<Cuenta> ArrayCuentas= new ArrayList<Cuenta>();
        ArrayCuentas = ObjDatCue.ClientesAutorizado(NumCue);
        return ArrayCuentas;
    }
//
//    public Cuenta BuscarCuenta(String NumCue) {
//        Cuenta ObjCue = new Cuenta();
//        ObjCue.setNumero(NumCue);
//        ObjCue = ObjDatCue.BuscarCuenta(ObjCue);
//        if (ObjCue.getTipo() != 0) {
//            // si hay cuenta, se deben llenar los clientes propietarios
//            ObjCue.setClientes(LogicaClientes.ClientesCuenta(ObjCue.getNumero()));
//            // se debe llenar el cliente autorizado
//            ObjCue.setAutorizado(LogicaClientes.ClientesCuentaAutorizado(ObjCue.getNumero()));
//            // se debe llenar el oficial
//            ObjCue.setOficial(LogicaOficial.OficialCuenta(ObjCue.getNumero()));
//        }
//        return ObjCue;
//    }
//
//    public String BuscarIdCuenta(String NumCue) {
//        String aux = "";
//        aux = ObjDatCue.Buscar_idCuenta(ObjCue);
//        return aux;
//    }
//
//    public boolean InsertarCuenta(Cuenta ObjCuenta) {
//        boolean x = ObjDatCue.InsertarCuenta(ObjCuenta);
//        return x;
//    }
}
