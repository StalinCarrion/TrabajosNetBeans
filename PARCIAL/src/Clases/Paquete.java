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
public class Paquete {

    public String codigo;
    public String descripcion;
    public Double peso;
    Cliente cliente;
    Estado[] estados = new Estado[4];

    public Paquete() {
    }

    public Paquete(String codigo, String descripcion, Double peso, Cliente cliente, String estado, String fecha, String observacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.cliente = cliente;
        this.estados[0] = new Estado("Registrado", "fecha", "llego");
        this.estados[1] = new Estado("Almacenado", fecha, "llego");
        this.estados[2] = new Estado("Despachado", fecha, "llego");
        this.estados[3] = new Estado("Entregado", fecha, "llego");
    }

    public void ActualizarEstado(int indicador, String observacion, String fecha) {
        estados[indicador].observacion = observacion;
        estados[indicador].fecha = fecha;
    }
    
    
    @Override
    public String toString() {
        return "Paquete{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", peso=" + peso + ", cliente=" + cliente + ", estados=" + estados + '}';
    }
    
    
    
}
