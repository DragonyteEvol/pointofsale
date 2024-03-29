/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

/**
 *
 * @author sebastian.yanez
 */
public class BillView extends javax.swing.JPanel {

    /**
     * Creates new form BillView
     */
    public BillView() {
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
        jPanel4 = new javax.swing.JPanel();
        txtName = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtSubvalue = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setLayout(new java.awt.GridLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setText("Nombre");
        jPanel4.add(txtName);

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtQuantity.setText("Cantidad");
        jPanel5.add(txtQuantity);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtSubvalue.setText("Subvalor");
        jPanel6.add(txtSubvalue);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(jSeparator1);

        jPanel1.add(jPanel3);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel txtName;
    public javax.swing.JLabel txtQuantity;
    public javax.swing.JLabel txtSubvalue;
    // End of variables declaration//GEN-END:variables
}
