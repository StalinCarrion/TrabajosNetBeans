/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Canton;
import Clases.Provincia;
import Data.DataConsulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class ManejadorCosulta {

    public ArrayList<Provincia> ObtenerProvincia() throws ClassNotFoundException, SQLException {
        ArrayList<Provincia> listProvincias = new ArrayList<Provincia>();
        DataConsulta objdataConsulta = new DataConsulta();
        ResultSet rs = objdataConsulta.ObtenerProvincia();
        while (rs.next()) {
            //Provincia objProvincia = new Provincia(rs.getString(1), rs.getString(2));
            Provincia objProvincia = new Provincia(rs.getInt(1), rs.getString(2));
            listProvincias.add(objProvincia);
        }
        return listProvincias;
    }

    public ArrayList<Canton> ObtenerCanton(int idProvincia) throws ClassNotFoundException, SQLException {
        ArrayList<Canton> listCanton = new ArrayList<Canton>();
        DataConsulta objCliente = new DataConsulta();
        ResultSet rs = objCliente.ObtenerCanton(idProvincia);
        while (rs.next()) {
            Canton objCanton = new Canton(rs.getInt("idCanton"), rs.getString("nombre"), new Provincia(rs.getInt("idProvincia"), ""));
            listCanton.add(objCanton);
        }
        return listCanton;
    }

}
