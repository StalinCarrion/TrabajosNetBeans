package Modelo;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;




/**
 * 
 */
public class CuentaAutorizada {

    private Date FechaAutorizacion;
    public Cuenta cuentas;
    public Cliente clientes;
    public int idCuentaAutorizada;

    public int getIdCuentaAutorizada() {
        return idCuentaAutorizada;
    }

    public void setIdCuentaAutorizada(int idCuentaAutorizada) {
        this.idCuentaAutorizada = idCuentaAutorizada;
    }
    
    
    
    

   
    
    

    public CuentaAutorizada() {
    }

    public Date getFechaAutorizacion() {
        return FechaAutorizacion;
    }

    public void setFechaAutorizacion(Date FechaAutorizacion) {
        this.FechaAutorizacion = FechaAutorizacion;
    }

    public Cuenta getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta cuentas) {
        this.cuentas = cuentas;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    
    


}