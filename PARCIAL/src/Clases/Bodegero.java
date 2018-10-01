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
public class Bodegero extends Persona{
    public String oficina;

    public Bodegero(String oficina, String cedula, String nombres, String apellidos) {
        super(cedula, nombres, apellidos);
        this.oficina = oficina;
    }
    
    
    
}
