/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.accounting;

/**
 *
 * @author dragonyte
 */
public class AnnulmentView extends javax.swing.JPanel {

    /**
     * Creates new form AnnulmentView
     */
    public AnnulmentView() {
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
        btnDelete = new javax.swing.JButton();
        pnAnnulments = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnDelete.setBackground(new java.awt.Color(102, 153, 255));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/eraser-solid-24.png"))); // NOI18N
        jPanel1.add(btnDelete);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pnAnnulments.setBackground(new java.awt.Color(255, 255, 255));
        pnAnnulments.setLayout(new javax.swing.BoxLayout(pnAnnulments, javax.swing.BoxLayout.LINE_AXIS));
        add(pnAnnulments, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDelete;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel pnAnnulments;
    // End of variables declaration//GEN-END:variables
}
