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
public class Direccion {
    public String callePrincipal;
    public String calleSecundaria;
    public int numeroCasa;
    public String referencia;

    public Direccion(String callePrincipal, String calleSecundaria, int numeroCasa, String referencia) {
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.numeroCasa = numeroCasa;
        this.referencia = referencia;
    }
    public Direccion(){}

    @Override
    public String toString() {
        return "Direccion{" + "callePrincipal=" + callePrincipal + ", calleSecundaria=" + calleSecundaria + ", numeroCasa=" + numeroCasa + ", referencia=" + referencia + '}';
    }
    
    
}
