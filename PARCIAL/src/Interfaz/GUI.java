/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Cliente;
import Clases.Estado;
import Clases.Paquete;
import Logica.ManipularCliente;
import Logica.MatenimientoPaquete;

/**
 *
 * @author STALIN
 */
public class GUI {

    public static void main(String[] args) {
        Cliente objCliente = new Cliente();
        Paquete objPaquete = new Paquete();

        MatenimientoPaquete objMantenimientoPaquete = new MatenimientoPaquete();
        objPaquete = objMantenimientoPaquete.CrearPaquete("001", "paquete1", 2.25, objCliente, "a", "01/05/18", "esta en buen estado");
        //("001", "paquete1", 2.25, objCliente, estados, "01/05/18", "esta en buen estado");
        //objPaquete = objMantenimientoPaquete.ActualizarEstado(objPaquete, 0, "", "");

        ManipularCliente objManipularCliente = new ManipularCliente();
        objCliente = objManipularCliente.CrearCliente("cliente@utpl.com", "11036", "stalin", "carrion", "18 de noviembre", "Circunvalacion", 10, "al lado de altamarino");
        objCliente = objManipularCliente.AgregarDireccion(objCliente, "18 de Mayo", "Cariamanga", 5, "frente a la pintura");
        System.out.println(objCliente.toString());

        System.out.println(objPaquete.toString());
    }

}
