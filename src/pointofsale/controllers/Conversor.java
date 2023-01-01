package pointofsale.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import pointofsale.objects.Unit;
import pointofsale.views.modal.Calculator;

public class Conversor implements ActionListener {

    private Calculator view;

    public Conversor() {
        this.view = new Calculator(null, true);
        view.setLocationRelativeTo(null);

        view.btnCalculate.addActionListener(this);

        SetUnits setUnits = new SetUnits();
        setUnits.start();

        view.setVisible(true);
    }

    public String calculateUnit(int unitA, int unitB, String quantity) {
        System.out.print(unitA + " " + unitB);
        float gramo, decigramo, centigramo, miligramo, decagramo, hectogramo, kilogramo, conversion;
        int opcion_p, opcion_kg, opcion_hg, opcion_dag, opcion_g, opcion_dg, opcion_cg, opcion_mg;
        switch (unitA) {
            case 1:
                System.out.print("Entro en cases 1");
                kilogramo = Float.parseFloat(quantity);
                switch (unitB) {
                    case 1:
                        conversion = kilogramo;
                        return conversion + " kg";
                    case 2:
                        System.out.print("| case 1");
                        conversion = kilogramo * 10;
                        return conversion + " hg";
                    case 3:
                        System.out.print("| case 2");
                        conversion = kilogramo * 100;
                        return conversion + " dag";
                    case 4:
                        System.out.print("| case 3");
                        conversion = kilogramo * 1000;
                        return conversion + " g";
                    case 5:
                        System.out.print("| case 4");
                        conversion = kilogramo * 10000;
                        return conversion + "dg";
                    case 6:
                        System.out.print("| case 5");
                        conversion = kilogramo * 100000;
                        return conversion + " cg";
                    case 7:
                        System.out.print("| case 6");
                        conversion = kilogramo * 1000000;
                        return conversion + "mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;

                }
                break;
            case 2:
                System.out.print("Entro en cases 2");
                hectogramo = Float.parseFloat(quantity);
                opcion_hg = unitB;
                switch (opcion_hg) {
                    case 1:
                        conversion = hectogramo / 10;
                        return conversion + " kg";
                    case 2:
                        conversion = hectogramo;
                        return conversion + " hg";
                    case 3:
                        conversion = hectogramo * 10;
                        return conversion + " dag";
                    case 4:
                        conversion = hectogramo * 100;
                        return conversion + " g";
                    case 5:
                        conversion = hectogramo * 1000;
                        return conversion + " dg";
                    case 6:
                        conversion = hectogramo * 10000;
                        return conversion + " cg";
                    case 7:
                        conversion = hectogramo * 100000;
                        return conversion + " mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 3:
                System.out.print("Entro en cases 3");
                decagramo = Float.parseFloat(quantity);
                opcion_dag = unitB;
                switch (opcion_dag) {
                    case 1:
                        conversion = decagramo / 100;
                        return conversion + " kg";
                    case 2:
                        conversion = decagramo / 10;
                        return conversion + " hg";
                    case 3:
                        conversion = decagramo;
                        return conversion + " dag";
                    case 4:
                        conversion = decagramo * 10;
                        return conversion + " g";
                    case 5:
                        conversion = decagramo * 100;
                        return conversion + " dg";
                    case 6:
                        conversion = decagramo * 1000;
                        return conversion + " cg";
                    case 7:
                        conversion = decagramo * 10000;
                        return conversion + " mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 4:
                System.out.print("Entro en cases 4");
                gramo = Float.parseFloat(quantity);
                opcion_g = unitB;
                switch (opcion_g) {
                    case 1:
                        conversion = gramo / 1000;
                        return conversion + " kg";
                    case 2:
                        conversion = gramo / 100;
                        return conversion + " hg";
                    case 3:
                        conversion = gramo / 10;
                        return conversion + " dag";
                    case 4:
                        conversion = gramo;
                        return conversion + " g";
                    case 5:
                        conversion = gramo * 10;
                        return conversion + " dg";
                    case 6:
                        conversion = gramo * 100;
                        return conversion + " cg";
                    case 7:
                        conversion = gramo * 1000;
                        return conversion + " mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 5:
                System.out.print("Entro en cases 5");
                decigramo = Float.parseFloat(quantity);
                opcion_dg = unitB;
                switch (opcion_dg) {
                    case 1:
                        conversion = decigramo / 10000;
                        return conversion + " kg";
                    case 2:
                        conversion = decigramo / 1000;
                        return conversion + " hg";
                    case 3:
                        conversion = decigramo / 100;
                        return conversion + " dag";
                    case 4:
                        conversion = decigramo / 10;
                        return conversion + " g";
                    case 5:
                        conversion = decigramo;
                        return conversion + " dg";
                    case 6:
                        conversion = decigramo * 10;
                        return conversion + " cg";
                    case 7:
                        conversion = decigramo * 100;
                        return conversion + " mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 6:
                System.out.print("Entro en cases 6");
                centigramo = Float.parseFloat(quantity);
                opcion_cg = unitB;
                switch (opcion_cg) {
                    case 1:
                        conversion = centigramo / 100000;
                        return conversion + " kg";
                    case 2:
                        conversion = centigramo / 10000;
                        return conversion + " hg";
                    case 3:
                        conversion = centigramo / 1000;
                        return conversion + " dag";
                    case 4:
                        conversion = centigramo / 100;
                        return conversion + " g";
                    case 5:
                        conversion = centigramo / 10;
                        return conversion + " dg";
                    case 6:
                        conversion = centigramo;
                        return conversion + " mg";
                    case 7:
                        conversion = centigramo * 10;
                        return conversion + " cg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 7:
                System.out.print("Entro en cases 7");
                miligramo = Float.parseFloat(quantity);
                opcion_mg = unitB;
                switch (opcion_mg) {
                    case 1:
                        conversion = miligramo / 1000000;
                        return conversion + " kg";
                    case 2:
                        conversion = miligramo / 100000;
                        return conversion + " hg";
                    case 3:
                        conversion = miligramo / 10000;
                        return conversion + " dag";
                    case 4:
                        conversion = miligramo / 1000;
                        return conversion + " g";
                    case 5:
                        conversion = miligramo / 100;
                        return conversion + " dg";
                    case 6:
                        conversion = miligramo / 10;
                        return conversion + " cg";
                    case 7:
                        conversion = miligramo;
                        return conversion + " mg";
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                        break;
                }
                break;
            case 8:
                break;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == this.view.btnCalculate) {
            String quantity = String.valueOf(view.txtQuantity.getValue());
            Unit unitA = (Unit) view.cbUnitA.getSelectedItem();
            Unit unitB = (Unit) view.cbUnitB.getSelectedItem();
            String result = calculateUnit(Math.toIntExact(unitA.getId()), Math.toIntExact(unitB.getId()), quantity);
            view.txtResult.setText(result);
        }
    }

    class SetUnits extends Thread {

        String[] units = {"Kilogramo", "Hectogramo", "Decagramo", "Gramo", "Decigramo", "Centigramo", "Miligramo"};
        Integer id = 1;

        public void run() {
            for (String unit : units) {
                Unit u = new Unit();
                u.setId(Long.valueOf(id));
                u.setName(unit);
                view.cbUnitA.addItem(u);
                view.cbUnitB.addItem(u);
                id++;
            }
        }
    }

}
