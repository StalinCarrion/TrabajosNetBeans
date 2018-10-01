/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author STALIN
 */
public class Grado {
    
    String descripcion;
    String paralelo;
    String codigo;
    int idGrado;
    AnioLectivo anio;

    public AnioLectivo getAnio() {
        return anio;
    }

    public void setAnio(AnioLectivo anio) {
        this.anio = anio;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
    

    public Grado() {
    }

    public Grado(String descripcion, String paralelo, String codigo) {
        this.descripcion = descripcion;
        this.paralelo = paralelo;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
