/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Libro;

/**
 *
 * @author STALIN
 */
public class ManLibro {

    public void CrearLibro(String codigo, String nombre, String tipo) {
        Libro objLib = new Libro(codigo, nombre, tipo);

    }

    public void CrearLibro(Libro objLib, String codigo, String nombre, String tipo) {
        Libro objLib1 = new Libro(codigo, nombre, tipo);

        objLib = objLib1;
        System.out.println("EN MAN" + objLib.toString());
    }

    public Libro CrearLibro1(String codigo, String nombre, String tipo) {
        Libro objLib = new Libro(codigo, nombre, tipo);
        return objLib;
    }

    public Libro CrearLibro2(String codigo, String nombre, String tipo) {

        return new Libro(codigo, nombre, tipo);
    }
}
