package Clases;

import java.util.*;

/**
 * 
 */
public class Oficial extends Persona {
    public int Sucursal;
    public  Oficial() {
    }

    public Oficial(int Sucursal, String Cedula, String Nombres, String Apellidos) {
        super(Cedula, Nombres, Apellidos);
        this.Sucursal = Sucursal;
    }

    public void setSucursal(int Sucursal) {
        this.Sucursal = Sucursal;
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

    public int getSucursal() {
        return Sucursal;
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

    

}