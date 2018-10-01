
package Logica;

import Clases.Cliente;
import Clases.Cuenta;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author STALIN
 */
public class ImpCuentas {
    public static ArrayList<Cuenta> ImportarCuentas() {
        ArrayList<Cuenta> ArrayCuentas = new ArrayList<Cuenta>();
        File f = new File("Archivos/cuentas.txt");
        ManCliente objManCliente = new ManCliente();
        ImpCliente objImpCliente = new ImpCliente();
        ArrayList<Cliente> ArrayCliente = new ArrayList<Cliente>();
        StringTokenizer st;
        Scanner entrada = null;
        String aNCedula;
        String sCadena;
        try {
            ArrayCliente = objImpCliente.ImportarClientes();
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                       aNCedula = st.nextToken();
//                    Depositante objTmpCli = new Depositante(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    Cuenta objTmpCuenta = new Cuenta(objManCliente.BuscarCliente(ArrayCliente, aNCedula), st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayCuentas.add(objTmpCuenta);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayCuentas;
    }

    public static void GuardarArchivoCuentas(ArrayList<Cuenta> ArrayCuentas) throws FileNotFoundException, IOException {
        File f = new File("Archivos/cuentas.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cuenta objCuenta : ArrayCuentas) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            
            bw.write(objCuenta.getCliente().getCedula()+ ",");
            bw.write(objCuenta.getTipoCuenta()+ ",");
            bw.write(objCuenta.getSaldo()+ ",");
            bw.write(objCuenta.getNCuenta()+ "\n");
        }
        bw.close();
        fw.close();
    }
    
    
}
