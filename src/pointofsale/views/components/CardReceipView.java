/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardReceipView extends javax.swing.JPanel {

    /**
     * Creates new form CardReceipView
     */
    public CardReceipView() {
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

        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnLess = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btnPlus = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        txtUnit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCurrentQuantity = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        pnImage = new javax.swing.JPanel();
        txtImage = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        btnLess.setBackground(new java.awt.Color(102, 153, 255));
        btnLess.setForeground(new java.awt.Color(255, 255, 255));
        btnLess.setText("-");
        jPanel13.add(btnLess);

        jPanel7.add(jPanel13, java.awt.BorderLayout.WEST);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel14.setLayout(new java.awt.GridLayout(2, 0));

        txtQuantity.setBackground(new java.awt.Color(242, 242, 242));
        txtQuantity.setText("0");
        txtQuantity.setBorder(null);
        jPanel14.add(txtQuantity);

        jPanel7.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        btnPlus.setBackground(new java.awt.Color(102, 153, 255));
        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");
        jPanel15.add(btnPlus);

        btnSave.setBackground(new java.awt.Color(102, 153, 255));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText(">");
        jPanel15.add(btnSave);

        jPanel7.add(jPanel15, java.awt.BorderLayout.EAST);

        jPanel4.add(jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        txtUnit.setForeground(new java.awt.Color(153, 153, 153));
        txtUnit.setText("Unidad");
        jPanel9.add(txtUnit);

        jPanel4.add(jPanel9);

        jPanel1.add(jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Disponible");
        jPanel2.add(jLabel3);

        txtCurrentQuantity.setForeground(new java.awt.Color(153, 153, 153));
        txtCurrentQuantity.setText("Quantity");
        jPanel2.add(txtCurrentQuantity);

        jPanel6.add(jPanel2);

        jPanel1.add(jPanel6);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        pnImage.setBackground(new java.awt.Color(255, 255, 255));
        pnImage.add(txtImage);

        jPanel11.add(pnImage);

        add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setText("Name");
        jPanel3.add(txtName);

        jPanel8.add(jPanel3);

        jPanel12.add(jPanel8);

        add(jPanel12, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLess;
    public javax.swing.JButton btnPlus;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnImage;
    public javax.swing.JLabel txtCurrentQuantity;
    public javax.swing.JLabel txtImage;
    public javax.swing.JLabel txtName;
    public javax.swing.JTextField txtQuantity;
    public javax.swing.JLabel txtUnit;
    // End of variables declaration//GEN-END:variables
}
