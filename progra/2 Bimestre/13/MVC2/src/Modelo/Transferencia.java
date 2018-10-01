package Modelo;

import java.sql.Date;
import java.util.ArrayList;




/**
 * 
 */
public class Transferencia {
    public int Numero;
    public Date Fecha;
    public double valor;
    public String Observacion;
    public ArrayList<Cuenta> cuenta;
    public int idCuentaAutorizada;
    public CuentaAutorizada CuentaAutorizada;
    public int idCuenta;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    

    public int getIdCuentaAutorizada() {
        return idCuentaAutorizada;
    }

    public void setIdCuentaAutorizada(int idCuentaAutorizada) {
        this.idCuentaAutorizada = idCuentaAutorizada;
    }

  
    

    public Transferencia() {
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public ArrayList<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ArrayList<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

   

    public CuentaAutorizada getCuentaAutorizada() {
        return CuentaAutorizada;
    }

    public void setCuentaAutorizada(CuentaAutorizada CuentaAutorizada) {
        this.CuentaAutorizada = CuentaAutorizada;
    }
    
    

}