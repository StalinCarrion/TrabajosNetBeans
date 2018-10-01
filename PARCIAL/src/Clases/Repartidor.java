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
public class Repartidor extends Persona {
    public String sector;

    public Repartidor(String sector, String cedula, String nombres, String apellidos) {
        super(cedula, nombres, apellidos);
        this.sector = sector;
    }
    
    
}
