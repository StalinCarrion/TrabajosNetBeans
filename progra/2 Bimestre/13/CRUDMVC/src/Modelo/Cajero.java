package Modelo;

import java.util.*;

public class Cajero extends Persona {
    public int Caja;
    public Cajero() {
    }

    public Cajero(int Caja, String Cedula, String Nombres, String Apellidos) {
        super(Cedula, Nombres, Apellidos);
        this.Caja = Caja;
    }

    public int getCaja() {
        return Caja;
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

    public void setCaja(int Caja) {
        this.Caja = Caja;
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