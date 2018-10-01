/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semana14;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STALIN
 */

class hilo extends Thread{
    String nombre;
    int retardo;
    int lim;

    public hilo() {
    }

    public hilo(String nombre, int retardo, int lim) {
        this.nombre = nombre;
        this.retardo = retardo;
        this.lim = lim;
    }
    
    @Override
    public void run(){
        try {
            sleep(retardo);
        } catch (InterruptedException ex) {
            Logger.getLogger(hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i < lim; i++) {
            System.out.println(nombre);
            
        }
        System.out.println(nombre);
    }
}
public class Hilos {
    public static void main(String[] args) {
        hilo h1 = new hilo("danilo",(int)Math.random()*1000,5);
        hilo h2 = new hilo("juan",(int)Math.random()*1000, 10);
        
        h1.start();
        h2.start();
        
    }
    
}
