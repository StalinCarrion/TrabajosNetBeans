/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cajero;
import Data.DataCajero;

/**
 *
 * @author UTPL
 */
public class LogicaCajero {
    DataCajero ObjDatCaj = new DataCajero();
    public Cajero BuscarCajero(String Cedula){       
        Cajero ObjCaj = new Cajero();
        ObjCaj.setCedula(Cedula);  
        ObjCaj = ObjDatCaj.BuscarCajero(ObjCaj);
        return ObjCaj;
    }
    
    public boolean InsertarCajero(Cajero ObjCaj){       
        boolean x = ObjDatCaj.InsertarCajero(ObjCaj);
        return x;
    }
}
