/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Depositante;
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
public class ImpPersonaCuenta {
    public static ArrayList<PersonaCuenta> ImportarPersonaCuentas(){   
        ArrayList<PersonaCuenta> ArrayPersonaCuentas = new ArrayList<PersonaCuenta>();
        File f = new File("Archivos/personaCuenta.txt");    
        
        StringTokenizer st;
        
        Scanner entrada = null;
        String sCadena;
        
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {            
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()){
                    
                    PersonaCuenta objTmpPerCueta = new PersonaCuenta(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
                    ArrayPersonaCuentas.add(objTmpPerCueta);
                }
            }                      
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
        return ArrayPersonaCuentas;
    }    
         
    public static void GuardaArchivoPersonaCuenta(ArrayList<PersonaCuenta> ArrayPersonaCuentas) throws FileNotFoundException, IOException{
        File f = new File("Archivos/personaCuenta.txt");
        FileWriter fw = new FileWriter(f,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (PersonaCuenta objPersonaCuenta : ArrayPersonaCuentas) { //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objPersonaCuenta.getNombre()+",");
            bw.write(objPersonaCuenta.getApellido()+",");
            bw.write(objPersonaCuenta.getnCuenta()+",");
            bw.write(objPersonaCuenta.getSaldo()+",");
            bw.write(objPersonaCuenta.getActivo()+",");
            bw.write(objPersonaCuenta.getCedula()+"\n");
        }
        bw.close();
        fw.close();
    }
    
}
