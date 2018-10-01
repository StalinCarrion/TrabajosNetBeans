/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Oficial;
import Data.DataOficial;

/**
 *
 * @author UTPL
 */
public class LogicaOficial {
    static DataOficial ObjDatOfi = new DataOficial();
    public static Oficial OficialCuenta (String NumCue){
        Oficial ObjOfi = new Oficial();
        ObjOfi = ObjDatOfi.BuscarOficialCuenta(NumCue);
        return ObjOfi;
    }
}