package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_4_9_CheckBox_2
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
           JFrame frame=new CheckBoxFrame2();
           frame.setTitle("这是一个 复选框测试...");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setVisible(true);
        });
    }
}
class CheckBoxFrame2 extends JFrame
{
    public CheckBoxFrame2()
    {
        setSize(600,600);
        JLabel label=new JLabel("测试语句 test instance");
        label.setFont(new Font("Serif",Font.BOLD,24));
        add(label,BorderLayout.CENTER);

        JCheckBox bold=new JCheckBox("BOLD");
        JCheckBox italic=new JCheckBox("ITALIC");
        JPanel southpanel=new JPanel();

        ActionListener listener=event->
        {
            int temp=0;
            if(bold.isSelected())
                temp+=Font.BOLD;
            if(italic.isSelected())
                temp+=Font.ITALIC;
            label.setFont(new Font("Serif",temp,24));
        };

        bold.addActionListener(listener);
        italic.addActionListener(listener);

        southpanel.add(bold);
        southpanel.add(italic);
        add(southpanel,BorderLayout.SOUTH);
      //  pack();   //test

    }
}
