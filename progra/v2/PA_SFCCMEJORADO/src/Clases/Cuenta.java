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
public class Cuenta {
    Cliente cliente;
    String tipoCuenta;
    String saldo;
    String NCuenta;

    public Cuenta() {
    }

    public Cuenta(Cliente cliente, String tipoCuenta, String saldo, String NCuenta) {
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.NCuenta = NCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getNCuenta() {
        return NCuenta;
    }

    public void setNCuenta(String NCuenta) {
        this.NCuenta = NCuenta;
    }
    
    
    
}
