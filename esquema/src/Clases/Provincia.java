package Clases;

/**
 *
 * @author STALIN
 */
public class Provincia {

    public int idProvincia;
    public String nombre;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }


    public Provincia(int idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }
    

    public Provincia() {
    }

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre ;
    }

}
