/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cajero;
import Modelo.DataCajero;

/**
 *
 * @author UTPL
 */
public class CrtCajero {
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
