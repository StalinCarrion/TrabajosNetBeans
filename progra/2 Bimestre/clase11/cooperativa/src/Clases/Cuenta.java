package Clases;


import java.util.*;

/**
 * 
 */
public class Cuenta {
    public String Numero;
    public int Tipo;
    public double saldo;
    public ArrayList<Cliente> clientes;
    public Cliente Autorizado;
    public Oficial oficial;
    
    public Cuenta() {
    }

    public void HacerAutorizado() {
        // TODO implement here
    }

    public Cuenta(String Numero, int Tipo, double saldo) {
        this.Numero = Numero;
        this.Tipo = Tipo;
        this.saldo = saldo;
    }

    public String getNumero() {
        return Numero;
    }

    public int getTipo() {
        return Tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getAutorizado() {
        return Autorizado;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setAutorizado(Cliente Autorizado) {
        this.Autorizado = Autorizado;
    }

    public void setOficial(Oficial oficial) {
        this.oficial = oficial;
    }
    
}