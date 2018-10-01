/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import clases.Canton;
import clases.Provincia;
import data.Data_Consulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avδρέας
 */
public class LogConsulta {

    public ArrayList<Provincia> ObtenerProvincia() throws ClassNotFoundException, SQLException {
        ArrayList<Provincia> listaProvincia = new ArrayList<>();
        Data_Consulta objCons = new Data_Consulta();
        ResultSet rs = objCons.ObtenerProvincia();
        while (rs.next()) {
            
            Provincia objPro = new Provincia(rs.getInt(1), rs.getString(2));//primera forma
            listaProvincia.add(objPro);
        }
        return listaProvincia;
    }

    public ArrayList<Canton> ObtenerCanton(Provincia objPro) throws ClassNotFoundException, SQLException {
        ArrayList<Canton> listaCanton = new ArrayList<>();
        Data_Consulta objDataCant = new Data_Consulta();
        ResultSet rs = objDataCant.ObtenerCanton(objPro);
        while(rs.next()){
            
            Canton objCant = new Canton(rs.getInt("idCanton"), rs.getString("Nombre"),new Provincia(rs.getInt("idProvincia"),""));//segunda formas se puede con el nombre
            listaCanton.add(objCant);
        }
        return listaCanton;
    }
}
