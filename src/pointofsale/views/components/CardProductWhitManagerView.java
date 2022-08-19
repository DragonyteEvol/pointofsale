/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardProductWhitManagerView extends javax.swing.JPanel {

    /**
     * Creates new form CardProductView
     */
    public CardProductWhitManagerView() {
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

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtCategorie = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnLess = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        btnPlus = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(51, 102, 255));
        jPanel3.setForeground(new java.awt.Color(51, 102, 255));

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/dish-regular-24.png"))); // NOI18N
        jPanel5.add(jLabel2);

        jPanel3.add(jPanel5);

        add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setForeground(new java.awt.Color(51, 102, 255));

        txtName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("Name");
        jPanel1.add(txtName);

        jPanel4.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setForeground(new java.awt.Color(51, 102, 255));

        txtCategorie.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        txtCategorie.setForeground(new java.awt.Color(255, 255, 255));
        txtCategorie.setText("Categorie");
        jPanel2.add(txtCategorie);

        jPanel4.add(jPanel2);

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.setForeground(new java.awt.Color(51, 102, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnLess.setBackground(new java.awt.Color(51, 102, 255));
        btnLess.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        btnLess.setForeground(new java.awt.Color(255, 255, 255));
        btnLess.setText("-");
        btnLess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLessActionPerformed(evt);
            }
        });
        jPanel7.add(btnLess);

        txtQuantity.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        txtQuantity.setText("0");
        jPanel7.add(txtQuantity);

        btnPlus.setBackground(new java.awt.Color(51, 102, 255));
        btnPlus.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setText("+");
        jPanel7.add(btnPlus);

        btnAdd.setBackground(new java.awt.Color(51, 102, 255));
        btnAdd.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText(">");
        jPanel7.add(btnAdd);

        jPanel6.add(jPanel7);

        jPanel4.add(jPanel6);

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnLess;
    public javax.swing.JButton btnPlus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JLabel txtCategorie;
    public javax.swing.JLabel txtName;
    public javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
