
package Clases;

/**
 *
 * @author STALIN
 */
public class Recarga {
    String fecha;
    int monto;
    int p_saldo;
    int p_megas;
    Chip chip;

    public Recarga() {
    }

    public Recarga(String fecha, int monto, int p_saldo, int p_megas, Chip chip) {
        this.fecha = fecha;
        this.monto = monto;
        this.p_saldo = p_saldo;
        this.p_megas = p_megas;
        this.chip = chip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getP_saldo() {
        return p_saldo;
    }

    public void setP_saldo(int p_saldo) {
        this.p_saldo = p_saldo;
    }

    public int getP_megas() {
        return p_megas;
    }

    public void setP_megas(int p_megas) {
        this.p_megas = p_megas;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    @Override
    public String toString() {
        return "Recarga{" + "fecha=" + fecha + ", monto=" + monto + ", p_saldo=" + p_saldo + ", p_megas=" + p_megas + ", chip=" + chip + '}';
    }

   
    
}
