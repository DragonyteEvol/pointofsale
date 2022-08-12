/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.controllers;

import java.awt.Component;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author dragonyte
 */
public class PrintFunctions {
    
    public void print(Component component){
        PrintController mp = new PrintController(component);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(mp);
        boolean ok = job.printDialog();
        if(ok){
            try{
                job.print();
            }catch(PrinterException e){
                System.err.print(e.getMessage());
            }
        }
    }
}
