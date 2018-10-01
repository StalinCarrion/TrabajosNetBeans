package Logica;

import Clases.Cliente;
import Clases.PersonaCuenta;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class ManCliente {

    public Cliente CrearCliente(String cedula, String nombre, String apellido) {
        Cliente objClie = new Cliente(cedula, nombre, apellido);
        return objClie;
    }

    public Cliente BuscarCliente(ArrayList<Cliente> ArrayClientes1, String Cedula) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cliente objAux = new Cliente();
        for (Cliente objCli : ArrayClientes1) {// RECORRER EL ARRAYLIST
            String strCe = objCli.getCedula().trim();
            if (strCe.equals(Cedula.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objCli;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    
    
    public String BuscarClienteString(ArrayList<Cliente> ArrayCliente, String nCedula) {
        String nC = "0";
// LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cliente objAux = new Cliente();
        for (Cliente objCliente : ArrayCliente) {// RECORRER EL ARRAYLIST
            //String strCe = objPesonaCuenta.getnCuenta().trim(); 
            if (objCliente.getCedula().equals(nCedula)) { //PREGUNTAR POR CADA OBJETO
                objAux = objCliente;
                nC = "1";
            }

        }
        return nC; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

}
