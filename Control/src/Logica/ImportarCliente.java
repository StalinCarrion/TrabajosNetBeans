package Logica;

import Clases.Cliente;
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
public class ImportarCliente {

    public static ArrayList<Cliente> ImportarClientes() {
        // PARA CARGAR LOS ARRAYS DE PAQUETES Y CLIENTES DESDE UN ARCHIVO TEXTO,
        // PARA ESTE EJEMPLO TENEMOS UN SOLO ARCHIVO, SE PUEDE TENER LOS QUE UDS. QUIERAN
        // PREFERIBLE SEPARAR POR CLASES
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        File f = new File("Archivos/clientes.txt");
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    Cliente objTmpCli = new Cliente(st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayClientes.add(objTmpCli);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayClientes;
    }

    public static void GuardaArchivoCliente(ArrayList<Cliente> ArrayClientes) throws FileNotFoundException, IOException {
        // SE DEBE MANTENER LA MISMA ESTRUCTURA DEL ARCHIVO DE ENTRADA PARA QUE FUNCIONE
        // LO DEBEN COMPLETAR UDS.
        File f = new File("Archivos/clientes1.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cliente objCli : ArrayClientes) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objCli.getCedula() + ",");
            bw.write(objCli.getNombres() + ",");
            bw.write(objCli.getApellidos() + ",");

        }
        bw.close();
        fw.close();
    }

}
