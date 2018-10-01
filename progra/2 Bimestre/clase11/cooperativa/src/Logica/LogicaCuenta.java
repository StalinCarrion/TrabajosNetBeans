/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cajero;
import Clases.Cuenta;
import Data.DataCajero;
import Data.DataCuenta;
import java.sql.SQLException;

/**
 *
 * @author UTPL
 */
public class LogicaCuenta {

    DataCuenta ObjDatCue = new DataCuenta();
    Cuenta ObjCue = new Cuenta();

    public Cuenta BuscarCuenta(String NumCue) {
        Cuenta ObjCue = new Cuenta();
        ObjCue.setNumero(NumCue);
        ObjCue = ObjDatCue.BuscarCuenta(ObjCue);
        if (ObjCue.getTipo() != 0) {
            // si hay cuenta, se deben llenar los clientes propietarios
            ObjCue.setClientes(LogicaClientes.ClientesCuenta(ObjCue.getNumero()));
            // se debe llenar el cliente autorizado
            ObjCue.setAutorizado(LogicaClientes.ClientesCuentaAutorizado(ObjCue.getNumero()));
            // se debe llenar el oficial
            ObjCue.setOficial(LogicaOficial.OficialCuenta(ObjCue.getNumero()));
            ObjCue.setSaldo(ObjCue.getSaldo());
        }
        return ObjCue;
    }

    public int Modificar(String nuevoSaldo, String NCuenta) throws ClassNotFoundException, SQLException {
        int a = 1;
        System.out.println("que hayy: " + ObjDatCue.Modificar(nuevoSaldo, NCuenta));
        return ObjDatCue.Modificar(nuevoSaldo, NCuenta);

    }
}
