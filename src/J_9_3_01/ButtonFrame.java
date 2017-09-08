
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 *
 * @author cmx
 */
/*
public class ButtonFrame
{
    public static void main(String [] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ButtonFrame_2();
            frame.setTitle("ImageTest...........");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
    }
}
 class ButtonFrame_2  extends JFrame
{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=200;
    
    
    
    
    
    
    public ButtonFrame_2()
    {
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        
        buttonPanel=new JPanel();
        add(buttonPanel);
        
        JButton yellowButton=new JButton("yellow");
        JButton blueButton=new JButton("blue");
        JButton redButton=new JButton("red");
        JButton what=new JButton("what");
        
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(what);
        
        what.addActionListener(event->{
            buttonPanel.setBackground(Color.PINK);
        });
        
        ColorAction y=new ColorAction(Color.YELLOW);
        ColorAction b=new ColorAction(Color.blue);
        ColorAction r=new ColorAction(Color.RED);
        
        
        yellowButton.addActionListener(y);
        blueButton.addActionListener(b);
        redButton.addActionListener(r);
        
        System.out.println("......."+redButton.getActionCommand());
        
        
         makeButton("1",Color.GREEN);
         makeButton("2",Color.CYAN);
       
        
        
    }
    
    /**
         * 辅助方法
         */
/*
        public void makeButton(String n,Color c)
        {
            JButton simpleButton=new JButton(n);
            buttonPanel.add(simpleButton);
            simpleButton.addActionListener(event->
            {
                buttonPanel.setBackground(c);
                
            });
            
        }
    
    private class ColorAction implements ActionListener
    {
        private Color col;
        
        public ColorAction(Color c)
        {
            col=c;
        }
        public void actionPerformed(ActionEvent event)
        {
            buttonPanel.setBackground(col);
        }

        
    }
    
    
    
}
*/