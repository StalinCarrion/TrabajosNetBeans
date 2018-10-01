package Clases;

import java.util.*;

/**
 * 
 */
public class Cliente extends Persona {
    public String Direccion;
    public Cliente() {
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public void setNombres(String Nombres) {
        this.nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.apellidos = Apellidos;
    }
    
}