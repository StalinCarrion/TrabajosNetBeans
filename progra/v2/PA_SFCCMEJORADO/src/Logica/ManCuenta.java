
package Logica;

import Clases.Cliente;
import Clases.Cuenta;
import Clases.Depositante;
import Clases.PersonaCuenta;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class ManCuenta {
    public Cuenta CrearCuenta(Cliente cliente, String tipoCuenta, String saldo, String NCuenta){
        Cuenta objCuenta = new Cuenta(cliente, tipoCuenta, saldo, NCuenta);
        return objCuenta;
    }
    
    public Cuenta BuscarCuenta(ArrayList<Cuenta> ArrayCuentas, String nCuenta){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        Cuenta objAux = new Cuenta();
        for (Cuenta objCuenta : ArrayCuentas){// RECORRER EL ARRAYLIST
            String strCe = objCuenta.getNCuenta().trim(); 
            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
                objAux=objCuenta;
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    
    
}
