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

public class J_9_1_9 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new NotHelloWorldFrame();
            frame.setTitle("Not a Hello World");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
            
        });
        
      
        
    }
    
}
class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
        add(new NotHelloWorldComponent());
        pack();
    }
}






class NotHelloWorldComponent extends JComponent
{
    private static final int MESSAGE_X=75;
    private static final int MESSAGE_Y=100;
    
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    
    public NotHelloWorldComponent(Graphics g)
    {
        g.drawString("Not a Hello,World program",MESSAGE_X,MESSAGE_Y);
    }
    public Dimension getPerferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}


