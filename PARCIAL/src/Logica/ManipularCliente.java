/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import Clases.Direccion;


/**
 *
 * @author STALIN
 */
public class ManipularCliente {

    public Cliente CrearCliente(String mail, String cedula, String nombres, String apellidos,
            String callePrincipal, String calleSecundaria, int numeroCasa, String referencia) {
        
        Cliente objCliente = new Cliente(mail, cedula, nombres, apellidos, 
                callePrincipal, calleSecundaria, numeroCasa, referencia);
        return objCliente;

    }

    public Cliente AgregarDireccion(Cliente objCliente,String callePrincipal, String calleSecundaria, int numeroCasa, String referencia) {
        
        objCliente.AgregarDireccion(callePrincipal, calleSecundaria, numeroCasa, referencia);
        return objCliente;
      

    }
}
