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
/*
        getSelectedIndex
        public int getSelectedIndex()
        获取所选的确认选项。
        结果
        选中的确认选项表示为YES ， NO ， OK或CANCEL如果optionType被指定为这个的构造ConfirmationCallback 。 否则，该方法返回选中的确认选项作为一个指数到options指定到此的构造阵列ConfirmationCallback 。

        getItemAt
public E getItemAt(int index)
返回指定索引处的列表项。 如果index超出范围（小于零或大于或等于大小），它将返回null 。
参数
index - 表示列表位置的整数，第一个项目从零开始
结果
该列表位置的项目; 如果超出范围， null

java.lang.Object
java.awt.Component
java.awt.Container
javax.swing.JComponent
javax.swing.JComboBox<E>
参数类型
E - 这个组合框的元素的类型
All Implemented Interfaces:
ActionListener ， ImageObserver ， ItemSelectable ， MenuContainer ， Serializable ， EventListener ， Accessible ， ListDataListener

public class JComboBox<E>
extends JComponent
implements ItemSelectable, ListDataListener, ActionListener, Accessible
组合按钮或可编辑字段和下拉列表的组件。 用户可以根据用户的请求从下拉列表中选择一个值。 如果使组合框可编辑，则组合框包含用户可以键入值的可编辑字段。


addItem
public void addItem(E item)
将项目添加到项目列表。 该方法仅在JComboBox使用可变数据模型时有效。
警告：如果添加重复的String对象，可能会出现焦点和键盘导航问题。 解决方法是添加新对象而不是String对象，并确保定义了toString（）方法。 例如：

  comboBox.addItem(makeObj("Item 1"));
   comboBox.addItem(makeObj("Item 1"));
   ...
   private Object makeObj(final String item)  {
     return new Object() { public String toString() { return item; } };
   }
参数
item - 要添加到列表中的项目

setSelectedIndex
public void setSelectedIndex(int anIndex)
选择索引号为 anIndex的项目。
参数
anIndex - 指定要选择的列表项的整数，其中0指定列表中的第一个项，-1表示不选择


getItemAt
public E getItemAt(int index)
返回指定索引处的列表项。 如果index超出范围（小于零或大于或等于大小），它将返回null 。
参数
index - 表示列表位置的整数，第一个项目从零开始


*/