/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
/**
 *
 * @author cmx
 */

public class image 
{
    public static void main(String [] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ImageFrame2();
            frame.setTitle("ImageTest...........");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
             System.out.println("image==null1");
         });
    }
}

class ImageFrame2 extends JFrame
{
    public ImageFrame2()
    {
        add(new ImageComponent2());
        pack();
         System.out.println("image==null2");
    }
}
class ImageComponent2 extends JComponent
{
    private Image image1;
    private static final int DEFAULT_WIDHT=300  ;
    private static final int DEFAULT_HEIGHT=200;
    
    
    public ImageComponent2()
    {
        image1=new ImageIcon("//Users//cmx//Desktop//Untitled1.jpg ").getImage();
         System.out.println("image==null3");
             System.out.println("image==null5");
            
        
        int imageWidth=image1.getWidth(this);
        int imageHeight=image1.getHeight(this);
        
        
         System.out.println("image==null6");
        
    }
    public void paintComponent2(Graphics g)
    {
        
        
        g.drawImage(image1, 100, 200, this);
        System.out.println("image==null62");
    }
}
