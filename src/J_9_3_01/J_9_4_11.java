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
边框：
    如果愿意的话，可以给边框添加标题，具体的实现方法是将边框传递给BorderFactory.createTitledBorder
    如果确实想把一切凸显出来，就可以调用下列方法将几种边框组合起来使用；
    BorderFactory.createCompoundBorder
    调用JComponent类中的setBorder方法将结果边框添加到组件中。
    例如：
    Border etched =BorderFactory.createEtchedBorder();
    Border titled=BorderFactory.createTitledBorder(etched,"A Title");
    panel.setBorder(titled);


    createTitledBorder
public static TitledBorder createTitledBorder(Border border,
                                              String title)
将标题添加到现有边框，默认定位（由当前外观确定），默认对齐（前导）和默认字体和文字颜色（由当前外观确定）。
参数
border - 要添加标题的 Border对象
title - 一个 String包含标题的文本
结果
TitledBorder对象

createTitledBorder
public static TitledBorder createTitledBorder(Border border,
                                              String title,
                                              int titleJustification,
                                              int titlePosition,
                                              Font titleFont,
                                              Color titleColor)
使用指定的定位，字体和颜色将标题添加到现有边框。
参数
border - Border对象添加标题
title - 一个 String标题文本的String
titleJustification - 一个指定标题titleJustification的整数 - 以下之一：
TitledBorder.LEFT
TitledBorder.CENTER
TitledBorder.RIGHT
TitledBorder.LEADING
TitledBorder.TRAILING
TitledBorder.DEFAULT_JUSTIFICATION （领先）
titlePosition - 指定文本相对于边框的垂直位置的整数 - 以下之一：
TitledBorder.ABOVE_TOP
TitledBorder.TOP （坐在顶线）
TitledBorder.BELOW_TOP
TitledBorder.ABOVE_BOTTOM
TitledBorder.BOTTOM （坐在底线）
TitledBorder.BELOW_BOTTOM
TitledBorder.DEFAULT_POSITION （标题位置由目前的外观所决定）
titleFont - 一个 Font标题字体的 Font对象
titleColor - 一个 Color标题颜色的 Color对象
结果
TitledBorder对象

不同的边框有不同的用于设置边框的宽度和颜色的选项。SoftBevelBorder类用于构造具有柔和边框，LineBorder类也能够构造圆角。这些边框只能通过类的某个构造器构造，而没有BorderFactory方法

 */