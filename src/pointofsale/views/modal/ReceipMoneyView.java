/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pointofsale.views.modal;

import java.awt.Toolkit;

/**
 *
 * @author dragonyte
 */
public class ReceipMoneyView extends javax.swing.JDialog {

    /**
     * Creates new form Money
     */
    public ReceipMoneyView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtExchange = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtError = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btn1000 = new javax.swing.JButton();
        btn2000 = new javax.swing.JButton();
        btn5000 = new javax.swing.JButton();
        btn10000 = new javax.swing.JButton();
        btn20000 = new javax.swing.JButton();
        btn50000 = new javax.swing.JButton();
        btn100000 = new javax.swing.JButton();
        btn200000 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JSpinner();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pointofsale/images/casa_real_icon.png")));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Total a pagar:");
        jPanel4.add(jLabel1);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(102, 102, 102));
        txtTotal.setText("txtPrice");
        jPanel5.add(txtTotal);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cambio:");
        jPanel12.add(jLabel3);

        jPanel7.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setForeground(new java.awt.Color(102, 102, 102));
        jPanel13.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        txtExchange.setText("0");
        jPanel13.add(txtExchange);

        jPanel7.add(jPanel13);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel14.add(txtError);

        btnSave.setBackground(new java.awt.Color(235, 71, 71));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Aceptar");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 71, 71), 10));
        jPanel14.add(btnSave);

        jPanel7.add(jPanel14);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        btn1000.setBackground(new java.awt.Color(0, 204, 102));
        btn1000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn1000.setForeground(new java.awt.Color(255, 255, 255));
        btn1000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn1000.setText("1,000");
        btn1000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn1000);

        btn2000.setBackground(new java.awt.Color(0, 204, 102));
        btn2000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn2000.setForeground(new java.awt.Color(255, 255, 255));
        btn2000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn2000.setText("2,000");
        btn2000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn2000);

        btn5000.setBackground(new java.awt.Color(0, 204, 102));
        btn5000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn5000.setForeground(new java.awt.Color(255, 255, 255));
        btn5000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn5000.setText("5,000");
        btn5000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn5000);

        btn10000.setBackground(new java.awt.Color(0, 204, 102));
        btn10000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn10000.setForeground(new java.awt.Color(255, 255, 255));
        btn10000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn10000.setText("10,000");
        btn10000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn10000);

        btn20000.setBackground(new java.awt.Color(0, 204, 102));
        btn20000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn20000.setForeground(new java.awt.Color(255, 255, 255));
        btn20000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn20000.setText("20,000");
        btn20000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn20000);

        btn50000.setBackground(new java.awt.Color(0, 204, 102));
        btn50000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn50000.setForeground(new java.awt.Color(255, 255, 255));
        btn50000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn50000.setText("50,000");
        btn50000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn50000);

        btn100000.setBackground(new java.awt.Color(0, 204, 102));
        btn100000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn100000.setForeground(new java.awt.Color(255, 255, 255));
        btn100000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn100000.setText("100,000");
        btn100000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn100000);

        btn200000.setBackground(new java.awt.Color(0, 204, 102));
        btn200000.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btn200000.setForeground(new java.awt.Color(255, 255, 255));
        btn200000.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/money-regular-24-white.png"))); // NOI18N
        btn200000.setText("200,000");
        btn200000.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel10.add(btn200000);

        jPanel9.add(jPanel10);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        txtPrice.setBorder(null);
        jPanel11.add(txtPrice);

        jPanel9.add(jPanel11);

        jPanel3.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceipMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceipMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceipMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceipMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReceipMoneyView dialog = new ReceipMoneyView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn1000;
    public javax.swing.JButton btn10000;
    public javax.swing.JButton btn100000;
    public javax.swing.JButton btn2000;
    public javax.swing.JButton btn20000;
    public javax.swing.JButton btn200000;
    public javax.swing.JButton btn5000;
    public javax.swing.JButton btn50000;
    public javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JLabel txtError;
    public javax.swing.JLabel txtExchange;
    public javax.swing.JSpinner txtPrice;
    public javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
