/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Punto;
import Clases.Triangulo;

/**
 *
 * @author STALIN
 */
public class LogTriangulo {

    public double CalcularAreaTriangulo(int c1, int c2, int c3, int c4, int c5, int c6) {
        Punto p1 = new Punto(c1, c2);
        Punto p2 = new Punto(c3, c4);
        Punto p3 = new Punto(c5, c6);

        Triangulo objTriangulo = new Triangulo(p1, p2, p3);
        return objTriangulo.calcularArea();
            

    }
}
