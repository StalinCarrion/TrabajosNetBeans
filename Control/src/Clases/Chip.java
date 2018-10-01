package Clases;

/**
 *
 * @author STALIN
 */
public class Chip {

    String numero;
    int activo;
    int saldo;
    int megas;
    Cliente cliente;

    public Chip() {
    }

    public Chip(String numero, int activo, int saldo, int megas, Cliente cliente) {
        this.numero = numero;
        this.activo = activo;
        this.saldo = saldo;
        this.megas = megas;
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getMegas() {
        return megas;
    }

    public void setMegas(int megas) {
        this.megas = megas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Chip{" + "numero=" + numero + ", activo=" + activo + ", saldo=" + saldo + ", megas=" + megas + ", cliente=" + cliente + '}';
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
