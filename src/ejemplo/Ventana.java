/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejemplo;

import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Ventana extends javax.swing.JFrame {
    private String cedula,nombre,carrera;
    private DefaultListModel modelList;
    private DefaultTableModel modelTable;
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        initList();
        initTable();
        popupTable();
    }

    
    public void initList(){
        String [] list = {"UNO","Dos"};
        modelList = new DefaultListModel();
        for (int i = 0; i < list.length; i++) {
            modelList.addElement(list[i]);
        }
        jLstCareras.setModel(modelList);
    }
    
    public void initTable(){
        String [] titulos = {"Registro","Nombre","Cedula","Carrera"};
        modelTable = new DefaultTableModel(titulos,0);
        jtblRegistro.setModel(modelTable);
    }
    
    public void popupTable(){
        jmniEditar = new JMenuItem("EDITAR");
        jmniEliminar = new JMenuItem("ELIMINAR");
        
        jmniEditar.addActionListener(e->editarRegistro());
        jmniEliminar.addActionListener(e->eliminarRegistro());
        jppmMenu.add(jmniEditar);
        jppmMenu.add(jmniEliminar);
        jtblRegistro.setComponentPopupMenu(jppmMenu);
    }
    
    public void agregarRegistro(){
        nombre = jtxtNombre.getText();
        cedula = jtxtCedula.getText();
        carrera = jLstCareras.getSelectedValue();
        if(nombre.isEmpty() || cedula.isEmpty() || carrera == null){
            JOptionPane.showMessageDialog(this, "FALTAN DATOS","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        int contador = (jtblRegistro.getRowCount()+1);
        Object [] fila = {contador++, nombre,cedula,carrera};
        modelTable = (DefaultTableModel) jtblRegistro.getModel();
        modelTable.addRow(fila);
        
        jtxtNombre.setText("");
        jtxtCedula.setText("");
        jLstCareras.clearSelection();
    }
    
    public void editarRegistro(){
        int fila = jtblRegistro.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
            return;
        }/*
        nombre = JOptionPane.showInputDialog(jtblRegistro.getValueAt(fila, 1).toString());
        cedula = JOptionPane.showInputDialog(jtblRegistro.getValueAt(fila, 2).toString());
        carrera = JOptionPane.showInputDialog(jtblRegistro.getValueAt(fila, 3).toString());*/
        
        jtxtNombre.setText(jtblRegistro.getValueAt(fila, 2).toString());
        jtxtCedula.setText(jtblRegistro.getValueAt(fila, 2).toString());
        
        
        Object value = jtblRegistro.getValueAt(fila, 3);
        if(value=="UNO") jLstCareras.setSelectedIndex(0);
       if(value=="Dos") jLstCareras.setSelectedIndex(1);
        
        if(nombre!=null && cedula!=null && carrera!=null){
            modelTable.setValueAt(jtxtNombre.getText(), fila, 1);
            modelTable.setValueAt(jtxtCedula.getText(), fila, 2);
            //modelTable.setValueAt(carrera, fila, 3);
        }
    }
    
    public void agregarCarrera(){
        carrera = JOptionPane.showInputDialog(this, "Ingrese una Carrera");
        if(carrera!=null){
            modelList.addElement(carrera);
        }
        
    }
    
    public void eliminarRegistro(){
        int fila = jtblRegistro.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jtblRegistro.getModel();
    model.removeRow(fila);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppmMenu = new javax.swing.JPopupMenu();
        jmniEditar = new javax.swing.JMenuItem();
        jmniEliminar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistro = new javax.swing.JTable();
        jbtnCarrera = new javax.swing.JButton();
        jbtnIngresar = new javax.swing.JButton();
        jtxtCedula = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstCareras = new javax.swing.JList<>();

        jmniEditar.setText("jMenuItem1");
        jmniEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniEditarActionPerformed(evt);
            }
        });

        jmniEliminar.setText("jMenuItem2");
        jmniEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmniEliminarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtblRegistro);

        jbtnCarrera.setText("Carrera");
        jbtnCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCarreraActionPerformed(evt);
            }
        });

        jbtnIngresar.setText("Ingresar");
        jbtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarActionPerformed(evt);
            }
        });

        jtxtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCedulaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Cedula");

        jScrollPane2.setViewportView(jLstCareras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jbtnCarrera)
                .addGap(18, 18, 18)
                .addComponent(jbtnIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtxtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jtxtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCarrera)
                    .addComponent(jbtnIngresar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCedulaActionPerformed

    private void jbtnCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCarreraActionPerformed
        // TODO add your handling code here:
        agregarRegistro();
    }//GEN-LAST:event_jbtnCarreraActionPerformed

    private void jmniEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniEliminarActionPerformed
        // TODO add your handling code here:
        eliminarRegistro();
    }//GEN-LAST:event_jmniEliminarActionPerformed

    private void jbtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarActionPerformed
        // TODO add your handling code here:
        agregarCarrera();
    }//GEN-LAST:event_jbtnIngresarActionPerformed

    private void jmniEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmniEditarActionPerformed
        // TODO add your handling code here:
        editarRegistro();
    }//GEN-LAST:event_jmniEditarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jLstCareras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnCarrera;
    private javax.swing.JButton jbtnIngresar;
    private javax.swing.JMenuItem jmniEditar;
    private javax.swing.JMenuItem jmniEliminar;
    private javax.swing.JPopupMenu jppmMenu;
    private javax.swing.JTable jtblRegistro;
    private javax.swing.JTextField jtxtCedula;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
