
package Clases;

import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class Pelicula  extends Producto{
    
    public int Duracion;
    public String idioma;
    public GeneroPelicula genero;
    
    //composicion

    public Pelicula(int Duracion, String idioma, ArrayList nombre) {
        this.Duracion = Duracion;
        this.idioma = idioma;
        this.genero = new GeneroPelicula(nombre);
    }
    
}
