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
        
        view.setResizable(false);
        view.setVisible(true);
    }
}
