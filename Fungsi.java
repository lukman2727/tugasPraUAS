/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ib.perpustakaan.lib;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

/**
 *
 * @author Iyongb
 */
public class Fungsi {
    
    public static void setTengaha(Component c)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - c.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - c.getHeight()) / 2);
        try
        {
//            x = (int) c.getParent().getLocation().x;
//            y = (int) c.getParent().getLocation().y;
//            
//            x = x + (x / 2);
//            y = y + (y / 2);
        }catch(NullPointerException npe)
        {
            
        }
        System.out.println(x);
        System.out.println(y);
        c.setLocation(x, y);
    }
    
    public static void setMaximize(JFrame c)
    {
        // Maximize windows
        c.setExtendedState(c.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }
    
    private static JInternalFrame iframe(JInternalFrame iframe)
    {
        try {
            iframe = iframe.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Fungsi.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return iframe;
    }
    
    public static void addInternalPanel(JDesktopPane desktopPane, JInternalFrame iframe)
    {
        try
        {
            if(iframe.getClass().toString().equals(""))
            {
                iframe = Fungsi.iframe(iframe);
            }
        }catch(NullPointerException npe)
        {
            iframe = Fungsi.iframe(iframe);
        }
        
        if(!iframe.isVisible())
        {
            try{
                desktopPane.add(iframe);
            }catch(IllegalArgumentException ai)
            {
                iframe = Fungsi.iframe(iframe);
                addInternalPanel(desktopPane, iframe);
            }
            iframe.setVisible(true);
        }
        else
        {
            try {
                iframe.setSelected(true);
            } catch (PropertyVetoException ex) {
                
            }
            desktopPane.setSelectedFrame(iframe);
        }
        
        try {
            iframe.setMaximum(true);
        } catch (PropertyVetoException ex) {
            
        }
    }
    
    public static void setColumnHidden(JTable table, int col) {
       table.getColumnModel().getColumn(col).setMinWidth(0);
       table.getColumnModel().getColumn(col).setMaxWidth(0);
       table.getColumnModel().getColumn(col).setWidth(0);
    }
    
    
    public static void setIcon(Window frame, String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(frame.getClass().getResource(path));
            System.out.println(img);
        } catch (Exception e) {
        }

        frame.setIconImage(img);
    }
}
