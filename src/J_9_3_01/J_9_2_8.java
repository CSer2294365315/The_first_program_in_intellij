/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 *
 * @author cmx
 */
public class J_9_2_8 
{
    public static void main(String [] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ImageFrame();
            frame.setTitle("ImageTest...........");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
    }
}

class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent
{
    private Image image1;
    private static final int DEFAULT_WIDHT=300  ;
    private static final int DEFAULT_HEIGHT=200;
    
    public ImageComponent()
    {
        image1=new ImageIcon("//Users//cmx//Desktop//Untitled1.jpg ").getImage();
    }
    public void paintComponent(Graphics g)
    {
        if(image1==null)
        {
            System.out.println("image==null");
            return ;
        }
        int imageWidth=image1.getWidth(this);
        int imageHeight=image1.getHeight(this);
        
        g.drawImage(image1, 0, 0, null);
        
        for(int i=0;i*imageWidth<=getWidth();++i)
            for(int j=0;j*imageHeight<=getHeight();++j)
                if(i+j>0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth , j*imageHeight);
        
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDHT,DEFAULT_HEIGHT);
    }
    
}

