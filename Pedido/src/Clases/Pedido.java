
package Clases;

import java.util.Date;

/**
 *
 * @author STALIN
 */
public class Pedido {
    public Date fecha;
    public String estado;
    //asociacion
    public Pago pago;
    public Cliente cliente;
    public LineaPedido lineaPedido;
    //Agregacion

    public Pedido(Date fecha, String estado, Pago pago, Cliente cliente, LineaPedido lineaPedido) {
        this.fecha = fecha;
        this.estado = estado;
        this.pago = pago;
        this.cliente = cliente;
        this.lineaPedido = lineaPedido;
    }
    
    
    
    public void CalcularIVA(){
        
    }
    
    public void CalcularTotal(){
        
    }
    
}
