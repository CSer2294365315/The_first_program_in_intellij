package J_9_3_01;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class J_9_5_1
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new ComboBoxFrame();
            frame.setTitle("这是一个组合框测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.
            frame.Visible(true);
        });
    }
}

class ComboBoxFrame extends JFrame
{
    private JComboBox<String> faceCombo;
    public ComboBoxFrame()
    {
        JLabel label=new JLabel("这是一个测试用例...");
        label.setFont(new Font("Serif",Font.BOLD,20));
        add(label,BorderLayout.CENTER);

        faceCombo=new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Dialog");

        faceCombo.addActionListener(event->{
            label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex())),Font.BOLD,20);
        });

        JPanel panel=new JPanel();
        panel.add(faceCombo,Border.SOUTH);

        pack();

    }

}
