/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pointofsale.views;

import java.awt.Toolkit;

/**
 *
 * @author dragonyte
 */
public class HomeView extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    public HomeView() {
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

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnCashDrawerUnlock = new javax.swing.JButton();
        btnCalculator = new javax.swing.JButton();
        btnNotifications = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnAccounting = new javax.swing.JButton();
        btnEvent = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        pnDinamic = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pointofsale/images/casa_real_icon.png")));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PointOfSale");
        jPanel7.add(jLabel1);

        jPanel5.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCashDrawerUnlock.setBackground(new java.awt.Color(102, 153, 255));
        btnCashDrawerUnlock.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnCashDrawerUnlock.setForeground(new java.awt.Color(255, 255, 255));
        btnCashDrawerUnlock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/lock-alt-solid-24_white.png"))); // NOI18N
        btnCashDrawerUnlock.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnCashDrawerUnlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashDrawerUnlockActionPerformed(evt);
            }
        });
        jPanel8.add(btnCashDrawerUnlock);

        btnCalculator.setBackground(new java.awt.Color(102, 153, 255));
        btnCalculator.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnCalculator.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/calculator-regular-24.png"))); // NOI18N
        btnCalculator.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        btnCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculatorActionPerformed(evt);
            }
        });
        jPanel8.add(btnCalculator);

        btnNotifications.setBackground(new java.awt.Color(102, 153, 255));
        btnNotifications.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnNotifications.setForeground(new java.awt.Color(255, 255, 255));
        btnNotifications.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/notification-solid-24.png"))); // NOI18N
        btnNotifications.setText("0");
        btnNotifications.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        jPanel8.add(btnNotifications);

        btnUser.setBackground(new java.awt.Color(102, 153, 255));
        btnUser.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/user-solid-24.png"))); // NOI18N
        btnUser.setText("User");
        btnUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        jPanel8.add(btnUser);

        jPanel5.add(jPanel8);

        jPanel2.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout());

        btnDashboard.setBackground(new java.awt.Color(252, 252, 252));
        btnDashboard.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(102, 102, 102));
        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/line-chart-regular-24.png"))); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnDashboard);

        btnSell.setBackground(new java.awt.Color(252, 252, 252));
        btnSell.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnSell.setForeground(new java.awt.Color(102, 102, 102));
        btnSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/cart-regular-24.png"))); // NOI18N
        btnSell.setText("Vender");
        btnSell.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnSell);

        btnInventory.setBackground(new java.awt.Color(252, 252, 252));
        btnInventory.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(102, 102, 102));
        btnInventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/package-regular-24.png"))); // NOI18N
        btnInventory.setText("Inventario");
        btnInventory.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnInventory);

        btnAccounting.setBackground(new java.awt.Color(252, 252, 252));
        btnAccounting.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnAccounting.setForeground(new java.awt.Color(102, 102, 102));
        btnAccounting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/credit-card-solid-24.png"))); // NOI18N
        btnAccounting.setText("Contabilidad");
        btnAccounting.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnAccounting);

        btnEvent.setBackground(new java.awt.Color(252, 252, 252));
        btnEvent.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnEvent.setForeground(new java.awt.Color(102, 102, 102));
        btnEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/calendar-regular-24.png"))); // NOI18N
        btnEvent.setText("Eventos");
        btnEvent.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnEvent);

        btnConfig.setBackground(new java.awt.Color(252, 252, 252));
        btnConfig.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(102, 102, 102));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/cog-regular-24.png"))); // NOI18N
        btnConfig.setText("Configuracion");
        btnConfig.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel6.add(btnConfig);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pnDinamic.setBackground(new java.awt.Color(255, 255, 255));
        pnDinamic.setForeground(new java.awt.Color(51, 51, 51));
        pnDinamic.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnDinamic, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCashDrawerUnlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashDrawerUnlockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCashDrawerUnlockActionPerformed

    private void btnCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalculatorActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccounting;
    public javax.swing.JButton btnCalculator;
    public javax.swing.JButton btnCashDrawerUnlock;
    public javax.swing.JButton btnConfig;
    public javax.swing.JButton btnDashboard;
    public javax.swing.JButton btnEvent;
    public javax.swing.JButton btnInventory;
    public javax.swing.JButton btnNotifications;
    public javax.swing.JButton btnSell;
    public javax.swing.JButton btnUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JPanel pnDinamic;
    // End of variables declaration//GEN-END:variables
}
