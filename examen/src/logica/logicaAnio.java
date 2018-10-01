/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import Clases.AnioLectivo;
import Data.DataAnio;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class logicaAnio {
    DataAnio objDataAnio = new DataAnio();
    public ArrayList<AnioLectivo> ListarAnio(){
        ArrayList<AnioLectivo> arrayListAnioLectivos = new ArrayList<AnioLectivo>();
        arrayListAnioLectivos = objDataAnio.ListarAnio();
        return arrayListAnioLectivos;
    }
}
