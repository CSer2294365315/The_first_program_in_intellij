package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class J_9_4_13
{
    public static void main(String[ ] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new ComboBoxFrame();
            frame.setTitle("这是一个组合框测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class ComboBoxFrame extends JFrame
{
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE=24;

    public ComboBoxFrame()
    {
        setSize(600,600);
        label=new JLabel("这是一个测试...");
        label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
        add(label,BorderLayout.CENTER);

        faceCombo=new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");

        faceCombo.addActionListener(event->
        {
            label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),Font.PLAIN,DEFAULT_SIZE));
        });

        JPanel comboPanel=new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel,BorderLayout.SOUTH);
      //  pack();

    }
}
/*
javax.swing.JComboBox
    boolean isEditable()
    void setEditable(boolean b)
    获取或者设置组合框的可编辑特性
    void addItem(Object item)
    讲一个选项插入到列表中
    void insertItemAt(Object item,int index)
    将一个选项添加到列表指定的位置。
    void removeItem(Object item)
    从列表中删除一个选项
    void removeItemAt(int index)
    删除指定位置的选项
    void removeAllItems()
    从列表中删除所有选项
    Object getSelectedItem()
    返回当前选的的选项



 */