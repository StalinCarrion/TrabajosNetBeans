/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import Clases.PersonaCuenta;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class ManCliente {
    public Cliente CrearCliente(String nombre, String apellido, String cedula, String dinero, PersonaCuenta personaCuenta){
        Cliente objClie = new Cliente(nombre, apellido, cedula, dinero, personaCuenta);
        return objClie;
    }
    
    public Cliente BuscarCliente(ArrayList<Cliente> ArrayClientes1, String Cedula){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cliente objAux = new Cliente();
        for (Cliente objCli : ArrayClientes1){// RECORRER EL ARRAYLIST
            String strCe = objCli.getCedula().trim(); 
            if (strCe.equals(Cedula.trim())) //PREGUNTAR POR CADA OBJETO
                objAux=objCli;
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
}
