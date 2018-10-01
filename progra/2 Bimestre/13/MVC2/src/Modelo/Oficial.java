package Modelo;

import java.util.*;

/**
 *
 */
public class Oficial extends Persona {

    public int Sucursal;
    public int idOficial;

    public Oficial() {
    }

    public Oficial(int Sucursal, String Cedula, String Nombres, String Apellidos) {
        super(Cedula, Nombres, Apellidos);
        this.Sucursal = Sucursal;
    }

    public void setSucursal(int Sucursal) {
        this.Sucursal = Sucursal;
    }

    public int getIdOficial() {
        return idOficial;
    }

    public void setIdOficial(int idOficial) {
        this.idOficial = idOficial;
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

    public int getSucursal() {
        return Sucursal;
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

}
