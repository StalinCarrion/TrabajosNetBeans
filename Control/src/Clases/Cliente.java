
package Clases;

/**
 *
 * @author STALIN
 */
public class Cliente {
    String cedula;
    String nombres;
    String apellidos;

    public Cliente() {
    }

    public Cliente(String cedula, String nombres, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
}
