/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import Clases.Oficial;
import Data.DataClientes;
import Data.DataOficial;
import java.util.ArrayList;

/**
 *
 * @author UTPL
 */
public class LogicaClientes {
    static DataClientes ObjDatCli = new DataClientes();
    static DataOficial ObjDatOfi = new DataOficial();
    public static ArrayList<Cliente> ClientesCuenta (String NumCue){
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        ArrayClientes = ObjDatCli.ClientesCuenta(NumCue);
        return ArrayClientes;
    }
    
    public static Cliente ClientesCuentaAutorizado (String NumCue){
        Cliente ObjCli = new Cliente();
        ObjCli = ObjDatCli.ClientesCuentaAutorizado(NumCue);
        return ObjCli;
    }

    public static Oficial ClientesCuentaOficial(String NumCue) {
        Oficial ObjOfi = new Oficial();
        ObjOfi = ObjDatOfi.BuscarOficialCuenta(NumCue);
        return ObjOfi;
    }        
                    
                    }

