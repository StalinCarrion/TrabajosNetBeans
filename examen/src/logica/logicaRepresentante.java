/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Estudiante;
import Clases.Representante;
import Data.DataRepresentante;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class logicaRepresentante {
    DataRepresentante objDataRepresentante = new DataRepresentante();
    public ArrayList<Representante> ListarRepresentante(){
        ArrayList<Representante> arrayListRepresentantes = new ArrayList<Representante>();
        arrayListRepresentantes = objDataRepresentante.ListarRepresentante();
        return arrayListRepresentantes;
    }
    public ArrayList<Estudiante> ListarEstudiantes(Representante objRepresentante){
        ArrayList<Estudiante> arrayListEstudiantes = new ArrayList<Estudiante>();
        arrayListEstudiantes = objDataRepresentante.ListarEstudiantes(objRepresentante);
        return arrayListEstudiantes;   
    }
}
