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
public class RoomManagerView extends javax.swing.JDialog {

    /**
     * Creates new form RentRoomView
     */
    public RoomManagerView(java.awt.Frame parent, boolean modal) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSell = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtState = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCategorie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("pointofsale/images/casa_real_icon.png")));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pointofsale/images/room.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSell.setBackground(new java.awt.Color(235, 71, 71));
        btnSell.setForeground(new java.awt.Color(255, 255, 255));
        btnSell.setText("Vender");
        btnSell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 71, 71), 5));
        jPanel3.add(btnSell);

        btnPay.setBackground(new java.awt.Color(235, 71, 71));
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Pagar");
        btnPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 71, 71), 5));
        jPanel3.add(btnPay);

        btnEnd.setBackground(new java.awt.Color(235, 71, 71));
        btnEnd.setForeground(new java.awt.Color(255, 255, 255));
        btnEnd.setText("Finalizar hospedaje");
        btnEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 71, 71), 5));
        jPanel3.add(btnEnd);

        jPanel4.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Habitacion: ");
        jPanel6.add(jLabel4);

        txtNumber.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtNumber.setForeground(new java.awt.Color(102, 102, 102));
        txtNumber.setText("1");
        jPanel6.add(txtNumber);

        jPanel5.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Estado: ");
        jPanel7.add(jLabel1);

        txtState.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtState.setText("Ocupado");
        jPanel7.add(txtState);

        jPanel5.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Precio: ");
        jPanel8.add(jLabel2);

        txtPrice.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtPrice.setText("0");
        jPanel8.add(txtPrice);

        jPanel5.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Capacidad: ");
        jPanel9.add(jLabel3);

        txtCapacity.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtCapacity.setText("0");
        jPanel9.add(txtCapacity);

        jPanel5.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Categoria: ");
        jPanel10.add(jLabel5);

        txtCategorie.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtCategorie.setText("null");
        jPanel10.add(txtCategorie);

        jPanel5.add(jPanel10);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(RoomManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RoomManagerView dialog = new RoomManagerView(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnEnd;
    public javax.swing.JButton btnPay;
    public javax.swing.JButton btnSell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JLabel txtCapacity;
    public javax.swing.JLabel txtCategorie;
    public javax.swing.JLabel txtNumber;
    public javax.swing.JLabel txtPrice;
    public javax.swing.JLabel txtState;
    // End of variables declaration//GEN-END:variables
}
