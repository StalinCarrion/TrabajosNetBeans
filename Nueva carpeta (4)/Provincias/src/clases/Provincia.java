/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Avδρέας
 */
public class Provincia {
    int idPro;
    String provincia;
    public Provincia() {
    }

    public Provincia(int idPro, String provincia) {
        this.idPro = idPro;
        this.provincia = provincia;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return  provincia ;
    }
    
    
}
