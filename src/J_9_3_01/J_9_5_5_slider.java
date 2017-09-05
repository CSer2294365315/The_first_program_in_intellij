package J_9_3_01;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class J_9_5_5_slider
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            JFrame frame=new sliderFrame();
            frame.setTitle("这是一个滑动条测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class sliderFrame extends JFrame
{
    private ChangeListener listener;
    private JTextField textField;
    public sliderFrame()
    {
        /*
        JLabel label=new JLabel("这是一个滑动条测试...");
        lable.setFont(new Font("Serif",Font.BOLD,20));
        add(label,BorderLayout.CENTER);
        */

        JPanel sliderPanel=new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        listener_1=event->{
            JSlider source=(JSlider) event.getSource();
            textField.setText(""+source.getValue);
        };

        JSlider slider=new JSlider();
        addSlider(silder,"Plain");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Ticks");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"Snap to ticks");

        slider=new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintTrace(false);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider,"No track");









    }
    public void addSlider(JSlider s,String name)
    {
        s.addChangeListener(listener_1);
        JPanel panel=new JPanel();
        panel.add(s);
        panel.add(new JLabel(name));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        GridBagConstaints gbc=new GridBagConstaints();
        gbc.gridy=sliderPanel.getComponent();
        gbc.anchor=GridBagConstaints.WEST;
        sliderPanel.add(panel,gbc);


    }


}


/*
java.util
Class EventObject

java.lang.Object
java.util.EventObject
之
getSource
public Object getSource()
事件最初发生的对象。
结果
事件最初发生的对象。


getValue
public int getValue()
从 BoundedRangeModel返回滑块的当前值。
结果
滑块的当前值



构造方法
Constructor and Description
JSlider()
创建一个水平滑块，范围为0到100，初始值为50。
JSlider(BoundedRangeModel brm)
使用指定的BoundedRangeModel创建水平滑块。
JSlider(int orientation)
使用范围为 0至 100的指定方向创建滑块，初始值为 50 。
JSlider(int min, int max)
使用指定的最小和最大值创建水平滑块，初始值等于最小加最大值的平均值。
JSlider(int min, int max, int value)
使用指定的最小值，最大值和值创建水平滑块。
JSlider(int orientation, int min, int max, int value)
创建具有指定方向和指定的最小值，最大值和初始值的滑块。

getAlignmentY

public float getAlignmentY()
重写 Container.getAlignmentY 以返回水平对齐方式。
覆盖：
类 Container 中的 getAlignmentY
返回：
alignmentY 属性的值
另请参见：
setAlignmentY(float), Component.getAlignmentY()
setAlignmentY

public void setAlignmentY(float alignmentY)
设置水平对齐方式。
参数：
alignmentY - 新的水平对齐方式
另请参见：
getAlignmentY()
getAlignmentX

public float getAlignmentX()
重写 Container.getAlignmentX 以返回垂直对齐方式。
覆盖：
类 Container 中的 getAlignmentX
返回：
alignmentX 属性的值
另请参见：
setAlignmentX(float), Component.getAlignmentX()
setAlignmentX

public void setAlignmentX(float alignmentX)
设置垂直对齐方式。
参数：
alignmentX - 新的垂直对齐方式

LEFT_ALIGNMENT

public static final float LEFT_ALIGNMENT
getAlignmentX 的易于使用的常量。指定组件左对齐方式。

类 GridBagConstraints

java.lang.Object
  继承者 java.awt.GridBagConstraints
所有已实现的接口：
Serializable, Cloneable
public class GridBagConstraints


      extends
      Object




      implements
      Cloneable,
      Serializable

GridBagConstraints 类指定使用 GridBagLayout 类布置的组件的约束。


getComponentCount
public int getComponentCount()
获取此面板中的组件数量。
注意：此方法应在AWT树锁下调用。

结果
该面板中的组件数量。

gridy

public int gridy
指定位于组件显示区域的顶部的单元格，其中最上边的单元格为 gridy=0。值 RELATIVE 指定将组件放置在添加此组件之前刚刚添加到容器中的组件的下面。
默认值为 RELATIVE。gridy 应为非负值。


public int anchor
当组件小于其显示区域时使用此字段。它可以确定在显示区域中放置组件的位置。
可能的值有三种：相对于方向的值、相对于基线的值和绝对值。相对于方向的值是相对于容器的组件方向属性进行解释的，相对于基线值是相对于基线进行解释的，绝对值则不然。绝对值有：CENTER、NORTH、NORTHEAST、EAST、SOUTHEAST、SOUTH、SOUTHWEST、WEST 和 NORTHWEST。方向相对值有：PAGE_START、PAGE_END、LINE_START、LINE_END、FIRST_LINE_START、FIRST_LINE_END、LAST_LINE_START 和 LAST_LINE_END。相对于基线的值有：BASELINE、BASELINE_LEADING、BASELINE_TRAILING、ABOVE_BASELINE、ABOVE_BASELINE_LEADING、ABOVE_BASELINE_TRAILING、BELOW_BASELINE、BELOW_BASELINE_LEADING 和 BELOW_BASELINE_TRAILING。默认值为 CENTER。

put

public V put(K key,
             V value)
将指定 key 映射到此哈希表中的指定 value。键和值都不可以为 null。
通过使用与原来的键相同的键调用 get 方法，可以获取相应的值。

指定者：
接口 Map<K,V> 中的 put
指定者：
类 Dictionary<K,V> 中的 put
参数：
key - 哈希表的键
value - 值
返回：
此哈希表中指定键的以前的值；如果不存在该值，则返回 null
抛出：
NullPointerException - 如果键或值为 null
 */
