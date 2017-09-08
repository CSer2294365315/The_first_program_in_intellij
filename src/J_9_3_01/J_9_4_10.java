package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_4_10
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
           JFrame frame=new RadioButtonFrame();
           frame.setTitle("这是一个单选钮测试...");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });

    }
}
class RadioButtonFrame extends JFrame
{
    public RadioButtonFrame()
    {
        setSize(600,600);

        JLabel label=new JLabel("The quick brown fox...");
        label.setFont(new Font("Serif",Font.BOLD,25));
        add(label,BorderLayout.CENTER);

        ButtonGroup group=new ButtonGroup();

        JRadioButton smallButton=new JRadioButton("small",false);
        smallButton.addActionListener(event->{
            label.setFont(new Font("Serif",Font.PLAIN,15));
        });
        JRadioButton bigButton=new JRadioButton("big",false);
        bigButton.addActionListener(event->{
            label.setFont(new Font("Serif",Font.BOLD,35));
        });
        JRadioButton plainButton=new JRadioButton("plain",true);
        plainButton.addActionListener(event->{
            label.setFont(new Font("Serif",Font.BOLD,25));
        });

        group.add(smallButton);
        group.add(bigButton);
        group.add(plainButton);

        JPanel southPanel=new JPanel();
        southPanel.add(smallButton);
        southPanel.add(bigButton);
        southPanel.add(plainButton);

        add(southPanel,BorderLayout.SOUTH);





    }
}
