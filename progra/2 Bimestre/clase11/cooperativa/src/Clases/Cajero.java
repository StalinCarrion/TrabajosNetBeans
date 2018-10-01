package Clases;

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
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setCaja(int Caja) {
        this.Caja = Caja;
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