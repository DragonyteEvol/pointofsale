/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardRoomView extends javax.swing.JPanel {

    /**
     * Creates new form CardRoomView
     */
    public CardRoomView() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNumber = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnStatus = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnEdit.setText("E");
        jPanel5.add(btnEdit);

        add(jPanel5);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtNumber.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(txtNumber)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtNumber)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel2.setText("Precio:");
        jPanel2.add(jLabel2);

        txtPrice.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        txtPrice.setText("10.000");
        jPanel2.add(txtPrice);

        add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel3.setText("Capacidad: ");
        jPanel3.add(jLabel3);

        txtCapacity.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        txtCapacity.setText("2");
        jPanel3.add(txtCapacity);

        add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        btnStatus.setText("Estado");
        jPanel4.add(btnStatus);

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JLabel txtCapacity;
    public javax.swing.JLabel txtNumber;
    public javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}