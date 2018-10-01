package Logica;

import Clases.Depositante;
import Clases.PersonaCuenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Salas
 */
public class ManPersonaCuenta {

    public PersonaCuenta CrearPersonaCuenta(String nombre, String apellido, String nCuenta, String saldo, String activo, String cedula) {
        PersonaCuenta objPersonaCuenta = new PersonaCuenta(nombre, apellido, nCuenta, saldo, activo, cedula);
        return objPersonaCuenta;
    }

    public PersonaCuenta BuscarPersonaCedula2(ArrayList<PersonaCuenta> ArraypersonaCuenta1, String nCedula) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            String strCe = objperso.getCedula().trim();
            if (strCe.equals(nCedula.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objperso;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public String BuscarPersonaCuentaCedula(ArrayList<PersonaCuenta> ArrayPersonaCuenta, String nCedula) {
        String nC = "0";
// LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objPesonaCuenta : ArrayPersonaCuenta) {// RECORRER EL ARRAYLIST
            //String strCe = objPesonaCuenta.getnCuenta().trim(); 
            if (objPesonaCuenta.getCedula().equals(nCedula)) { //PREGUNTAR POR CADA OBJETO
                objAux = objPesonaCuenta;
                nC = "1";
            }

        }
        return nC; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public String BuscarPersonaCuenta(ArrayList<PersonaCuenta> ArrayPersonaCuenta, String nCuenta) {
        String nC = "0";
// LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objPesonaCuenta : ArrayPersonaCuenta) {// RECORRER EL ARRAYLIST
            //String strCe = objPesonaCuenta.getnCuenta().trim(); 
            if (objPesonaCuenta.getnCuenta().equals(nCuenta)) { //PREGUNTAR POR CADA OBJETO
                objAux = objPesonaCuenta;
                nC = "1";
            }

        }
        return nC; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public PersonaCuenta BuscarPERsonaCuenta(ArrayList<PersonaCuenta> ArraypersonaCuenta1, String nCuenta) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim();
            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objperso;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public PersonaCuenta devolverNCuenta(ArrayList<PersonaCuenta> ArraypersonaCuenta1, String nCuenta) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim();
            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
            {
                objAux = objperso;
            }
        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public void ActualizarSaldo(ArrayList<PersonaCuenta> ArraypersonaCuenta1, int DineroDepositdado, String nCuenta) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        int saldo = 0;
        int saldoActual = 0;
        String saldoA = "";
        String dineroCuentaActualizado = "";
        //PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            //objAux = objperso;
            String strCe = objperso.getnCuenta().trim();

            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
            {
                saldo = Integer.parseInt(objperso.getSaldo().trim());
                saldoActual = saldo + DineroDepositdado;
                saldoA = String.valueOf(saldoActual);
                objperso.setSaldo(saldoA);

            }
            //objAux = objperso;
        }

        // return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public PersonaCuenta ActualizarSaldoRetiro(ArrayList<PersonaCuenta> ArraypersonaCuenta1, int DineroRetirar, String nCuenta) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        int saldo = 0;
        int saldoActual = 0;
        String saldoA = "";
        String dineroCuentaActualizado = "";
        PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim();
            String strTipoC = objperso.getActivo().trim();

            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
            {
                saldo = Integer.parseInt(objperso.getSaldo().trim());
            }

            if (strTipoC.equals("1") && saldo <= 50) {
                saldoActual = saldo;

            }
            if (strTipoC.equals("1") && saldo > 50) {
                saldoActual = saldo - DineroRetirar;
            }
            if (strTipoC.equals("0") && saldo <= 20) {
                saldoActual = saldo;
            }
            if (strTipoC.equals("0") && saldo > 20) {
                saldoActual = saldo - DineroRetirar;
            }

            saldoA = String.valueOf(saldoActual);
            objperso.setSaldo(saldoA);
            objAux = objperso;

        }
        return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    public void ActualizarSaldoRetiro2(ArrayList<PersonaCuenta> ArraypersonaCuenta1, int DineroRetirar, String nCuenta) {
        // LOS PARAMETROS SON EL ARRAY CON LOS CLIENTES Y UNA CEDULA PARA BUSCAR EL CLIENTE
        int saldo = 0;
        int saldoActual = 0;
        int saldoP=0;
        String saldoA = "";
        String dineroCuentaActualizado = "";
        //PersonaCuenta objAux = new PersonaCuenta();
        for (PersonaCuenta objperso : ArraypersonaCuenta1) {// RECORRER EL ARRAYLIST
            String strCe = objperso.getnCuenta().trim();
            String strTipoC = objperso.getActivo().trim();

            if (strCe.equals(nCuenta.trim())) //PREGUNTAR POR CADA OBJETO
            {
                saldo = Integer.parseInt(objperso.getSaldo().trim());
                saldoP = saldo - DineroRetirar;

                if (strTipoC.equals("1") && saldoP < 50) {
                    saldoActual = saldo;

                }
                if (strTipoC.equals("1") && saldoP >= 50) {
                    saldoActual = saldo - DineroRetirar;
                }
                if (strTipoC.equals("0") && saldoP < 20) {
                    saldoActual = saldo;
                }
                if (strTipoC.equals("0") && saldoP >= 20) {
                    saldoActual = saldo - DineroRetirar;
                }
                saldoA = String.valueOf(saldoActual);
                objperso.setSaldo(saldoA);
            }

            //objAux = objperso;
        }
        //return objAux; //RETORNARA UN objeto VACIO EN EL CASO DE NO EXISTIR
    }

    //public PersonaCuenta depositar()
}
