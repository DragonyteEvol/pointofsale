/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import pointofsale.UserGlobal;
import pointofsale.controllers.HomeController;
import pointofsale.controllers.ModalController;
import pointofsale.models.CashDrawerModel;
import pointofsale.models.UserModel;
import pointofsale.objects.CashDrawer;
import pointofsale.objects.User;
import pointofsale.views.modal.CashDrawerPasswordView;
import pointofsale.views.modal.LoginView;

/**
 *
 * @author dragonyte
 */
public class CashDrawerController extends ModalController implements ActionListener {

    private CashDrawerPasswordView view;

    public CashDrawerController() {
        initComponents();
    }

    private void initComponents() {
        // view config
        this.view = new CashDrawerPasswordView(null, true);
        this.view.setMinimumSize(new Dimension(350,250));
        this.view.setLocationRelativeTo(null);

        initEvents();
        this.view.setVisible(true);
    }

    private void initEvents() {
        this.view.btnClose.addActionListener(this);
        this.view.btnSave.addActionListener(this);
    }

    // validate info of text fields
    private boolean validateRequest(String password) {
        return !password.isEmpty();
    }

    private boolean validatePassword(String password) {
        CashDrawerModel cashDrawerModel = new CashDrawerModel();
        CashDrawer cashDrawer = cashDrawerModel.selectPassword();
        return cashDrawer.getPassword().equals(password);
    }

    public void openCashDrawer() {

        byte[] open = {27, 112, 0, 100, (byte) 250};
//      byte[] cutter = {29, 86,49};
        PrintService pservice
                = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = pservice.createPrintJob();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(open, flavor, null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        try {
            job.print(doc, aset);
        } catch (PrintException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // create a unit from text fields
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.btnClose) {
            view.dispose();
        }
        if (source == view.btnSave) {
            String password = String.valueOf(view.txtPassword.getPassword());
            if (validateRequest(password)) {
                if (validatePassword(password)) {
                    openCashDrawer();
                }
            }
        }
    }
}
