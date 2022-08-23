/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.components;

import pointofsale.views.modal.ConfirmDeleteView;

/**
 *
 * @author dragonyte
 */
public class CardController {
    
    public ConfirmDeleteView deleteView;

    public CardController() {
        deleteView = new ConfirmDeleteView(null, true);
        deleteView.setResizable(false);
    }
    
    
}
