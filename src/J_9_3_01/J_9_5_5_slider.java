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

        listener=even->{
            JSlider source=(JSlider) event.getSource();
            textField.setText(""+source.getValue);
        };

        JSlider slider=new JSlider();
        addSlider







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
 */
