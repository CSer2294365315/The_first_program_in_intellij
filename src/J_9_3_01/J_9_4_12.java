package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class J_9_4_12
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new BorderFrame();
            frame.setTitle("这是一个边框测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class BorderFrame extends JFrame
{
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;
    public BorderFrame()
    {
        setSize(600,600);
        demoPanel=new JPanel();
        buttonPanel=new JPanel();
        group=new ButtonGroup();

        addRadioButton("Lower bevel",BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raise bevel",BorderFactory.createRaisedBevelBorder());
        addRadioButton("Line bevel",BorderFactory.createLineBorder(Color.BLUE));

        Border etched=BorderFactory.createEtchedBorder();
        Border titled=BorderFactory.createTitledBorder(etched,"Border types...");
        buttonPanel.setBorder(titled);

        add(buttonPanel,BorderLayout.SOUTH);
        add(demoPanel,BorderLayout.CENTER);
//


    }

    public void addRadioButton(String buttonName,Border b)
    {
        JRadioButton button=new JRadioButton(buttonName);
        group.add(button);
        button.addActionListener(event->
        {
            demoPanel.setBorder(b);

        });
        buttonPanel.add(button);
    }
}
