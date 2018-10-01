package Logica;

import Clases.Chip;
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
public class ImportarChip {

    public static ArrayList<Chip> ImportarChips() {
        // PARA CARGAR LOS ARRAYS DE PAQUETES Y CLIENTES DESDE UN ARCHIVO TEXTO,
        // PARA ESTE EJEMPLO TENEMOS UN SOLO ARCHIVO, SE PUEDE TENER LOS QUE UDS. QUIERAN
        // PREFERIBLE SEPARAR POR CLASES
        ArrayList<Chip> ArrayChips = new ArrayList<Chip>();
        File f = new File("Archivos/chips.txt");
        ManCliente objManCliente = new ManCliente();
        ImportarCliente objImpCli = new ImportarCliente();
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        String aNumero;
        int aActivo;
        int aSaldo;
        int aMegas;
        String aCedula;
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            ArrayClientes = objImpCli.ImportarClientes();
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    aNumero = st.nextToken();
                    aActivo = Integer.parseInt(st.nextToken());
                    aSaldo = Integer.parseInt(st.nextToken());
                    aMegas = Integer.parseInt(st.nextToken());
                    aCedula = st.nextToken();

                    Chip objTmpChip = new Chip(aNumero, aActivo, aSaldo, aMegas, objManCliente.BuscarCliente(ArrayClientes, aCedula));
                    ArrayChips.add(objTmpChip);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayChips;
    }

    public static void GuardaArchivoChips(ArrayList<Chip> ArrayChips) throws FileNotFoundException, IOException {
        // SE DEBE MANTENER LA MISMA ESTRUCTURA DEL ARCHIVO DE ENTRADA PARA QUE FUNCIONE
        // LO DEBEN COMPLETAR UDS.
        File f = new File("Archivos/chips1.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Chip objChip : ArrayChips) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objChip.getNumero() + ",");
            bw.write(objChip.getActivo() + ",");
            bw.write(objChip.getSaldo() + ",");
            bw.write(objChip.getMegas() + ",");
            bw.write(objChip.getCliente().getCedula() + ",");

        }
        bw.close();
        fw.close();
    }

}
