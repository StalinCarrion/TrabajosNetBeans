/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Clases.Libro;
import Logica.ManLibro;

/**
 *
 * @author STALIN
 */
public class EjemploNiveles {
    public static void main(String[] args) {
        // TODO code application logic here
        Libro objLib = new Libro();
        String codigo= "2";
        String nombre = "programacion avanzada";
        String tipo = "Libro";
        
        ManLibro objManLib = new ManLibro();
        
        System.out.println("UNO");
        objManLib.CrearLibro(objLib,codigo, nombre, tipo);
        System.out.println(objLib.toString());
        

     
        
        objLib = objManLib.CrearLibro1(codigo, nombre, tipo);      
        System.out.println("DOS  "+objLib.toString());
        
        objLib = objManLib.CrearLibro2(codigo, nombre, tipo);      
        System.out.println("TRES  "+objLib.toString());
    }
}
