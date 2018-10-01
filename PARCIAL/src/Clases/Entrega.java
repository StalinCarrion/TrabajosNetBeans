/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author STALIN
 */
public class Entrega {
    public String Fecha;
    public String observacion;
    public Paquete paquete;
 
    public Entrega(String Fecha, String observacion, Paquete paquete) {
        this.Fecha = Fecha;
        this.observacion = observacion;
        this.paquete = paquete;
       
    }
}
