/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pointofsale.models.AnnulmentModel;
import pointofsale.objects.Annulment;
import pointofsale.views.accounting.AnnulmentView;

/**
 *
 * @author dragonyte
 */
public class AnnulmentController extends Controller implements ActionListener {

    private AnnulmentView view;
    private JTable table;

    public AnnulmentController(JPanel panel) {
        this.view = new AnnulmentView();
        
        view.btnDelete.addActionListener(this);

        SetAnnulments setAnnulments = new SetAnnulments();
        setAnnulments.start();

        this.addView(this.view, panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source == view.btnDelete){
            deleteProduct();
        }
    }

    private JTable construcTable(List<Annulment> annulments) {
        String rowTitle[] = {"id","Nombre del producto", "Responsable", "Cantidad", "Razon"};
        String arrayData[][] = modelTable(annulments);
        DefaultTableModel defaultTableModel = new DefaultTableModel(arrayData, rowTitle);

        table = new JTable(defaultTableModel);
        return table;
    }

    private String[][] modelTable(List<Annulment> annulments) {
        String arrayData[][] = new String[annulments.size()][5];

        for (int i = 0; i < annulments.size(); i++) {
            arrayData[i][0] = annulments.get(i).getId()+ "";
            arrayData[i][1] = annulments.get(i).getProduct() + "";
            arrayData[i][2] = annulments.get(i).getName() + "";
            arrayData[i][3] = annulments.get(i).getQuantity() + "";
            arrayData[i][4] = annulments.get(i).getReason() + "";

        }

        return arrayData;
    }
    
    private void deleteProduct() {
        Integer rowSelected = table.getSelectedRow();
        if (rowSelected != -1) {
            DefaultTableModel m = (DefaultTableModel) table.getModel();

            Integer id = Integer.parseInt(String.valueOf(table.getValueAt(rowSelected, 0)));
            m.removeRow(rowSelected);
            Annulment annulment = new Annulment(id, null, null, null);
            AnnulmentModel annulmentModel = new AnnulmentModel();
            annulmentModel.delete(annulment);
        }

    }

    class SetAnnulments extends Thread {

        @Override
        public void run() {
            AnnulmentModel am = new AnnulmentModel();
            List<Annulment> annulments = am.selectAll();
            JScrollPane jsp = new JScrollPane();
            jsp.setViewportView(construcTable(annulments));
            view.pnAnnulments.add(jsp);
            view.pnAnnulments.repaint();
            view.pnAnnulments.revalidate();
        }
    }
}
