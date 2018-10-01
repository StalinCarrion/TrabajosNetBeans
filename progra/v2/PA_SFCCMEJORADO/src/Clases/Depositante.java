/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Salas
 */
public class Depositante {
    String nombre;
    String apellido;
    String cedula;
    String dinero;
    PersonaCuenta personaCuenta;

    public Depositante() {
    }

    public Depositante(String nombre, String apellido, String cedula, String dinero, PersonaCuenta personaCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.dinero = dinero;
        this.personaCuenta = personaCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDinero() {
        return dinero;
    }

    public void setDinero(String dinero) {
        this.dinero = dinero;
    }

    public PersonaCuenta getPersonaCuenta() {
        return personaCuenta;
    }

    public void setPersonaCuenta(PersonaCuenta personaCuenta) {
        this.personaCuenta = personaCuenta;
    }

    
}
