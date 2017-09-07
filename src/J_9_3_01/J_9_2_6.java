/*' Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.*;

/**
 *
 * @author cmx
 */
public class J_9_2_6 
{
    public static void main(String[] args)
    {
       
        String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String a:fontNames)
            System.out.println(a);
        Font sansbold=new Font("Abadi MT Condensed Extra Bold",Font.BOLD,20);
        
        EventQueue.invokeLater(()->
        {
            JFrame f=new DrawFrame2();
            
            f.setBackground(SystemColor.window);
            f.setTitle("这是用java绘制的第一个图形?");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
        
    }
    
}
class DrawFrame2 extends JFrame
{
    public DrawFrame2()
    {
       // DrawComponent a=new DrawComponent();
        co b=new co();
        
        add(b);
      //  add(a)
        setSize(900,900);
    }
}
class co extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        Font sansbold=new Font("Abadi MT Condensed Extra Bold",(Font.BOLD+Font.ITALIC),20);
        g2.setFont(sansbold);
        String mess="whatoooooooo";
        g2.drawString(mess, 70, 100);
        /**
         * Font a=new Font("..",Font.BLOD,20);
         * g2.setFont(a);
         * String message="...";
         * g2.drawString(message,x,y);
         */
        FontRenderContext abc=g2.getFontRenderContext();
        Rectangle2D bounds=sansbold.getStringBounds(mess, abc);
        g2.draw(bounds);
        
        FontRenderContext context=g2.getFontRenderContext();
        Rectangle2D bounds2=f.getStringBounds(mess,context);
        
    }
}