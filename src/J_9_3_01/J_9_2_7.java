/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.font.*;
/**
 *
 * @author cmx
 */
public class J_9_2_7
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new FontFrame();
            frame.setTitle("Font Test.....");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
    
}
class FontFrame extends JFrame
{
    public FontFrame()
    {
        add(new FontComponent());
        pack();
    }
}
class FontComponent extends JComponent
{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        
        String message="Hello,world.........";
        
        Font f=new Font("Cambria",Font.BOLD+Font.ITALIC,20);
        g2.setFont(f);
        
        FontRenderContext context=g2.getFontRenderContext();
        Rectangle2D bounds2=f.getStringBounds(message,context);
        
        double x=(getWidth()-bounds2.getWidth())/2;
        double y=(getHeight()-bounds2.getHeight())/2;
        
        double ascent=-bounds2.getY();
        double baseY=y+ascent;
        
        g2.drawString(message, (int ) x, (int) y);
        
        g2.setPaint(Color.LIGHT_GRAY);
        g2.draw(new Line2D.Double(x,baseY,bounds2.getWidth(),bounds2.getHeight()));
        
        Rectangle2D rect=new Rectangle2D.Double(x,y,bounds2.getWidth(),bounds2.getHeight());
        g2.draw(rect);
        
                
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
