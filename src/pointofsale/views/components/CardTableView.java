/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardTableView extends javax.swing.JPanel {

    /**
     * Creates new form CardTableView
     */
    public CardTableView() {
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
        btnEdit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNumber = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSell = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnPay = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(new java.awt.GridLayout(4, 0));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnEdit.setText("E");
        jPanel1.add(btnEdit);

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        txtNumber.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtNumber.setText("1");
        jPanel2.add(txtNumber);

        add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        btnSell.setText("Vender");
        jPanel3.add(btnSell);

        add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        btnPay.setText("Pagar");
        jPanel4.add(btnPay);

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnPay;
    public javax.swing.JButton btnSell;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel txtNumber;
    // End of variables declaration//GEN-END:variables
}