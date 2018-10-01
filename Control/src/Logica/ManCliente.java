/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import java.util.ArrayList;

/**
 *
 * @author  DANILO JARAMILLO H
 * @fecha   17 MAYO
 * @descripcion    clase logica para manipular los clientes del sistema
 */
public class ManCliente {
    
    public Cliente CrearCliente(String cedula, String nombres, String apellido ){
        Cliente objClie = new Cliente(cedula, nombres,apellido);
        return objClie;
    }
//    public Cliente AgregarDireccion(Cliente objCli,String callePrincipal, String calleSecundaria, String numeroCasa, String referencia,int actual){
//        objCli.AgregarDireccion(callePrincipal, calleSecundaria, numeroCasa, referencia,actual);
//        return objCli;
//    }
    
    public Cliente BuscarCliente(ArrayList<Cliente> ArrayClientes, String Cedula){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cliente objAux = new Cliente();
        for (Cliente objCli : ArrayClientes) // RECORRER EL ARRAYLIST
            if (objCli.getCedula().equals(Cedula)) //PREGUNTAR POR CADA OBJETO
                objAux=objCli;
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
}
