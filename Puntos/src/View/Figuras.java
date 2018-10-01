/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logica.LogTriangulo;
import java.util.Scanner;

public class Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int c1=0, c2=0, c3=0, c4=0, c5=0, c6=0;

        //Entrada
        System.out.println("1 triangulo ");
        System.out.println("2 Circulo");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        if (op == 1) {
            // triangulo
            c1 = 0;
            c2 = 0;

            c3 = 0;
            c4 = 4;

            c5 = 8;
            c6 = 0;

        } else {
            //circulo
        }

        //proceso
        LogTriangulo objLogTriangulo = new LogTriangulo();

        //salida
        System.out.println(objLogTriangulo.CalcularAreaTriangulo(c1, c2, c3, c4, c5, c6));

    }

}
