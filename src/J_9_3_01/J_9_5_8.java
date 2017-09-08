package J_9_3_01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;

public class J_9_5_8
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new FontFrame();
            frame.setTitle("这是一个GridBagLayout测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            System.out.println("1");
        });
    }
}


class FontFrame extends JFrame
{
    public static final int TEXT_ROWS=10;
    public static final int TEXT_COLUMNS=20;

    private JComboBox<String> face;
    private JComboBox<Integer> size;

    private JCheckBox bold;
    private JCheckBox italic;

    private JTextArea sample;

    public FontFrame()
    {
       // setSize(600,600);
        GridBagLayout layout=new GridBagLayout();
        setLayout(layout);

        ActionListener listener=event->updateSample();

        JLabel faceLabel=new JLabel("Face: ");
        face=new JComboBox<>(new String[] {"Serif","SanSerif","Monospaced","Dialog","DialogInput"});

        face.addActionListener(listener);

        JLabel sizeLabel=new JLabel("Size: ");

        size=new JComboBox<>(new Integer[] {8,10,12,15,18,24,36,48});
        size.addActionListener(listener);

        bold=new JCheckBox("BOLD");
        bold.addActionListener(listener);

        italic=new JCheckBox("ITALIC");   //这是对象的构造信息，italic.add...不一定就作为参数在listener中
        italic.addActionListener(listener);

        sample =new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
        sample.setText("这是一个文本输入域的测试...");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        add(faceLabel,new GBC(0,0).setAnchor(GBC.EAST));
        add(face,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
        add(sizeLabel,new GBC(0,1).setAnchor(GBC.EAST));
        add(size,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
        add(bold,new GBC(0,2,2,1).setAnchor(GBC.CENTER).setWeight(100,100));
        add(italic,new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100,100));
        add(sample,new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100,100));
        pack();
        updateSample();

     //   setSize(600,600);

    }

    public void updateSample()
    {
        String fontFace=(String) face.getSelectedItem();
        int fontStyle=(bold.isSelected() ? Font.BOLD:0)+(italic.isSelected() ? Font.ITALIC : 0);
        int fontSize=size.getItemAt(size.getSelectedIndex());
        Font font=new Font(fontFace,fontStyle,fontSize);
        sample.setFont(font);
        sample.repaint();
    }


 public class GBC extends GridBagConstraints
    {
        public GBC(int gridx,int gridy)
        {
            this.gridx=gridx;
            this.gridy=gridy;
        }

        public GBC(int gridx,int gridy,int gridwidth,int gridheight)
        {
            this.gridx=gridx;
            this.gridy=gridy;
            this.gridwidth=gridwidth;
            this.gridheight=gridheight;
        }

        public GBC setAnchor(int anchor)
        {
            this.anchor=anchor;
            return this;
        }

        public GBC setFill(int fill)
        {
            this.fill=fill;
            return this;
        }

        public GBC setWeight(double weightx,double weighty)
        {
            this.weightx=weightx;
            this.weighty=weighty;
            return this;
        }

        public GBC setInsets(int distance)
        {
            this.insets=new Insets(distance,distance,distance,distance);
            return this;
        }

        public GBC setInsets(int top,int left,int bottom,int right)
        {
            this.insets=new Insets(top,left,bottom,right);
            return this;
        }

        public GBC serIpad(int ipadx,int ipady)
        {
            this.ipadx=ipadx;
            this.ipady=ipady;
            return this;
        }

    }
}

















/*

ipadx

public int ipadx
此字段指定组件的内部填充，即给组件的最小宽度添加多大的空间。组件的宽度至少为其最小宽度加上 ipadx 像素。
默认值为 0。

另请参见：
clone(), ipady
ipady

public int ipady
此字段指定内部填充，即给组件的最小高度添加多大的空间。组件的高度至少为其最小高度加上 ipady 像素。
默认值为 0。

另请参见：
clone(), ipadx



fill

public int fill
当组件的显示区域大于它所请求的显示区域的大小时使用此字段。它可以确定是否调整组件大小，以及在需要的时候如何进行调整。
以下值适用于 fill：

NONE：不调整组件大小。
HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。
VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。
BOTH：使组件完全填满其显示区域。
默认值为 NONE。



insets

public Insets insets
此字段指定组件的外部填充，即组件与其显示区域边缘之间间距的最小量。
默认值为 new Insets(0, 0, 0, 0)。




GridBagConstraints

public GridBagConstraints(int gridx,
                          int gridy,
                          int gridwidth,
                          int gridheight,
                          double weightx,
                          double weighty,
                          int anchor,
                          int fill,
                          Insets insets,
                          int ipadx,
                          int ipady)
创建一个 GridBagConstraints 对象，将其所有字段都设置为传入参数。注：因为使用此构造方法会妨碍源代码的可读性，所以此构造方法仅供自动源代码生成工具使用。
参数：
gridx - 初始 gridx 值。
gridy - 初始 gridy 值。
gridwidth - 初始 gridwidth 值。
gridheight - 初始 gridheight 值。
weightx - 初始 weightx 值。
weighty - 初始 weighty 值。
anchor - 初始 anchor 值。
fill - 初始 fill 值。
insets - 初始 insets 值。
ipadx - 初始 ipadx 值。
ipady - 初始 ipady 值。



weightx

public double weightx
指定如何分布额外的水平空间。
网格包布局管理器计算出列的权重将是列的所有组件中最大的 weightx。如果得到的布局在水平方向上比需要填充的区域小，那么系统会将额外的空间按照其权重比例分布到每一列。权重为零的列不会得到额外的空间。

如果所有的权重都为零，则所有的额外空间都将出现在单元格的网格之间和左右边缘之间。

此字段的默认值为 0。weightx 应为非负值。

另请参见：
clone(), weighty
weighty

public double weighty
指定如何分布额外的垂直空间。
网格包布局管理器计算出行的权重将是行的所有组件中最大的 weighty。如果得到的布局在垂直方向上比需要填充的区域小，则系统会将额外的空间按照其权重比例分布到每一行。权重为零的行不会得到额外的空间。

如果所有的权重都为零，则所有的额外空间都将出现在单元格的网格之间和上下边缘之间。

此字段的默认值为 0。weighty 应为非负值。



构造方法详细信息
Insets

public Insets(int top,
              int left,
              int bottom,
              int right)
创建并初始化具有指定顶部、左边、底部、右边 inset 的新 Insets 对象。
参数：
top - 顶部的 inset。
left - 左边的 inset。
bottom - 底部的 inset。
right - 右边的 inset。
方法详细信息
set

public void set(int top,
                int left,
                int bottom,
                int right)
将顶部、底部、左边和右边设置为指定值
参数：
top - 顶部的 inset。
left - 左边的 inset。
bottom - 底部的 inset。
right - 右边的 inset。
JComboBox

public JComboBox(Object[] items)
创建包含指定数组中的元素的 JComboBox。默认情况下，选择数组中的第一项（因而也选择了该项的数据模型）。
参数：
items - 要插入到组合框的对象数组


createEtchedBorder

public static Border createEtchedBorder()
创建一个具有“浮雕化”外观效果的边框，将组件的当前背景色用于高亮显示和阴影显示。
 */