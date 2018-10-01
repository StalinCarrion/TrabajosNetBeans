/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.item;
import Data.DataItem;
import java.util.ArrayList;

/**
 *
 * @author FRANZ
 */
public class LogicaItem {
    public ArrayList<item> BuscarItems() {
        DataItem ObjDatItem = new DataItem();
        return ObjDatItem.BuscarItems();        
    }
    public void EliminarItem(int cod){
        DataItem ObjDatItem = new DataItem();
        ObjDatItem.EliminarItem(cod);
    }
}
