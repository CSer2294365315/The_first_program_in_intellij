package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_5_3_again_comboBox
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new comboBoxFrameText();
            frame.setTitle("test...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }
}
class comboBoxFrameText extends JFrame
{
    public comboBoxFrameText()
    {
        JLabel label=new JLabel("这是一个测试...");
        label.setFont(new Font("Serif",Font.BOLD,20));
        add(label,BorderLayout.CENTER);

        JComboBox<String> comboBox=new JComboBox<>();
        comboBox.addItem("Serif");
        comboBox.addItem("Monospaced");

        JPanel panel=new JPanel();
        panel.add(comboBox);

        add(panel,BorderLayout.SOUTH);

        comboBox.addActionListener(event->{
            label.setFont(new Font(comboBox.getItemAt(comboBox.getSelectedIndex()),Font.BOLD,30));
        });



    }
}
