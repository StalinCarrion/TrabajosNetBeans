package Modelo;

import java.util.*;

/**
 *
 */
public class Cuenta {

    public int idCuenta;
    public int idOficial;
    public String Numero;
    public int Tipo;
    public double saldo;
    public ArrayList<Cliente> clientes;
    public Cliente Autorizado;
    public Oficial oficial;
    public int idCuentaAutorizada;

    public int getIdCuentaAutorizada() {
        return idCuentaAutorizada;
    }

    public void setIdCuentaAutorizada(int idCuentaAutorizada) {
        this.idCuentaAutorizada = idCuentaAutorizada;
    }
    
    

    public Cuenta() {
    }

    public void HacerAutorizado() {
        // TODO implement here
    }

//    public Cuenta(int idCuenta, String Numero, int Tipo, double saldo, ArrayList<Cliente> clientes, Cliente Autorizado, Oficial oficial) {
//        this.idCuenta = idCuenta;
//        this.Numero = Numero;
//        this.Tipo = Tipo;
//        this.saldo = saldo;
//        this.clientes = clientes;
//        this.Autorizado = Autorizado;
//        this.oficial = oficial;
//    }
    public Cuenta(String Numero,int Tipo,double saldo){

        this.Numero = Numero;
        this.Tipo = Tipo;
        this.saldo = saldo;
    }
    
    public Cuenta(String Numero, int Tipo, double saldo, Oficial oficial) {
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.saldo = saldo;
        this.oficial = oficial;
    }

    public int getIdOficial() {
        return idOficial;
    }

    public void setIdOficial(int idOficial) {
        this.idOficial = idOficial;
    }
    

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getAutorizado() {
        return Autorizado;
    }

    public void setAutorizado(Cliente Autorizado) {
        this.Autorizado = Autorizado;
    }

    public Oficial getOficial() {
        return oficial;
    }

    public void setOficial(Oficial oficial) {
        this.oficial = oficial;
    }

}
