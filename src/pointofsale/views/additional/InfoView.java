/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.additional;

/**
 *
 * @author dragonyte
 */
public class InfoView extends javax.swing.JPanel {

    /**
     * Creates new form InfoView
     */
    public InfoView() {
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
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        txtNit = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        txtTip = new javax.swing.JSpinner();
        jPanel26 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        txtAddress = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        txtRoute = new javax.swing.JTextField();
        btnSelectRoute = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnDeleteAll = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel18.setLayout(new javax.swing.BoxLayout(jPanel18, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel19.setLayout(flowLayout1);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel2.setText("Informacion y configuracion del sistema");
        jPanel19.add(jLabel2);

        jPanel18.add(jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout2.setAlignOnBaseline(true);
        jPanel20.setLayout(flowLayout2);

        jLabel3.setText("Nit:");
        jPanel20.add(jLabel3);

        jPanel18.add(jPanel20);

        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));
        jPanel21.add(txtNit);

        jPanel18.add(jPanel21);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout3.setAlignOnBaseline(true);
        jPanel22.setLayout(flowLayout3);

        jLabel4.setText("Nombre del negocio:");
        jPanel22.add(jLabel4);

        jPanel18.add(jPanel22);

        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.LINE_AXIS));
        jPanel23.add(txtName);

        jPanel18.add(jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout4 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout4.setAlignOnBaseline(true);
        jPanel24.setLayout(flowLayout4);

        jLabel5.setText("Propina por defecto:");
        jPanel24.add(jLabel5);

        jPanel18.add(jPanel24);

        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.LINE_AXIS));

        txtTip.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));
        jPanel25.add(txtTip);

        jPanel18.add(jPanel25);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout5.setAlignOnBaseline(true);
        jPanel26.setLayout(flowLayout5);

        jLabel6.setText("Direccion:");
        jPanel26.add(jLabel6);

        jPanel18.add(jPanel26);

        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.LINE_AXIS));
        jPanel27.add(txtAddress);

        jPanel18.add(jPanel27);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout6 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout6.setAlignOnBaseline(true);
        jPanel28.setLayout(flowLayout6);

        jLabel7.setText("Telefono:");
        jPanel28.add(jLabel7);

        jPanel18.add(jPanel28);

        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));
        jPanel29.add(txtPhone);

        jPanel18.add(jPanel29);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout7 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout7.setAlignOnBaseline(true);
        jPanel30.setLayout(flowLayout7);

        jLabel8.setText("Ruta de informes por defecto");
        jPanel30.add(jLabel8);

        jPanel18.add(jPanel30);

        jPanel31.setLayout(new javax.swing.BoxLayout(jPanel31, javax.swing.BoxLayout.LINE_AXIS));
        jPanel31.add(txtRoute);

        btnSelectRoute.setBackground(new java.awt.Color(51, 102, 255));
        btnSelectRoute.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectRoute.setText("Seleccionar");
        btnSelectRoute.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 5));
        jPanel31.add(btnSelectRoute);

        jPanel18.add(jPanel31);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnDeleteAll.setBackground(new java.awt.Color(235, 71, 71));
        btnDeleteAll.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAll.setText("Borrar Todo ");
        btnDeleteAll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(235, 71, 71), 5));
        jPanel1.add(btnDeleteAll);

        jPanel18.add(jPanel1);

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout8 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout8.setAlignOnBaseline(true);
        jPanel32.setLayout(flowLayout8);

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Guardar");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 5));
        jPanel32.add(btnSave);

        jPanel18.add(jPanel32);

        add(jPanel18, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDeleteAll;
    public javax.swing.JButton btnSave;
    public javax.swing.JButton btnSelectRoute;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JTextField txtAddress;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtNit;
    public javax.swing.JTextField txtPhone;
    public javax.swing.JTextField txtRoute;
    public javax.swing.JSpinner txtTip;
    // End of variables declaration//GEN-END:variables
}
