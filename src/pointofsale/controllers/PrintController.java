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

/**
 *
 * @author dragonyte
 */
public class PrintController implements Printable{
    
    private Component component;

    public PrintController(Component component) {
        this.component = component;
    }
    
    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
        if(i>0){
            return NO_SUCH_PAGE;
        }
        
        Graphics2D hub = (Graphics2D) grphcs;
        hub.translate(pf.getImageableX() + 10, pf.getImageableY() + 10);
        hub.scale(1.0, 1.0);
        component.paint(hub);
        
        return PAGE_EXISTS;
        
        
    }
    
}
