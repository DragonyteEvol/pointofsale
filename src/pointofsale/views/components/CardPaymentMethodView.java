/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardPaymentMethodView extends javax.swing.JPanel {

    /**
     * Creates new form CardPaymentMethodView
     */
    public CardPaymentMethodView() {
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
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtVirtual = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout1);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/credit-card-alt-regular-24.png"))); // NOI18N
        jPanel6.add(jLabel1);

        jPanel1.add(jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnEdit.setBackground(new java.awt.Color(51, 102, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/pencil-regular-24.png"))); // NOI18N
        jPanel5.add(btnEdit);

        btnDelete.setBackground(new java.awt.Color(51, 102, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/eraser-solid-24.png"))); // NOI18N
        jPanel5.add(btnDelete);

        jPanel1.add(jPanel5);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        txtName.setText("Name");
        jPanel3.add(txtName);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtVirtual.setText("Virtual");
        jPanel4.add(txtVirtual);

        jPanel2.add(jPanel4);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JLabel txtName;
    public javax.swing.JLabel txtVirtual;
    // End of variables declaration//GEN-END:variables
}
