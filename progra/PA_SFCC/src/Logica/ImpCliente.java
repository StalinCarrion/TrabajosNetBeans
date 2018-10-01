/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Cliente;
import Clases.PersonaCuenta;
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
 * @author Salas
 */
public class ImpCliente {

    public static ArrayList<Cliente> ImportarClientes() {
        ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
        File f = new File("Archivos/clientes.txt");
        ManPersonaCuenta objManPersonaCuenta = new ManPersonaCuenta();
        ImpPersonaCuenta objImpPersonaCuenta = new ImpPersonaCuenta();
        ArrayList<PersonaCuenta> ArrayPersonasCuentas = new ArrayList<PersonaCuenta>();
        String aNombre;
        String aApellido;
        String aCedula;
        String aDinero;
        String aNCuenta;

        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            ArrayPersonasCuentas = objImpPersonaCuenta.ImportarPersonaCuentas();
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    aNombre = st.nextToken();
                    aApellido = st.nextToken();
                    aCedula = st.nextToken();
                    aDinero = st.nextToken();
                    aNCuenta = st.nextToken();
//                    Cliente objTmpCli = new Cliente(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    Cliente objTmpCli = new Cliente(aNombre, aApellido, aCedula, aDinero, objManPersonaCuenta.BuscarPERsonaCuenta(ArrayPersonasCuentas, aNCuenta));
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
        File f = new File("Archivos/clientes1.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cliente objCli : ArrayClientes) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            
            bw.write(objCli.getNombre()+ ",");
            bw.write(objCli.getApellido()+ ",");
            bw.write(objCli.getCedula()+ ",");
            bw.write(objCli.getDinero()+ ",");
            bw.write(objCli.getPersonaCuenta().getnCuenta()+ "\n");
        }
        bw.close();
        fw.close();
    }

}
