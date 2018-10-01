/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Matricula;
import Data.DataMatricula;

/**
 *
 * @author STALIN
 */
public class logicaMatricula {
    DataMatricula objdaDataMatricula = new DataMatricula();
    
    public boolean InsertarMatricula(Matricula objMatricula){
        boolean x = objdaDataMatricula.InsertarMatricula(objMatricula);
        return x;
    }
    
}
