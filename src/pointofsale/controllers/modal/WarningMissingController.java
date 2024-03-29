/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import pointofsale.objects.MissingStock;
import pointofsale.views.modal.WarningMissingStock;

/**
 *
 * @author dragonyte
 */
public class WarningMissingController {
    private WarningMissingStock view;

    public WarningMissingController(MissingStock missingStock) {
        this.view = new WarningMissingStock(null, true);
        
        
        view.txtProduct.setText(missingStock.getName());
        view.txtQuantity.setText(Long.toString(missingStock.getQuantity()) + missingStock.getUnit() + " disponibles");
        
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
