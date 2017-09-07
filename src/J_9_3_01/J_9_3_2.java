/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEW_DATE_SEQUENCE_PACKAGE;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author cmx
 */
public class J_9_3_2 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ActionFrame();
            frame.setTitle("actionTest..........");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            
        });
    }


class ActionFrame extends JFrame
{
    private int DEFAULT_WIDTH=300  ,DEFAULT_HEIGHT=200;
    private JPanel buttonPanel;
    public ActionFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel=new JPanel();
        //定义动作
        Action yellowAction=new ColorAction("YellowAction",new ImageIcon(),Color.YELLOW);
        Action redAction=new ColorAction("Red", new ImageIcon(), Color.red);
        Action blueAction=new ColorAction("Blue", new ImageIcon(), Color.blue);
        
        buttonPanel.add(new JButton(yellowAction));
    buttonPanel.add(new JButton(blueAction));
    buttonPanel.add(new JButton(redAction));

    add(buttonPanel);

    InputMap imp=buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    imp.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
    imp.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
    imp.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");

    ActionMap amp=buttonPanel.getActionMap();
    amp.put("panel.yellow",yellowAction);
    amp.put("panel.blue",blueAction);
    amp.put("panel.red",redAction);
        
        
    }
    
    public class ColorAction extends AbstractAction
    {
        public ColorAction(String name,Icon icon,Color c)
        {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "set panel color to "+name.toLowerCase());
            putValue("color...", c);
        }
        
        public void actionPerformed(ActionEvent e)
        {
            Color a=(Color) getValue("color...");
            buttonPanel.setBackground(a);
        }
        
    }
}



