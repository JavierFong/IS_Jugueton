/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import backEnd.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Work
 */
public class funcionesEspeciales extends javax.swing.JFrame {
    AdministradorJuguetes jAdmin = new AdministradorJuguetes();
    AdministradorProveedores pAdmin = new AdministradorProveedores(); 
    Usuario actual; 
    /**
     * Creates new form funcionesEspeciales
     */
    public funcionesEspeciales() {
        initComponents();
    }
    
    public funcionesEspeciales(Usuario user) {
        initComponents();
        this.setActual(user); 
    }

    public Usuario getActual() {
        return actual;
    }

    public void setActual(Usuario actual) {
        this.actual = actual;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Proveedores con 10+ Juguetes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Juguetes por Proveedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Juguete +caro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Juguetes Mecanicos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Juguetes Electronicos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Tipos de Juguete por Proveedor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Proveedores por tipo de Juguete");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Proveedor[] list = pAdmin.getListado(); 
        String[] nombres = new String[list.length]; 
        for (int i=0; i<list.length; i++) {
            nombres[i] = list[i].getNombre(); 
        }
        String prov = "";
        prov = (String) JOptionPane.showInputDialog(this, "Proveedor:", "", JOptionPane.QUESTION_MESSAGE,null,nombres,nombres[0]);
        int codigo = pAdmin.getCodigo(prov);
        Juguete[] listado = jAdmin.listadoProveedor(codigo);
        int lim = listado.length; 
        Object[][] data = new Object[lim][10];
        for (int i = 0; i<lim; i++) {
            data[i][0] = listado[i].getCodigo();
            data[i][1] = listado[i].getCodProveedor(); 
            data[i][2] = listado[i].getMarca();
            data[i][3] = listado[i].getEdad(); 
            data[i][4] = listado[i].getTipo();
            data[i][5] = listado[i].getComplejidad(); 
            data[i][6] = listado[i].getValorUnitario(); 
            data[i][7] = listado[i].getValorAdicional(); 
            data[i][8] = listado[i].getValorReal(); 
            data[i][9] = listado[i].getCantidad(); 
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Codigo", "Proovedor", "Marca", "Edad", "Tipo", "Complejidad", "Valor Uni.", "Valor Ad.","Valor real", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false,false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Proveedor[] listado = pAdmin.mayoresProveedores();
        listado = pAdmin.sort(listado);
        int lim = listado.length; 
        Object[][] data = new Object[lim][3];
        for (int i = 0; i<lim; i++) {
            data[i][0] = listado[i].getCodigo();
            data[i][1] = listado[i].getNombre(); 
            data[i][2] = listado[i].getCant_juguetes(); 
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Codigo", "Nombre", "Juguetes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        menuInicio mi = new menuInicio(getActual()); 
        mi.setVisible(true); 
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Proveedor[] list = pAdmin.getListado(); 
        String[] nombres = new String[list.length]; 
        for (int i=0; i<list.length; i++) {
            nombres[i] = list[i].getNombre(); 
        }
        String prov = "";
        prov = (String) JOptionPane.showInputDialog(this, "Proveedor:", "", JOptionPane.QUESTION_MESSAGE,null,nombres,nombres[0]);
        int codigo = pAdmin.getCodigo(prov);
        Proveedor prv = pAdmin.getProveedor(codigo); 
        JOptionPane.showMessageDialog(this, "El Proveedor "+prv.getNombre()+" con codigo "+prv.getCodigo()+",\nactualmente nos provee "+prv.getCant_juguetes()+" juguete(s)");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Juguete jgt = jAdmin.masCaro(); 
        JOptionPane.showMessageDialog(this,"El juguete mas caro es el del codigo "+jgt.getCodigo()+",\ncon un valor real de: "+jgt.getValorReal()); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Juguete[] listado = jAdmin.juguetesMecanicos();
        int lim = listado.length; 
        Object[][] data = new Object[lim][10];
        for (int i = 0; i<lim; i++) {
            data[i][0] = listado[i].getCodigo();
            data[i][1] = listado[i].getCodProveedor(); 
            data[i][2] = listado[i].getMarca();
            data[i][3] = listado[i].getEdad(); 
            data[i][4] = listado[i].getTipo();
            data[i][5] = listado[i].getComplejidad(); 
            data[i][6] = listado[i].getValorUnitario(); 
            data[i][7] = listado[i].getValorAdicional(); 
            data[i][8] = listado[i].getValorReal(); 
            data[i][9] = listado[i].getCantidad(); 
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Codigo", "Proovedor", "Marca", "Edad", "Tipo", "Complejidad", "Valor Uni.", "Valor Ad.","Valor real", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false,false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Juguete[] listado = jAdmin.juguetesElectronicos();
        int lim = listado.length; 
        Object[][] data = new Object[lim][10];
        for (int i = 0; i<lim; i++) {
            data[i][0] = listado[i].getCodigo();
            data[i][1] = listado[i].getCodProveedor(); 
            data[i][2] = listado[i].getMarca();
            data[i][3] = listado[i].getEdad(); 
            data[i][4] = listado[i].getTipo();
            data[i][5] = listado[i].getComplejidad(); 
            data[i][6] = listado[i].getValorUnitario(); 
            data[i][7] = listado[i].getValorAdicional(); 
            data[i][8] = listado[i].getValorReal(); 
            data[i][9] = listado[i].getCantidad(); 
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Codigo", "Proovedor", "Marca", "Edad", "Tipo", "Complejidad", "Valor Uni.", "Valor Ad.","Valor real", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false,false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        String[] tipos = new String[] {"Mecanico","Electronico"};
        String type; 
        type = (String) JOptionPane.showInputDialog(this, "Tipo de Juguete:", "", JOptionPane.QUESTION_MESSAGE,null,tipos,tipos[0]);
        Juguete[] listado = new Juguete[0]; 
        if (type.equals("Mecanico")) {
            listado = jAdmin.juguetesMecanicos();
            listado = jAdmin.sort(listado);
        } 
        if (type.equals("Electronico")) {
            listado = jAdmin.juguetesElectronicos();
            listado = jAdmin.sort(listado);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(funcionesEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(funcionesEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(funcionesEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(funcionesEspeciales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new funcionesEspeciales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}