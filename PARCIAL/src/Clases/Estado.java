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
public class Estado {
    public String estado;
    public String fecha;
    public String observacion;

    public Estado(String estado, String fecha, String observacion) {
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public Estado() {
    }
    
}
