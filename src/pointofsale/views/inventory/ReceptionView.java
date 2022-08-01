/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.inventory;

/**
 *
 * @author dragonyte
 */
public class ReceptionView extends javax.swing.JPanel {

    /**
     * Creates new form ReceptionView
     */
    public ReceptionView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnInfo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnBase = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jTextField1.setText("Buscar");
        jPanel1.add(jTextField1);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel2.setText("Informacion de recepcion");
        jPanel6.add(jLabel2);

        txtPrice.setText("0");
        jPanel6.add(txtPrice);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 153, 153));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSave.setText("Aceptar");
        jPanel5.add(btnSave);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        pnInfo.setBackground(new java.awt.Color(255, 153, 153));
        pnInfo.setLayout(new javax.swing.BoxLayout(pnInfo, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(pnInfo);

        jPanel7.add(jScrollPane2);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        pnBase.setBackground(new java.awt.Color(255, 204, 204));
        pnBase.setLayout(new javax.swing.BoxLayout(pnBase, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnBase);

        jPanel4.add(jScrollPane1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JPanel pnBase;
    public javax.swing.JPanel pnInfo;
    public javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}
