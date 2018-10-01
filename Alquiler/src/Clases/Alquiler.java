
package Clases;

import java.util.Date;

/**
 *
 * @author STALIN
 */
public class Alquiler {
    public Cliente clienteAlquiler;
    public Producto productoAlquiler;
    public Date fechaAlquiler;
    public Date fechaEntrega;
    public boolean alquilado;
    //Asociacion
    public Alquiler(Cliente clienteAlquiler, Producto productoAlquiler, Date fechaAlquiler, Date fechaEntrega, boolean alquilado) {
        this.clienteAlquiler = clienteAlquiler;
        this.productoAlquiler = productoAlquiler;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.alquilado = alquilado;
    }
    
    
    
    
}
