/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JPanel;

/**
 *
 * @author dragonyte
 */
public class PrintFunctions {
    
    public void print(Component component){
        /*PrintController mp = new PrintController(component);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(mp);
        boolean ok = job.printDialog();
        if(ok){
            try{
                job.print();
            }catch(PrinterException e){
                System.err.print(e.getMessage());
            }
        }*/
        
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");
        printerJob.setPrintable(new Printable(){
            @Override
            public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
                if(i > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2D = (Graphics2D)grphcs;
                graphics2D.translate(pf.getImageableX(), pf.getImageableY());
                graphics2D.scale(0.5, 0.5);
                component.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
        aset.add(MediaSizeName.INVOICE);
        if(returningResult){
            try{
                printerJob.print(aset);
            }catch(PrinterException e){
                System.out.print(e.getMessage());
            }
        }
    }
    
    public void printAll(JPanel panel){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Record");
        printerJob.setPrintable(new Printable(){
            @Override
            public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
                if(i > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2D = (Graphics2D)grphcs;
                graphics2D.translate(pf.getImageableX(), pf.getImageableY());
                graphics2D.scale(0.5, 0.5);
                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult = printerJob.printDialog();
        if(returningResult){
            try{
                printerJob.print();
            }catch(PrinterException e){
                System.out.print(e.getMessage());
            }
        }
    }
}
