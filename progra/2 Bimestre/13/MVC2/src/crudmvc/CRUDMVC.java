/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CrtCajero;
import Controlador.CrtClientes;
import Controlador.CrtCuenta;
import Controlador.CrtOficial;
import Controlador.CrtProducto;
import Controlador.CrtTransferencia;
import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.DATProducto;
import Modelo.DataCajero;
import Modelo.DataClientes;
import Modelo.DataCuenta;
import Modelo.DataOficial;
import Modelo.DataTransferencia;
import Modelo.Oficial;
import Modelo.Producto;
import Modelo.Transferencia;
import Vista.frmCajero;
import Vista.frmCliente;
import Vista.frmCuenta;
import Vista.frmOficial;
import Vista.frmProducto;
import Vista.frmTransferencia;

/**
 *
 * @author Danilo Jaramillo H
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear Cajero
//        Cajero mod = new Cajero();
//        DataCajero modC = new DataCajero();
//        frmCajero frm = new frmCajero();
//        
//        CrtCajero ctrl = new CrtCajero(mod, modC, frm);
//        ctrl.Iniciar();
//        frm.setVisible(true);
        //CLIENTE
//        Cliente mod = new Cliente();
//        DataClientes modC = new DataClientes();
//        frmCliente frm = new frmCliente();
//
//        CrtClientes ctrl = new CrtClientes(mod, modC, frm);
//        ctrl.Iniciar();
//        frm.setVisible(true);
        //Oficial
//        Oficial mod = new Oficial();
//        DataOficial modC = new DataOficial();
//        frmOficial frm = new frmOficial();
//        CrtOficial ctrl = new CrtOficial(mod, modC, frm);
//        ctrl.Iniciar();
//        frm.setVisible(true);
        //Cuenta
//        Cuenta mod = new Cuenta();
//        DataCuenta modC = new DataCuenta();
//        frmCuenta frm = new frmCuenta();
//        CrtCuenta ctrl = new CrtCuenta(mod, modC, frm);
//        ctrl.Iniciar();
//        frm.setVisible(true);

//        //Transferencias
        Transferencia mod = new Transferencia();
        DataTransferencia modC = new DataTransferencia();
        frmTransferencia frm = new frmTransferencia();
        CrtTransferencia ctrl = new CrtTransferencia(mod, modC, frm);
        ctrl.Iniciar();
        frm.setVisible(true);
                
        
        
    }

}
