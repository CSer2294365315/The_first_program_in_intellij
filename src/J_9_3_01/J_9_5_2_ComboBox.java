package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class J_9_5_2_ComboBox
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new comBoxFrame();
            frame.setTitle("这是一个组合框测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class componentColor extends JComponent
{
    public componentColor()
    {
        setBackground(Color.red);
        setSize(600,600);
    }
}
class comBoxFrame extends JFrame
{
    public comBoxFrame()
    {
        componentColor c=new componentColor();
        setSize(600,600);
        setBackground(Color.GREEN);
        JLabel label=new JLabel("这是一个组合框测试......");
        label.setFont(new Font("Serif",Font.BOLD,20));
        add(label,BorderLayout.CENTER);

        JComboBox<String> comboBox=new JComboBox<>();

        comboBox.addItem("Serif");
        comboBox.addItem("SansSerif");
        comboBox.addItem("Monospaced");

        comboBox.addActionListener(event->
        {
            label.setFont(new Font(comboBox.getItemAt(comboBox.getSelectedIndex()),Font.BOLD,30));
        });

        JPanel comboBoxPanel=new JPanel();
        comboBoxPanel.add(comboBox);

        add(comboBoxPanel,BorderLayout.SOUTH);
    }
}









/*


javax.swing
类 JComboBox

java.lang.Object
  继承者 java.awt.Component
      继承者 java.awt.Container
          继承者 javax.swing.JComponent
              继承者 javax.swing.JComboBox
所有已实现的接口：
ActionListener, ImageObserver, ItemSelectable, MenuContainer, Serializable, EventListener, Accessible, ListDataListener
public class JComboBox


      extends
      JComponent




      implements
      ItemSelectable,
      ListDataListener,
      ActionListener,
      Accessible

将按钮或可编辑字段与下拉列表组合的组件。用户可以从下拉列表中选择值，下拉列表在用户请求时显示。如果使组合框处于可编辑状态，则组合框将包括用户可在其中键入值的可编辑字段。



addItem

public void addItem(Object anObject)
为项列表添加项。仅当 JComboBox 使用可变数据模型时此方法才有效。
警告：如果添加复制的 String 对象，可能会发生焦点和键盘导航问题。解决方法是，添加新对象而不是 String 对象，并且确保定义了 toString() 方法。例如：

   comboBox.addItem(makeObj("Item 1"));
   comboBox.addItem(makeObj("Item 1"));
   ...
   private Object makeObj(final String item)  {
     return new Object() { public String toString() { return item; } };
   }

参数：
anObject - 要添加到列表的 Object

 */