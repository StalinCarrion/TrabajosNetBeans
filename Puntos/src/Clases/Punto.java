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
public class Punto {
    public int x;
    public int y;

    public Punto() {
    }
    
    

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    public double CalcularDistancia(Punto objPunto){
        
        return ((x+objPunto.getX())+(y+objPunto.getY()));
    }
    
}
