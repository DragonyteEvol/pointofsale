/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author dragonyte
 */
public class CardProductView extends javax.swing.JPanel {

    /**
     * Creates new form CardProductView
     */
    public CardProductView() {
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
        jPanel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtCategorie = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnEdit.setText("E");
        jPanel2.add(btnEdit);

        btnDelete.setText("D");
        jPanel2.add(btnDelete);

        jPanel1.add(jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8);

        jPanel1.add(jPanel7);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 51, 0));

        txtName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtName.setText("Name");
        jPanel4.add(txtName);

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 51, 0));

        txtPrice.setText("10,000");
        jPanel5.add(txtPrice);

        jPanel3.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 51, 0));

        txtCategorie.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        txtCategorie.setText("Categorie");
        jPanel6.add(txtCategorie);

        jPanel3.add(jPanel6);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JLabel txtCategorie;
    public javax.swing.JLabel txtName;
    public javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}
