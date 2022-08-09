/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale;

import java.util.List;
import pointofsale.controllers.modal.WarningMissingController;
import pointofsale.models.InventoryModel;
import pointofsale.objects.MissingStock;

/**
 *
 * @author dragonyte
 */
public class MissingGlobal {

    static List<MissingStock> missingStocks;

    public MissingGlobal() {
    }

    public static List<MissingStock> getMissingStocks() {
        return missingStocks;
    }

    public static void setMissingStocks(List<MissingStock> missingStocks) {
        MissingGlobal.missingStocks = missingStocks;
    }

    public static List<MissingStock> getMissing() {
        InventoryModel inventoryModel = new InventoryModel();
        List<MissingStock> missingStockss = inventoryModel.selectMissing();
        System.out.println("pepe");
        return missingStockss;
    }

    public static void showNotifications() {
        MissingGlobal.setMissingStocks(MissingGlobal.getMissing());
        List<MissingStock> m = MissingGlobal.getMissing();
        for (MissingStock missingStock : m) {
            if (!missingStock.isShowed()) {
                WarningMissingController ca = new WarningMissingController(missingStock);
                InventoryModel inventoryModel = new InventoryModel();
                missingStock.setShowed(true);
                inventoryModel.updateNotification(missingStock);
            }
        }
    }

    public static void showAllNotifications() {
        MissingGlobal.setMissingStocks(MissingGlobal.getMissing());
        List<MissingStock> m = MissingGlobal.getMissing();
        for (MissingStock missingStock : m) {
            WarningMissingController ca = new WarningMissingController(missingStock);
        }
    }
}
