/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Depositante;
import Clases.PersonaCuenta;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class ManDepositante {
    public Depositante CrearDepositante(String nombre, String apellido, String cedula, String dinero, PersonaCuenta personaCuenta){
        Depositante objClie = new Depositante(nombre, apellido, cedula, dinero, personaCuenta);
        return objClie;
    }
    
    public Depositante BuscarDepositante(ArrayList<Depositante> ArrayClientes1, String Cedula){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Depositante objAux = new Depositante();
        for (Depositante objCli : ArrayClientes1){// RECORRER EL ARRAYLIST
            String strCe = objCli.getCedula().trim(); 
            if (strCe.equals(Cedula.trim())) //PREGUNTAR POR CADA OBJETO
                objAux=objCli;
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
}
