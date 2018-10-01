
package Interfaz;

import Clases.Chip;
import Clases.Cliente;
import Logica.ImportarChip;
import Logica.ImportarCliente;
import java.util.ArrayList;

/**
 *
 * @author STALIN
 */
public class Recargas {
    public static void main(String[] args) {
        ImportarCliente objImpCli = new ImportarCliente();
        ImportarChip objImpChip = new ImportarChip();
        ArrayList<Chip> ArrayChips = new ArrayList<Chip>();
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        
        ArrayClientes= objImpCli.ImportarClientes();
        ArrayChips = objImpChip.ImportarChips();
        System.out.println("wait");
    }
}
