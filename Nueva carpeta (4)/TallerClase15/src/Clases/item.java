/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author FRANZ
 */
public class item {
    String Codigo;
    String Descripcion;
    double p_vent;
    double p_comp;
    int cant;
    Date fecha;

    public item() {
    }

    public item(String Codigo, String Descripcion, double p_vent, double p_comp, int cant, Date fecha) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.p_vent = p_vent;
        this.p_comp = p_comp;
        this.cant = cant;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getP_vent() {
        return p_vent;
    }

    public void setP_vent(double p_vent) {
        this.p_vent = p_vent;
    }

    public double getP_comp() {
        return p_comp;
    }

    public void setP_comp(double p_comp) {
        this.p_comp = p_comp;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
