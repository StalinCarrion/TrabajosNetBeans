/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import Clases.Estado;
import Clases.Paquete;
import java.util.Date;

/**
 *
 * @author STALIN
 */
public class MatenimientoPaquete {
    public Paquete CrearPaquete(String codigo, String descripcion, Double peso, Cliente cliente, String estado, String fecha, String observacion){
        
        Paquete objPaquete = new Paquete(codigo, descripcion, peso, cliente, estado, fecha, observacion);
        return objPaquete;
        
    }
    
    public Paquete ActualizarEstado(Paquete objPaquete,int indicador, String observacion, String fecha) {
        
        objPaquete.ActualizarEstado(indicador, observacion, fecha);
        return objPaquete;
        
    }
    
}
