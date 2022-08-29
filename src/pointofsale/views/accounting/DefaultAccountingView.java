/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.accounting;

import pointofsale.controllers.components.ScrollBarCustom;

/**
 *
 * @author dragonyte
 */
public class DefaultAccountingView extends javax.swing.JPanel {

    /**
     * Creates new form DefaultAccountingView
     */
    public DefaultAccountingView() {
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
        btnExport = new javax.swing.JButton();
        cbTime = new javax.swing.JComboBox<>();
        pnReports = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 102, 153));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnExport.setBackground(new java.awt.Color(102, 153, 255));
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/file-export-solid-24.png"))); // NOI18N
        jPanel1.add(btnExport);

        cbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESPECIFICO", "AGRUPADO", "MES", "AÑO" }));
        jPanel1.add(cbTime);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pnReports.setLayout(new java.awt.GridLayout(1, 0));

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        pnReports.add(scrollPane);

        add(pnReports, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExport;
    public javax.swing.JComboBox<String> cbTime;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel pnReports;
    public javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
