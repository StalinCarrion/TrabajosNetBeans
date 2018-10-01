package GUIWindows;

import BL.BLConexion;
import BL.BLProducto;
import Clases.Productos;
import Validaciones.Validaciones;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Productos1 extends javax.swing.JFrame 
{
    BLProducto mp = new BLProducto();
    BLConexion ManejadorConexion = new BLConexion();
    ArrayList<Productos> lstProductos=new ArrayList<>();
    Validaciones validar=new Validaciones ();
    //Estudiante Estudiante = new Estudiante();
    
    public Productos1() 
    {
        initComponents();
        this.limitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEspecifico = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        tstPrecioU = new javax.swing.JTextField();
        txtPVP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btncon = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfechaIng = new javax.swing.JTextField();
        txtFechaMod = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        txtActual = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecificoActionPerformed(evt);
            }
        });

        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel2.setText("Introduza campo a buscar");

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        tstPrecioU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tstPrecioUKeyTyped(evt);
            }
        });

        txtPVP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPVPKeyTyped(evt);
            }
        });

        jLabel3.setText("codigo");

        jLabel4.setText("descripcion");

        jLabel5.setText("cantidad");

        jLabel6.setText("Precio Unitario");

        jLabel7.setText("pvp");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        btncon.setText("Listar");
        btncon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertat");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel8.setText("fecha Ingreso");

        jLabel9.setText("fecha Modifcacion");

        txtfechaIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaIngActionPerformed(evt);
            }
        });
        txtfechaIng.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechaIngKeyTyped(evt);
            }
        });

        txtFechaMod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaModKeyTyped(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualActionPerformed(evt);
            }
        });

        jLabel11.setText("Ingres datos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btncon)
                        .addGap(31, 31, 31)
                        .addComponent(btnModificar)
                        .addGap(225, 225, 225)
                        .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3)
                        .addGap(89, 89, 89)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addGap(57, 57, 57)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69)
                        .addComponent(tstPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(txtFechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(txtEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(btnConsulta))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50)
                                .addComponent(txtfechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInsertar)
                                .addGap(99, 99, 99)
                                .addComponent(btnCerrar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPVP, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncon)
                    .addComponent(btnModificar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEspecifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsulta))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tstPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtPVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtfechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnInsertar)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnCerrar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void ListarDatos() throws ClassNotFoundException, SQLException{
            //Como el método de la BL retorna un ArrayList de la clase Estudiantes
            //Aqui lo recuperamos
            ArrayList<Productos> lstProductos = mp.ConsultaLista();
           
            Object columnas[] = {"codigo","descripcion", "cantidad","precion_unitario","pvp","fecha_ingreso","fecha_modifcacion"};
            DefaultTableModel modelo = new DefaultTableModel(null, columnas);
            jTable2.setModel(modelo); 
            
            for (Productos objeto : lstProductos)
            {
                //String id=String.valueOf(objeto.getStrCodigo());
                String cantidad=String.valueOf(objeto.getIntCantidad());
                String precioU=String.valueOf(objeto.getIntPrecioU());
                String pvp=String.valueOf(objeto.getIntPVP());
                String modeloTemp[] = {objeto.getStrCodigo(),objeto.getStrDescripcion(),cantidad,precioU,
                pvp,objeto.getStrFechaIngreso(),objeto.getStrFechaM()};
                modelo.addRow(modeloTemp);
            }
 }
 public void limpiar(){ 
     this.txtcodigo.setText(null);
     this.txtDescripcion.setText(null);
     this.txtCantidad.setText(null);
     this.tstPrecioU.setText(null);
     this.txtPVP.setText(null);
     this.txtfechaIng.setText(null);
     this.txtFechaMod.setText(null);
     
    
 }
 //VALIDAD LIMITE PARA CODIGO PRODUCTO
 public void limitar (){
     this.txtcodigo.setDocument(new Validaciones (this.txtcodigo,5));
     
 }
     
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        try 
        {
            ManejadorConexion.CerrarConexion();
            this.dispose();
            //btnCerrar.//
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecificoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecificoActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
       
            // TODO add your handling code here:
            
        try {
            
            String consulta=this.txtEspecifico.getText();//obtengo el dato en un String 
            int id=Integer.parseInt(consulta);//paso el String obtenido a un entero 
            Productos objProd;
            
            objProd = mp.Consultar(id);
            
            if(!objProd.getStrCodigo().isEmpty()){//si existe un registro 
                this.txtcodigo.setText(objProd.getStrCodigo());
                this.txtDescripcion.setText(objProd.getStrDescripcion());
                this.txtCantidad.setText(String.valueOf(objProd.getIntCantidad()));
                this.tstPrecioU.setText(String.valueOf(objProd.getIntPrecioU()));
                this.txtPVP.setText(String.valueOf(objProd.getIntPVP()));
                this.txtfechaIng.setText(objProd.getStrFechaIngreso());
                this.txtFechaMod.setText(objProd.getStrFechaM());
            }else{
                JOptionPane.showMessageDialog(null, "Registro no Econtrado");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("sssdddddss");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
       
    }//GEN-LAST:event_txtcodigoActionPerformed

    public int eliminarRegistro(String strcodigo) throws SQLException, ClassNotFoundException{
        return mp.Eliminar(strcodigo);
        
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        //        String strId=jTable2.getModel().getValueAt(row, 0).toString();
        String strcodigo = jTable2.getModel().getValueAt(row, 0).toString();
        String strdescripcion = jTable2.getModel().getValueAt(row, 1).toString();
        String strcantidad=jTable2.getModel().getValueAt(row, 2).toString();
        String strprecioU=jTable2.getModel().getValueAt(row, 3).toString();
        String strpvp=jTable2.getModel().getValueAt(row, 4).toString();
        String strFI=jTable2.getModel().getValueAt(row, 5).toString();
        String strFM=jTable2.getModel().getValueAt(row, 6).toString();

        System.out.println(strcodigo + " " +strdescripcion+" "+strcantidad+" "+strprecioU+" "+strFI+""+strFM+"\n");
//        txtNModificar.setText(strNombres);
        
        
                  
       
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconActionPerformed

        try {
            this.ListarDatos();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
                        System.out.println(ex.getMessage());

        }
    }//GEN-LAST:event_btnconActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
       int resultado=0;
       String codigo=this.txtcodigo.getText();
       String descripcion=this.txtDescripcion.getText();
       int cantidad=Integer.parseInt(this.txtCantidad.getText());
       int precioU=Integer.parseInt(this.tstPrecioU.getText());
       int pvp=Integer.parseInt(this.txtPVP.getText());
       String fechaIng=this.txtfechaIng.getText();
       String fechaMod=this.txtFechaMod.getText();
        
       Productos p=new Productos (codigo,descripcion,cantidad,precioU,pvp,fechaIng,fechaMod);
       //validad cajas de campos
       if (this.txtcodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "valida codigo", " error", JOptionPane.ERROR_MESSAGE);
       }else if(this.txtDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "valida descripcion", " error", JOptionPane.ERROR_MESSAGE);  
        } else if (this.txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "valida cantidad", " error", JOptionPane.ERROR_MESSAGE);
        }else if(this.tstPrecioU.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "valida precio unitario", " error", JOptionPane.ERROR_MESSAGE);
        }else if(this.txtPVP.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "valida precio unitario", " error", JOptionPane.ERROR_MESSAGE);
        } else if (this.txtfechaIng.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "valida fecha Ingreso", " error", JOptionPane.ERROR_MESSAGE);
        } else if (this.txtFechaMod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "valida Fecha modificacion", " error", JOptionPane.ERROR_MESSAGE);
        } else {
       lstProductos.add(p);
        try {
            resultado=this.mp.Insertar(lstProductos);
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "DATOS REGISTRADOS");
                this.ListarDatos();
                this.limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR"); 
            }
                 
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
       validar.ValidarCaracteres(evt);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        validar.ValidarNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void tstPrecioUKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tstPrecioUKeyTyped
       validar.ValidarNumeros(evt);
    }//GEN-LAST:event_tstPrecioUKeyTyped

    private void txtPVPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPVPKeyTyped
        validar.ValidarNumeros(evt);
    }//GEN-LAST:event_txtPVPKeyTyped

    private void txtfechaIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaIngActionPerformed

    private void txtfechaIngKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaIngKeyTyped
       //.ValidarCaracteres(evt);
    }//GEN-LAST:event_txtfechaIngKeyTyped

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped

    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtFechaModKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaModKeyTyped
       //validar.ValidarCaracteres(evt);
    }//GEN-LAST:event_txtFechaModKeyTyped
public void ListarDatosFctura() throws ClassNotFoundException, SQLException{
            //Como el método de la BL retorna un ArrayList de la clase Estudiantes
            //Aqui lo recuperamos
            ArrayList<Productos> lstProductos = mp.ConsultaLista();
           
            Object columnas[] = {"descripcion", "cantidad","precion_unitario","fecha_modifcacion"};
            DefaultTableModel modelo = new DefaultTableModel(null, columnas);
            jTable2.setModel(modelo); 
            
            for (Productos objeto : lstProductos)
            {
                //String id=String.valueOf(objeto.getStrCodigo());
                String cantidad=String.valueOf(objeto.getIntCantidad());
                String precioU=String.valueOf(objeto.getIntPrecioU());
                
                String modeloTemp[] = {objeto.getStrDescripcion(),cantidad,precioU,objeto.getStrFechaM()};
                modelo.addRow(modeloTemp);
            }
}
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int intResultado =0;
        String strActual = this.txtActual.getText();
        String strModificar = this.txtDescripcion.getText();
        //Productos e = new Productos();
        try {
            //Se crea una lista en vista de que puede desdela interfaz enviar a modificar por bloques.
            intResultado = mp.Modificar(strActual,strModificar);
            if (intResultado==1){
            JOptionPane.showMessageDialog(this,"DATOS MODICADOS CON EXITO");
            this.ListarDatos();
            }
            else{
            JOptionPane.showMessageDialog(this,"ERROR AL  MODIFICAR DATOS");
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    this.limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btncon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField tstPrecioU;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEspecifico;
    private javax.swing.JTextField txtFechaMod;
    private javax.swing.JTextField txtPVP;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtfechaIng;
    // End of variables declaration//GEN-END:variables
}
