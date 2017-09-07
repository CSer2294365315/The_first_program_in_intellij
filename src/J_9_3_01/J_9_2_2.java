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
public class J_9_2_2 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame f=new DrawFrame();
            
            f.setBackground(SystemColor.window);
            f.setTitle("这是用java绘制的第一个图形?");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            Color ab=f.getBackground();
            System.out.println(ab);
        });
    }
    
}
class DrawFrame extends JFrame
{
    public DrawFrame()
    {
       // DrawComponent a=new DrawComponent();
        DrawComponent b=new DrawComponent();
        b.setBackground(SystemColor.window);
        add(b);
      //  add(a)
        pack();
    }
}
class DrawComponent extends JComponent
{
    private static final int DEFUALT_WIDTH=300;
    private static final int DEFUALT_HEIGHT=300;
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        
        double leftX=0;
        double leftY=0;
        double width=200;
        double height=200;
        
        Rectangle2D f=new Rectangle2D.Double(leftX,leftY,width,height);
        g2.draw(f);
        
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(f);
        g2.draw(ellipse);
        
        Line2D l=new Line2D.Double(leftX,leftY,leftX+width,leftY+height);
        g2.draw(l);
        
        double centerX=f.getCenterX();
        double centerY=f.getCenterY();
        double radius=150;
        
        Ellipse2D circle=new Ellipse2D.Double();
        circle.setFrame(f);
        g2.draw(circle);
        
        
        g2.setPaint(new Color(1,128,128));
        g2.drawString("well", 100, 200);
        
        g2.setBackground(Color.yellow);
        
        
        
        
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFUALT_WIDTH,DEFUALT_HEIGHT);
    }
}
