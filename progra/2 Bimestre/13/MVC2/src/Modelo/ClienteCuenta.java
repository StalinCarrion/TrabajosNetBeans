/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ricardo
 */
public class ClienteCuenta {

    Cuenta Cuenta;
    Cliente Cliente;
    int autorizado;
    int idClienteCuenta;

    public ClienteCuenta() {
    }

    public int getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(int autorizado) {
        this.autorizado = autorizado;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

}
