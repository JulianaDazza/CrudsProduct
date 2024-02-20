/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.service.ProductService;

/**
 *
 * @author JUAN DAVID
 */
public class GUICategory extends javax.swing.JFrame {

    private ProductService productService;
    /**
     * Creates new form GUICategory
     */
    public GUICategory(ProductService productService) {
        initComponents();
        this.productService = productService;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCenter = new javax.swing.JPanel();
        pnlCenterButtons = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        pnlSouthButtons = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlCenterButtons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlCenterButtons.setLayout(new java.awt.GridLayout(0, 1));

        btnNuevo.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnNuevo.setText("Nueva categoria");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlCenterButtons.add(btnNuevo);

        btnEditar.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnEditar.setText("Buscar por categoria");
        pnlCenterButtons.add(btnEditar);

        btnFind.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnFind.setText("Actualizar categoria");
        pnlCenterButtons.add(btnFind);

        btnSave.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnSave.setText("Eliminar categoria");
        pnlCenterButtons.add(btnSave);

        pnlCenter.add(pnlCenterButtons, java.awt.BorderLayout.CENTER);

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouthButtons.add(btnCerrar);

        pnlCenter.add(pnlSouthButtons, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Menú de Categorías");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel4, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       GUIMainMenu nMenu = new GUIMainMenu(productService);
       nMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        GUICategoryNew newCategoryForm = new GUICategoryNew(productService);
        newCategoryForm.setAddOption(true);
        newCategoryForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(GUICategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCenterButtons;
    private javax.swing.JPanel pnlSouthButtons;
    // End of variables declaration//GEN-END:variables
}
