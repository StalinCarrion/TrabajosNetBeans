
package Clases;

import static Clases.VideoClub.videoClub;

/**
 *
 * @author STALIN
 */
public class VideoClub {
    //Asociacion
    public Cliente cliente;
    public Alquiler alquiler;
    public Producto producto;
    static VideoClub  videoClub;

    private VideoClub() {
    }
    
    

    //+Static Instancia():VideoClub
    public static VideoClub getSingletonInstance(){
        return videoClub;
    }
    
    public boolean AgregarCliente(Cliente pCliente){
        return false;
        
    }
    
    public boolean ModificarCliente(Cliente pCliente){
        return false;
    }
    
    public boolean EliminarCliente(int pCodigo){
        return false;
    }
    
    //+MostrarClientes(String pDocumento, String pNombre): DataTable
    public void MostrarClientes(String pDocumento, String pNombre){
        
    }
    
    public Cliente BuscarCliente(int pCodigo){
        return BuscarCliente(pCodigo);
    }
    
    public boolean AgregarJuego(Juego pJuego){
        return AgregarJuego(pJuego);
    }
    public boolean ModificarJuego(Juego pJuego){
        return ModificarJuego(pJuego);
    }
    
    
}
