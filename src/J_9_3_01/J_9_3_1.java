/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 *
 * @author cmx
 */
public class J_9_3_1 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new Platframe();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("hello...........");
            frame.setVisible(true);
            
            UIManager.LookAndFeelInfo [] a=UIManager.getInstalledLookAndFeels();
            
            String name1=a[1].getName();
            String class1=a[1].getClassName();
            System.out.println(name1+"........"+class1);
            
        });
        
    }
    
}

class Platframe extends JFrame
{
    private JPanel buttonPanel;
    
    public Platframe()
    {
        buttonPanel=new JPanel();
        
       
        
        UIManager.LookAndFeelInfo[]  infos =UIManager.getInstalledLookAndFeels();
       for(UIManager.LookAndFeelInfo info:infos)
            makeButton(info.getName(),info.getClassName());
        add(buttonPanel);
     
        pack();
        
        
    }
    
    private void makeButton(String nameString,String className)
    {
        JButton button=new JButton(nameString);
        buttonPanel.add(button);
        
        button.addActionListener(event->
        {
            try 
            {
            
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
            pack();
       
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        });
        
    }
   
}


