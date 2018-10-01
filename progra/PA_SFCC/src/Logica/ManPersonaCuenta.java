
package Logica;

import Clases.Cliente;
import Clases.PersonaCuenta;
import java.util.ArrayList;

/**
 *
 * @author Salas
 */
public class ManPersonaCuenta {
    public PersonaCuenta CrearPersonaCuenta(String nombre, String apellido, String nCuenta, String saldo,String activo){
        PersonaCuenta objPersonaCuenta = new PersonaCuenta(nombre, apellido, nCuenta, saldo,activo);
        return objPersonaCuenta;
    }
    
    public String BuscarPersonaCuenta(ArrayList<PersonaCuenta> ArrayPersonaCuenta, String nCuenta){
            String nC="0";
// LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objPesonaCuenta : ArrayPersonaCuenta){// RECORRER EL ARRAYLIST
            //String strCe = objPesonaCuenta.getnCuenta().trim(); 
            if (objPesonaCuenta.getnCuenta().equals(nCuenta)){ //PREGUNTAR POR CADA OBJETO
                objAux=objPesonaCuenta;
            nC = "1";
            }
                
        }
        return nC; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    public PersonaCuenta BuscarPERsonaCuenta(ArrayList<PersonaCuenta> ArraypersonaCuenta1, String nCuenta){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1){// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim(); 
            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
                objAux=objperso;
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    public PersonaCuenta devolverNCuenta(ArrayList<PersonaCuenta> ArraypersonaCuenta1, String nCuenta){
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1){// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim(); 
            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
                objAux=objperso;
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }
    
    
    
    //public PersonaCuenta depositar()
    
}
