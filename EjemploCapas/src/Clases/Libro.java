/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author STALIN
 */
public class Libro {

    public String codigo;
    public String nombre;
    public String tipo;

    public Libro() {
    }

    public Libro(String codigo, String nombre, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + '}';
    }
        
}
