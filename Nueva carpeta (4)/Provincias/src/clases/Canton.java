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
public class Canton {
    int idCan;
    String Canton;
    Provincia provincia;
    public Canton() {
    }

    public Canton(int idCan, String Canton, Provincia provincia) {
        this.idCan = idCan;
        this.Canton = Canton;
        this.provincia = provincia;
    }

    public int getIdCan() {
        return idCan;
    }

    public void setIdCan(int idCan) {
        this.idCan = idCan;
    }

    public String getCanton() {
        return Canton;
    }

    public void setCanton(String Canton) {
        this.Canton = Canton;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return  Canton ;
    }
    
}
