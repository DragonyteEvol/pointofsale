/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers.modal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pointofsale.models.CategorieModel;
import pointofsale.objects.Categorie;
import pointofsale.views.modal.NewCategorieView;

/**
 *
 * @author dragonyte
 */
public class EditCategorieController implements ActionListener {

    private NewCategorieView view;
    private Categorie categorie;
    public boolean removed = false;

    public EditCategorieController(Categorie categorie) {
        this.view = new NewCategorieView(null, true);
        this.view.setResizable(false);
        this.categorie = categorie;

        this.view.btnSave.addActionListener(this);

        setInfo();

        this.view.setVisible(true);
    }

    private void setInfo() {
        this.view.txtTitle.setText("Editar categoria");
        this.view.txtName.setText(categorie.getName());
        this.view.cbTarget.setSelectedIndex(categorie.getTarget());

    }

    public boolean validRequest(String name) {
        return !name.isBlank();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == this.view.btnSave) {
            String name = this.view.txtName.getText();
            Integer target = this.view.cbTarget.getSelectedIndex();
            if (validRequest(name)) {
                this.categorie.setName(name);
                this.categorie.setTarget(target);
                UpdateThread updateThread = new UpdateThread(categorie);
                updateThread.start();
                this.view.dispose();
            }
        }
    }

    class UpdateThread extends Thread {

        private Categorie categorie;

        public UpdateThread(Categorie categorie) {
            this.categorie = categorie;
        }

        private void updateCategorie() {
            CategorieModel categorieModel = new CategorieModel();
            categorieModel.update(categorie);
        }

        @Override
        public void run() {
            updateCategorie();
        }
    }

}
