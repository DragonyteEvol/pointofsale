package pointofsale.controllers;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import java.io.Console;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;

import javax.swing.RepaintManager;

public class PrintFunctions implements Printable, Pageable {

    private Component componentToBePrinted;
    private PageFormat format;
    private int numPages;

    public PrintFunctions(Component componentToBePrinted) {
        this.componentToBePrinted = componentToBePrinted;

        // get total space from component  
        Dimension totalSpace = this.componentToBePrinted.getPreferredSize();

        // calculate for DIN A4
        format = PrinterJob.getPrinterJob().defaultPage();
        numPages = (int) Math.ceil(totalSpace.height / format.getImageableHeight()) - 1;
        System.out.println(String.valueOf(numPages));
        if (numPages > 2) {
            numPages = (int) (numPages - (Math.ceil(numPages / 2)));
            System.out.println(String.valueOf(numPages));
        }
        if (numPages < 1) {
            numPages = 1;
        }

        System.out.println(String.valueOf(numPages));
    }

    public void print() {
        PrinterJob printJob = PrinterJob.getPrinterJob();

        // show page-dialog with default DIN A4
        PageFormat pf0 = printJob.defaultPage();
        PageFormat pf1 = (PageFormat) pf0.clone();
        Paper p = pf0.getPaper();
        p.setImageableArea(0, 0, pf0.getWidth(), pf0.getHeight());
        pf1.setPaper(p);
        format = printJob.validatePage(pf1);

        //format = printJob.pageDialog(printJob.defaultPage(pf2));
        printJob.setPrintable(this);
        printJob.setPageable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
                System.out.println("Error printing: " + pe);
            }
        }
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        if ((pageIndex < 0) | (pageIndex >= numPages)) {
            return (NO_SUCH_PAGE);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY() - pageIndex * pageFormat.getImageableHeight());
            g2d.scale(0.5, 0.5);
            //disableDoubleBuffering(componentToBePrinted);
            componentToBePrinted.paint(g2d);
            //enableDoubleBuffering(componentToBePrinted);
            return (PAGE_EXISTS);
        }
    }

    public static void disableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(false);
    }

    public static void enableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(true);
    }

    @Override
    public int getNumberOfPages() {
        // TODO Auto-generated method stub
        return numPages;
    }

    @Override
    public PageFormat getPageFormat(int arg0) throws IndexOutOfBoundsException {
        return format;
    }

    @Override
    public Printable getPrintable(int arg0) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return this;
    }
}
