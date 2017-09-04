package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_4_8_CheckBox
{
    public static void main(String[] args)
    {
        JFrame frame=new CheckBoxFrame();
        frame.setTitle("这是一个复选框测试...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
class CheckBoxFrame extends JFrame
{
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE=24;

    public CheckBoxFrame()
    {
        label=new JLabel("The quick browm fox jump over the lazy dog(测试文本）");
        label.setFont(new Font("Serif",Font.BOLD,FONTSIZE));
        add(label,BorderLayout.CENTER);

        ActionListener listener=event-> {
            int mode=0;
            if(bold.isSelected())
                mode+=Font.BOLD;
            if(italic.isSelected())
                mode+=Font.ITALIC;
            label.setFont(new Font("Serif",mode,FONTSIZE));
        };

        JPanel buttonPanel=new JPanel();

        bold=new JCheckBox("BOLD");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic=new JCheckBox("ITALIC");
        italic.addActionListener(listener);
        italic.setSelected(true);
        buttonPanel.add(italic);

        add(buttonPanel,BorderLayout.SOUTH);
        pack();

    }


}
/*
java.swing.JCheckBox
    JCheckBox(String label)
    构造一个复选框，初始状态没有被选择
    JCheckBox(String label,Icon icon)
    构造一个复选框，初始状态没有被选择
    JCheckBox(String label,boolean state);
    用给定的标签和初始化状态构造一个复选框
    boolean isSelected()
    void setSelected(boolean state)
    获取或者设置复选框的选择状态


 */



