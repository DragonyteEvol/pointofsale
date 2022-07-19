/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pointofsale.views.components;

import pointofsale.objects.IngredientUnit;

/**
 *
 * @author dragonyte
 */
public class CardIngredientView extends javax.swing.JPanel {
    public IngredientUnit ingredient;
    /**
    
     * Creates new form AddIngredientCardView
     * @param ingredient
     */
    public CardIngredientView(IngredientUnit ingredient) {
        initComponents();
        this.ingredient = ingredient;
        setIngredient(ingredient);
    }
    
    private void setIngredient(IngredientUnit ingredient){
        this.labelName.setText(ingredient.getName());
        this.labelUnit.setText(ingredient.getUnit());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelUnit = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtQuantity = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 153, 153));

        labelName.setText("IngredientName");

        labelUnit.setText("Unidad");

        btnAdd.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdd))
                            .addComponent(labelName)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelUnit)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUnit)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JLabel labelName;
    private javax.swing.JLabel labelUnit;
    public javax.swing.JSpinner txtQuantity;
    // End of variables declaration//GEN-END:variables
}
