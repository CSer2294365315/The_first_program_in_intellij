/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author cmx
 */
public class J_9_1_11 
{
    public static void main(String[] args)
    {
        JFrame frame=new SimpleFrame2();
        EventQueue.invokeLater(()->
        {
            frame.setTitle("wellllll");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // Container content=frame.getContentPane();
           // Component c=new component1();
           // content.add(c);
            
            frame.setVisible(true);
            
            
        });
    }
}
class SimpleFrame2 extends JFrame
{
    public SimpleFrame2()
    {
    Toolkit kit=Toolkit.getDefaultToolkit();
    Dimension screenSize=kit.getScreenSize();
     double Width=screenSize.getWidth();
     double Height=screenSize.getHeight();
    setSize((int )Width/3,(int )Height/2);
    add(new component3() );
 //   setLocationByPlatform(true);
    }
}
class component extends JComponent
{
   private int Width1=75;
   private int Height1=100;
   public void paintComponent(Graphics g)
   {
       g.drawString("wel0001212", Width1, Height1);
   }
}
class component1 extends JComponent
{
   private int Width1=20;
   private int Height1=30;
   public void paintComponent(Graphics g)
   {
       g.drawString("hhhhhhhhh", Width1, Height1);
   }
}
class MyComponent extends JComponent
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    public void paintComponent(Graphics g)
    {
        g.drawOval(10, 20, 30, 40);
        
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
    
}
class component3 extends JPanel
{
   private int Width1=75;
   private int Height1=100;
   public void paintComponent(Graphics g)
   {
     //  super.paintComponent(g);
       g.drawString("wel0001212..........", Width1, Height1);
   }
}