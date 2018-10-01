/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.CrtProducto;
import Modelo.DATProducto;
import Modelo.Producto;
import Vista.frmProducto;

/**
 *
 * @author Danilo Jaramillo H
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto mod = new Producto();
        DATProducto modC = new DATProducto();
        frmProducto frm = new frmProducto();
        
        CrtProducto ctrl = new CrtProducto(mod, modC, frm);
        ctrl.Iniciar();
        frm.setVisible(true);
    }
    
}
