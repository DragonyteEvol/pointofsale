/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

import pointofsale.MoneyConverter;

/**
 *
 * @author sebastian.yanez
 */
public class XView extends javax.swing.JPanel {

    /**
     * Creates new form XView
     */
    public XView(String paymentMethod, Long price) {
        initComponents();
        this.txtPaymentMethod.setText(paymentMethod);
        this.txtPrice.setText(String.valueOf(MoneyConverter.convertDouble(price)));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPaymentMethod = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setText("Metodo de pago:");
        jPanel2.add(jLabel1);

        txtPaymentMethod.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        txtPaymentMethod.setText("PaymentMethod");
        jPanel2.add(txtPaymentMethod);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel3.setText("Cantidad Facturada:");
        jPanel3.add(jLabel3);

        txtPrice.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        txtPrice.setText("Price");
        jPanel3.add(txtPrice);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.add(jSeparator1);

        jPanel1.add(jPanel4);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel txtPaymentMethod;
    public javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}
