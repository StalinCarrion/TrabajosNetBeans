/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import Clases.AnioLectivo;
import Clases.Grado;
import Data.DataGrado;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class logicaGrado {
    DataGrado objDataGrado = new DataGrado();
    public ArrayList<Grado> ListarGrados(AnioLectivo objAnioLectivo){
        ArrayList<Grado> arrayListGrados = new ArrayList<Grado>();
        arrayListGrados = objDataGrado.ListarGrados(objAnioLectivo);
        return arrayListGrados;   
    }
    
}
