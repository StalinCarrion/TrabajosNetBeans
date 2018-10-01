
package DAT;

public class vCliente extends vPersona {
    private String strCodigo_cliente;

    public vCliente() {
    }

    public vCliente(String strCodigo_cliente) {
        this.strCodigo_cliente = strCodigo_cliente;
    }

    public String getStrCodigo_cliente() {
        return strCodigo_cliente;
    }

    public void setStrCodigo_cliente(String strCodigo_cliente) {
        this.strCodigo_cliente = strCodigo_cliente;
    }   
}
