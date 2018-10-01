package Modelo;

import java.util.*;

/**
 * 
 */
public class Cliente extends Persona {
    public int idCliente;
    public String Direccion;
    public ArrayList<Cuenta> cuenta;
    public Cliente() {
    }

    public Cliente(String Direccion, ArrayList<Cuenta> cuenta) {
        this.Direccion = Direccion;
        this.cuenta = cuenta;
    }

    public Cliente(String Direccion, ArrayList<Cuenta> cuenta, String Cedula, String Nombres, String Apellidos) {
        super(Cedula, Nombres, Apellidos);
        this.Direccion = Direccion;
        this.cuenta = cuenta;
    }

    public Cliente(String Direccion) {
        this.Direccion = Direccion;
    }

    public Cliente(String Direccion, String Cedula, String Nombres, String Apellidos) {
        super(Cedula, Nombres, Apellidos);
        this.Direccion = Direccion;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public ArrayList<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(ArrayList<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }
    

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
    
}