/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DATProducto;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo Jaramillo H
 */
public class CrtProducto implements ActionListener {

    private Producto mod;
    private DATProducto modC;
    private frmProducto frm;

    public CrtProducto(Producto mod, DATProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;

        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
    }

    public void Iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio((Double.parseDouble(frm.txtPrecio.getText())));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.Registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
            limpiar();
        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio((Double.parseDouble(frm.txtPrecio.getText())));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.Modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
            limpiar();
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            if (modC.Eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            limpiar();
        }

        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            if (modC.Buscar(mod)) {
                frm.txtID.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(String.valueOf(mod.getCodigo()));
                frm.txtNombre.setText(String.valueOf(mod.getNombre()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                JOptionPane.showMessageDialog(null, "Registro encontrado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
            }
        }

        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtID.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtPrecio.setText(null);

    }
}
