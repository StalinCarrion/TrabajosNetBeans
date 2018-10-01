package parcial;

import java.util.Date;

/**
 *
 * @author STALIN
 */
class Clases {

    public String mail;
    Direccion direccion;

    public Clases(String mail, String callePrincipal, String calleSecundaria, int numeroCasa, String referencia) {
        this.mail = mail;
        this.direccion = new Direccion(callePrincipal, calleSecundaria, numeroCasa, referencia);
    }

}

class Paquete {

    public String codigo;
    public String descripcion;
    public Double peso;
    Clases cliente;
    Estado estado;

    public Paquete(String codigo, String descripcion, Double peso, Clases cliente, String estado, Date fecha, String observacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.cliente = cliente;
        this.estado = new Estado(estado, fecha, observacion);
    }

}

class Direccion {

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

}

class Entrega {

    public Date Fecha;
    public String observacion;
    Paquete paquete;

    public Entrega(Date Fecha, String observacion, Paquete paquete) {
        this.Fecha = Fecha;
        this.observacion = observacion;
        this.paquete = paquete;
    }

}

class Estado {

    public String estado;
    public Date fecha;
    public String observacion;

    public Estado(String estado, Date fecha, String observacion) {
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
    }

}
