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
public class Triangulo {
    
     public Punto p1;
    public Punto p2;
    public Punto p3;

    public Triangulo() {
    }

    public Triangulo(Punto p1, Punto p2, Punto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double calcularArea(){
        double Area=0;
        double base = this.p1.CalcularDistancia(p2);
        double altura =  this.p2.CalcularDistancia(p3);
        Area = base * altura / 2;
        return Area;
    }
}
