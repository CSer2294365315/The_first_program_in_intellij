package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_4_11
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new RadioButton();
            frame.setTitle("这是一个单选钮测试 ...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class RadioButton extends JFrame
{
    private JLabel label;
    private JPanel buttonPanel;
    private ButtonGroup group;
    public RadioButton()
    {
        label=new JLabel("中英文测试语句：Testing test in chinese and in English...");
        label.setFont(new Font("Serif",Font.PLAIN,20));
        add(label,BorderLayout.CENTER);

         buttonPanel=new JPanel();
        group=new ButtonGroup();
        addRadioButton("small",10);
        addRadioButton("plain",20);
        addRadioButton("big",30);

        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
    public void addRadioButton(String name,int size)
    {

        JRadioButton button=new JRadioButton(name);
        group.add(button);
        button.addActionListener(event->label.setFont(new Font("Serif",Font.BOLD,size)));
        buttonPanel.add(button);
    }
}
/*
javax.swing.JRadioButton
    JRadioButton(String label, Icon icon);
    构造一个单选钮，初始没有被选择
    JRadioButton（String label，boolean state）
    用给定的标签和初始状态构造一个单选钮
javax.swing.ButtonGroup
    void add(AbstractButton b)
    将按钮添加到组中
    ButtonModel getSelection()
    返回被选择按钮的按钮模型
javax.swing.ButtonModel
    String getActionCommand()
    返回按钮模型的命令
javax.swing.AbstarctButton()
    void setActionCommand(String s)
    设置按钮以及其模型的动作命令

 */