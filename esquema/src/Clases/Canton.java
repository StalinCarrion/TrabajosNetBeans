
package Clases;

import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class Canton {
    public String nombre;
    public Provincia provincia;
    public ArrayList<Provincia> provincias;

    public ArrayList<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<Provincia> provincias) {
        this.provincias = provincias;
    }
    
    
    

    public Canton() {
    }

    public Canton(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
    
}
