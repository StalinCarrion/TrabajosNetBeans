/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class Cliente extends Persona {

    public String mail;
    ArrayList<Direccion> direcciones = new ArrayList<Direccion> ();
    public Cliente() {
    }
    
    public Cliente(String mail, ArrayList<Direccion> direcciones) {
        this.mail = mail;
        this.direcciones = direcciones;
    }
    public Cliente(String mail, String cedula, String nombres, String apellidos,
            String callePrincipal, String calleSecundaria, int numeroCasa, String referencia) {
        super(cedula, nombres, apellidos);
        this.mail = mail;
        this.direcciones.add(new Direccion(callePrincipal, calleSecundaria, numeroCasa, referencia));
    }
    public void AgregarDireccion(String callePrincipal, String calleSecundaria, int numeroCasa, String referencia){
        this.direcciones.add(new Direccion(callePrincipal, calleSecundaria, numeroCasa, referencia));
    }

    @Override
    public String toString() {
        return "Cliente{" + "mail=" + mail + ", direcciones=" + direcciones + '}';
    }


}
