package Clases;

/**
 *
 * @author Salas
 */
public class Persona {

    String nombres;
    int cedula;

    public Persona() {
    }

    public Persona(String nombres, int cedula) {
        this.nombres = nombres;
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", cedula=" + cedula + '}';
    }

}
