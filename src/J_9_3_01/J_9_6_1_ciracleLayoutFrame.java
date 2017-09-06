package J_9_3_01;
import javax.swing.*;
import java.awt.*;


public class J_9_6_1_ciracleLayoutFrame
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new CircleLayoutFrame();
            frame.setTitle("这是一个圆形排列组件的测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class CircleLayoutFrame extends JFrame
{
    public CircleLayoutFrame()
    {
        setLayout(new CircleLayout());
        add(new Button("Yellow.."));
        add(new Button("Blue.."));
        add(new Button("Red.."));
        add(new Button("Green.."));
        add(new Button("Orange.."));
        add(new Button("Fushsia.."));
        add(new Button("Indigo.."));
        pack();
    }
}

class CircleLayout implements LayoutManager
{
    public CircleLayout(){}

    private int minWidth=0;
    private int minHeight=0;
    private int preferredWidth=0;
    private int preferredHeight=0;
    private boolean sizesSet=false;
    private int maxComponentWidth=0;
    private int maxComponentHeight=0;

    public void addLayoutComponent(String name,Component comp)
    {

    }

    public void removeLayoutComponent(Component comp)
    {

    }

    public void setSizes(Container parent)
    {
        if(sizesSet)
            return ;
        int n=parent.getComponentCount();

        preferredWidth=0;
        preferredHeight=0;
        minWidth=0;
        minHeight=0;
        maxComponentWidth=0;
        maxComponentHeight=0;

        //计算最大组件的宽度和高度，并且设置组件的首选尺寸
        for(int i=0;i<n;i++)
        {
            Component c=parent.getComponent(i);

            if(c.isVisible())
            {
                Dimension d=c.getPreferredSize();
                maxComponentWidth=Math.max(maxComponentWidth,d.width);
                maxComponentHeight=Math.max(maxComponentHeight,d.height);
                preferredWidth +=d.width;
                preferredHeight+=d.height;
            }
        }

        minWidth=preferredWidth;
        minHeight=preferredHeight;
        sizesSet=true;   //将大小锁定
    }

    public Dimension preferredLayoutSize(Container parent)   //首选宽度+组件边框周围的外部填充
    {
        setSizes(parent);  //计算min，max的width，和height
        Insets insets=parent.getInsets();
        int width=preferredWidth+insets.left+insets.right;   //inset 指的是组建边框周围的外部填充
        int height=preferredHeight+insets.top+insets.bottom;
        return new Dimension(width,height);
    }

    public Dimension minimumLayoutSize(Container parent)
    {
        setSizes(parent);
        Insets insets=parent.getInsets();
        int width=minWidth+insets.left+insets.right;
        int height=minHeight+insets.top+insets.bottom;
        return new Dimension(width,height);
    }

    public void layoutContainer(Container parent)
    {
        setSizes(parent);

        Insets insets=parent.getInsets();
        int containerWidth=parent.getSize().width-insets.left-insets.right;
        int containerHeight=parent.getSize().height-insets.top-insets.bottom;

        int xcenter=insets.left+containerWidth/2;
        int ycenter=insets.top+containerHeight/2;

        //计算圆形的中心
        int xradius=(containerWidth-maxComponentWidth)/2;
        int yradius=(containerHeight-maxComponentHeight)/2;
        int radius=Math.min(xradius,yradius);

        int n=parent.getComponentCount();
        for(int i=0;i<n;++i)
        {
            Component c=parent.getComponent(i);
            if(c.isVisible())
            {
                double angle=2*Math.PI*i/n;

                int x=xcenter+(int)(Math.cos(angle)*radius);
                int y=ycenter+(int)(Math.sin(angle)*radius);

                //将组件移动到坐标
                Dimension d=c.getPreferredSize();
                c.setBounds(x-d.width/2,y-d.height/2,d.width,d.height);
            }
        }


    }




}


/*

javax.swing
类 GroupLayout.SequentialGroup

java.lang.Object
  继承者 javax.swing.GroupLayout.Group
      继承者 javax.swing.GroupLayout.SequentialGroup
正在封闭类：
GroupLayout
public class GroupLayout.SequentialGroup


      extends
      GroupLayout.Group

一个 Group，它按顺序一个接一个地确定其元素的位置和大小。此类没有公共构造方法，要创建 SequentialGroup，请使用 createSequentialGroup 方法。

要沿按基线对齐的 ParallelGroup 的基线对齐 SequentialGroup，您需要指定使用 SequentialGroup 的哪些元素来确定基线。使用一个带 boolean 的 add 方法来指定用于计算基线的元素。用 useAsBaseline 为 true 值的 add 方法添加的最后一个元素将用于计算基线。

从以下版本开始：
1.6
另请参见：
GroupLayout.createSequentialGroup()

方法摘要
 GroupLayout.SequentialGroup	addComponent(boolean useAsBaseline, Component component)
          将 Component 添加到此 Group。
 GroupLayout.SequentialGroup	addComponent(boolean useAsBaseline, Component component, int min, int pref, int max)
          使用指定大小将 Component 添加到此 Group。
 GroupLayout.SequentialGroup	addComponent(Component component)
          将 Component 添加到此 Group。
 GroupLayout.SequentialGroup	addComponent(Component component, int min, int pref, int max)
          使用指定大小将 Component 添加到此 Group。
 GroupLayout.SequentialGroup	addContainerGap()
          添加一个表示容器边缘和触到容器边框的组件之间首选间隙的元素。
 GroupLayout.SequentialGroup	addContainerGap(int pref, int max)
          使用指定大小添加一个元素，它表示容器的一个边缘和下一个或前一个 Component 之间的首选间隙。
 GroupLayout.SequentialGroup	addGap(int size)
          将固定间隙添加到此 Group。
 GroupLayout.SequentialGroup	addGap(int min, int pref, int max)
          将指定大小的间隙添加到此 Group。
 GroupLayout.SequentialGroup	addGroup(boolean useAsBaseline, GroupLayout.Group group)
          将 Group 添加到此 Group。
 GroupLayout.SequentialGroup	addGroup(GroupLayout.Group group)
          将 Group 添加到此 Group。
 GroupLayout.SequentialGroup	addPreferredGap(JComponent comp1, JComponent comp2, LayoutStyle.ComponentPlacement type)
          添加一个表示两个组件之间首选间隙的元素。
 GroupLayout.SequentialGroup	addPreferredGap(JComponent comp1, JComponent comp2, LayoutStyle.ComponentPlacement type, int pref, int max)
          添加一个表示两个组件之间首选间隙的元素。
 GroupLayout.SequentialGroup	addPreferredGap(LayoutStyle.ComponentPlacement type)
          添加一个表示两个距离最近的组件之间首选间隙的元素。
 GroupLayout.SequentialGroup	addPreferredGap(LayoutStyle.ComponentPlacement type, int pref, int max)
          添加一个表示两个距离最近的组件之间首选间隙的元素。




          javax.swing
类 GroupLayout.ParallelGroup

java.lang.Object
  继承者 javax.swing.GroupLayout.Group
      继承者 javax.swing.GroupLayout.ParallelGroup
正在封闭类：
GroupLayout
public class GroupLayout.ParallelGroup


      extends
      GroupLayout.Group

一个 Group，它对齐其子元素并确定其大小。ParallelGroup 以四种可能的方式对齐其子元素：沿基线、居中、固定在前端、固定在尾端。

基线

使其子元素沿基线对齐的 ParallelGroup 必须首先确定基线固定的位置。基线可以固定在组的顶部或底部。也就是说，基线和组开始位置之间的距离可以是一个恒定距离，或者组结束位置和基线之间的距离可以是一个恒定距离。可能的选择对应于 BaselineResizeBehavior 常量 CONSTANT_ASCENT 和 CONSTANT_DESCENT。
基线锚点 (anchor) 可以由 createBaselineGroup 方法显式地指定，也可以根据元素来确定。如果没有显式地指定，那么如果所有带有基线以及向基线对齐的元素的基线调整大小行为都是 CONSTANT_DESCENT，则基线将固定在组的底部；否则，基线将固定在组的顶部。

如果向基线对齐的元素的基线调整大小行为是 CONSTANT_ASCENT 或 CONSTANT_DESCENT，则它们是可调整大小的。基线调整大小行为是 OTHER 或 CENTER_OFFSET 的元素是不可调整大小的。

基线是根据每个具有基线的元素的首选高度来计算的。使用以下算法来计算基线：max(maxNonBaselineHeight, maxAscent + maxDescent)，其中 maxNonBaselineHeight 是所有不具有基线或不沿基线对齐的元素中的最大高度。maxAscent 是所有具有基线并沿基线对齐的元素中的最大上升高度（基线）。maxDescent 是所有具有基线并沿基线对齐的元素中的最大下降高度（首选高度－基线）。

使其元素沿基线对齐的 ParallelGroup 仅用于垂直轴。如果创建了一个基线组并沿水平轴使用它，那么在向 GroupLayout 请求最小大小、首选大小或最大大小，或者试图布置组件时，将抛出 IllegalStateException。

没有向基线对齐并且大小小于 ParallelGroup 的元素以下面三种方式之一确定其位置：居中、固定在前端、固定在尾端。

无基线 ParallelGroup

用 BASELINE 以外的对齐方式创建的 ParallelGroup 将小于组大小的元素以下面三种方式之一进行对齐：居中、固定在前端、固定在尾端。
前端是基于轴和 ComponentOrientation 的。对于垂直轴，往往顶边缘是前端，底边缘是尾端。当 ComponentOrientation 为 LEFT_TO_RIGHT 时，前端是左边缘，尾端是右边缘。ComponentOrientation 为 RIGHT_TO_LEFT 时则前端是右边缘，尾端是左边缘。根据添加元素时所使用的指定对齐方式来对齐子元素。如果没有指定对齐方式，则使用为 ParallelGroup 指定的对齐方式。

要沿基线对齐元素，可以使用 BASELINE 对齐方式来 createBaselineGroup 或 createParallelGroup。如果组不是使用基线对齐方式创建的，那么在试图添加一个指定基线对齐方式的元素时将抛出 IllegalArgumentException。

从以下版本开始：
1.6
另请参见：
GroupLayout.createParallelGroup(), GroupLayout.createBaselineGroup(boolean,boolean)

方法摘要
 GroupLayout.ParallelGroup	addComponent(Component component)
          将 Component 添加到此 Group。
 GroupLayout.ParallelGroup	addComponent(Component component, GroupLayout.Alignment alignment)
          使用指定的对齐方式将 Component 添加到此 ParallelGroup。
 GroupLayout.ParallelGroup	addComponent(Component component, GroupLayout.Alignment alignment, int min, int pref, int max)
          使用指定的对齐方式和大小将 Component 添加到此 ParallelGroup。
 GroupLayout.ParallelGroup	addComponent(Component component, int min, int pref, int max)
          使用指定大小将 Component 添加到此 Group。
 GroupLayout.ParallelGroup	addGap(int pref)
          将固定间隙添加到此 Group。
 GroupLayout.ParallelGroup	addGap(int min, int pref, int max)
          将指定大小的间隙添加到此 Group。
 GroupLayout.ParallelGroup	addGroup(GroupLayout.Alignment alignment, GroupLayout.Group group)
          使用指定的对齐方式将 Group 添加到此 ParallelGroup。
 GroupLayout.ParallelGroup	addGroup(GroupLayout.Group group)
          将 Group 添加到此 Group。



          addContainerGap

public GroupLayout.SequentialGroup addContainerGap()
添加一个表示容器边缘和触到容器边框的组件之间首选间隙的元素。如果添加的间隙没有触到父容器的边缘，则此方法没有任何效果。
创建用来表示间隙的元素是不可调整大小的。

返回：
此 SequentialGroup



addGroup

public GroupLayout.SequentialGroup addGroup(boolean useAsBaseline,
                                            GroupLayout.Group group)
将 Group 添加到此 Group。
参数：
group - 要添加的 Group
useAsBaseline - 指定的 Group 是否应该用于计算此 Group 的基线
返回：
此 Group



createParallelGroup

public GroupLayout.ParallelGroup createParallelGroup()
使用 Alignment.LEADING 的对齐方式创建并返回一个 ParallelGroup。此方法是更常用的 createParallelGroup(Alignment) 方法的覆盖方法。
返回：
一个新的 ParallelGroup




createSequentialGroup

public GroupLayout.SequentialGroup createSequentialGroup()
创建并返回一个 SequentialGroup。
返回：
一个新的 SequentialGroup



addComponent

public GroupLayout.Group addComponent(Component component)
将 Component 添加到此 Group。
参数：
component - 要添加的 Component
返回：
此 Group
addComponent

public GroupLayout.Group addComponent(Component component,
                                      int min,
                                      int pref,
                                      int max)
使用指定大小将 Component 添加到此 Group。
参数：
component - 要添加的 Component
min - 最小大小或者 DEFAULT_SIZE 或 PREFERRED_SIZE 之一
pref - 首选大小或者 DEFAULT_SIZE 或 PREFERRED_SIZE 之一
max - 最大大小或者 DEFAULT_SIZE 或 PREFERRED_SIZE 之一
返回：
此 Group



addPreferredGap

public GroupLayout.SequentialGroup addPreferredGap(LayoutStyle.ComponentPlacement type)
添加一个表示两个距离最近的组件之间首选间隙的元素。在布局过程中，找到相邻组件，并根据组件之间的首选间隙来设置添加间隙的大小。如果找不到相邻组件，则间隙的大小为 0。
创建用来表示间隙的元素是不可调整大小的。

参数：
type - 间隙的类型； LayoutStyle.ComponentPlacement.RELATED 或 LayoutStyle.ComponentPlacement.UNRELATED
返回：
此 SequentialGroup



addPreferredGap

public GroupLayout.SequentialGroup addPreferredGap(LayoutStyle.ComponentPlacement type,
                                                   int pref,
                                                   int max)
添加一个表示两个距离最近的组件之间首选间隙的元素。在布局过程中，找到相邻元素，并根据相邻组件之间的首选间隙大小来设置此间隙的最小大小。如果找不到相邻组件，则最小大小被设置为 0。
参数：
type - 间隙的类型； LayoutStyle.ComponentPlacement.RELATED 或 LayoutStyle.ComponentPlacement.UNRELATED
pref - 间隙的首选大小； DEFAULT_SIZE 或大于等于 0 的值
max - 间隙的最大大小； DEFAULT_SIZE、 PREFERRED_SIZE 或大于等于 0 的值
返回：
此 SequentialGroup



javax.swing
枚举 LayoutStyle.ComponentPlacement

java.lang.Object
  继承者 java.lang.Enum<LayoutStyle.ComponentPlacement>
      继承者 javax.swing.LayoutStyle.ComponentPlacement

枚举常量摘要
INDENT
          一个枚举值，指示被请求组件要缩排的距离。
RELATED
          一个枚举值，指示两个组件在视觉上相关，并且将被放置在同一个父容器中。
UNRELATED
          一个枚举值，指示两个组件在视觉上不相关，并且将被放置在同一个的父容器中。



          TRAILING

public static final int TRAILING
此值指示每行组件都应该与容器方向的结束边对齐，例如，对于从左到右的方向，则与右边对齐。



javax.swing
枚举 GroupLayout.Alignment

java.lang.Object
  继承者 java.lang.Enum<GroupLayout.Alignment>
      继承者 javax.swing.GroupLayout.Alignment
枚举常量摘要
BASELINE
          指示元素应该沿其基线对齐。
CENTER
          指示元素应该在区域内居中。
LEADING
          指示元素应该向原点对齐。
TRAILING
          指示元素应该向区域底端对齐。




          linkSize

public void linkSize(Component... components)
将指定组件强制调整为具有相同的大小，而不管其首选大小、最小大小或最大大小如何。将所有链接组件首选大小中的最大值赋予链接的组件。例如，如果将首选宽度分别为 10 和 20 的两个组件链接起来，则两个组件的宽度都将变为 20。
可以多次使用此方法来将任意数量的组件强制调整为具有相同的大小。

链接的 Component 是不可调整大小的。

参数：
components - 要具有相同大小的 Component
抛出：
IllegalArgumentException - 如果 components 为 null 或包含 null
另请参见：
linkSize(int,Component[])
linkSize

public void linkSize(int axis,
                     Component... components)
将指定组件强制调整为沿指定轴具有相同的大小，而不管其首选大小、最小大小或最大大小如何。将所有链接组件首选大小中的最大值赋予链接的组件。例如，如果沿水平轴将首选宽度分别为 10 和 20 的两个组件链接起来，则两个组件的宽度都将变为 20。
可以多次使用此方法来将任意数量的组件强制调整为具有相同的大小。

链接的 Component 是不可调整大小的。

参数：
components - 要具有相同大小的 Component
axis - 沿其链接大小的轴； SwingConstants.HORIZONTAL 或 SwingConstans.VERTICAL 之一



javax.swing
类 LayoutStyle

java.lang.Object
  继承者 javax.swing.LayoutStyle
public abstract class LayoutStyle


      extends
      Object

LayoutStyle 提供有关如何确定组件位置的信息。此类主要用于可视化工具和布局管理器。大多数开发人员不需要使用此类。

通常不设置或创建 LayoutStyle。而是使用静态方法 getInstance 获取当前实例。

从以下版本开始：
1.6

嵌套类摘要
static class	LayoutStyle.ComponentPlacement
          ComponentPlacement 是两个组件相对于彼此的可能放置方式的枚举。
构造方法摘要
LayoutStyle()
          创建一个新的 LayoutStyle。
方法摘要
abstract  int	getContainerGap(JComponent component, int position, Container parent)
          返回组件与其父容器的指定边缘之间放置的空格数量。
static LayoutStyle	getInstance()
          返回 LayoutStyle 的共享实例。
abstract  int	getPreferredGap(JComponent component1, JComponent component2, LayoutStyle.ComponentPlacement type, int position, Container parent)
          返回两个组件之间使用的空格的数量。
static void	setInstance(LayoutStyle style)
          设置 LayoutStyle 的共享实例。



          addGap

public GroupLayout.Group addGap(int min,
                                int pref,
                                int max)
将指定大小的间隙添加到此 Group。
参数：
min - 间隙的最小大小
pref - 间隙的首选大小
max - 间隙的最大大小
返回：
此 Group



setLayout

public void setLayout(LayoutManager mgr)
设置此容器的布局管理器。
参数：
mgr - 指定的布局管理器



setBounds

public void setBounds(int x,
                      int y,
                      int width,
                      int height)
移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
参数：
x - 组件的新 x 坐标
y - 组件的新 y 坐标
width - 组件的新 width
height - 组件的新 height


addLayoutComponent

void addLayoutComponent(String name,
                        Component comp)
如果布局管理器使用每组件字符串，则将组件 comp 添加到布局，并将它与 name 指定的字符串关联。
参数：
name - 要与组件关联的字符串
comp - 要添加的组件



layoutContainer

void layoutContainer(Container parent)
布置指定容器。
参数：
parent - 要布置的容器

 void	addLayoutComponent(String name, Component comp)
          如果布局管理器使用每组件字符串，则将组件 comp 添加到布局，并将它与 name 指定的字符串关联。
 void	layoutContainer(Container parent)
          布置指定容器。
 Dimension	minimumLayoutSize(Container parent)
          给定指定容器所包含的组件，计算该容器的最小大小维数。
 Dimension	preferredLayoutSize(Container parent)
          给定指定容器所包含的组件，计算该容器的首选大小维数。
 void	removeLayoutComponent(Component comp)
          从布局移除指定组件。



          addLayoutComponent

void addLayoutComponent(String name,
                        Component comp)
如果布局管理器使用每组件字符串，则将组件 comp 添加到布局，并将它与 name 指定的字符串关联。
参数：
name - 要与组件关联的字符串
comp - 要添加的组件



getComponent

public Component getComponent(int n)
获取此容器中的第 n 个组件。
参数：
n - 要获取的组件的索引。
返回：
此容器中的 n th 组件。
抛出：
ArrayIndexOutOfBoundsException - 如果 n th 值不存在。
getComponents

public Component[] getComponents()
获取此容器中的所有组件。
返回：
此容器中的所有组件的数组。



max

public static double max(double a,
                         double b)
返回两个 double 值中较大的一个。也就是说，结果为更接近正无穷大的参数。如果参数值相同，那么结果也是同一个值。如果任一值为 NaN，那么结果为 NaN。与数值比较运算不同，该方法认为负 0 严格小于正 0。如果一个参数为正 0，另一个参数为负 0，那么结果为正 0。
参数：
a - 参数。
b - 另一个参数。
返回：
a 和 b 中的较大者。


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



getInsets

public Insets getInsets()
确定此容器的 insets，它指示容器边框的大小。
例如，Frame 对象有一个顶端 inset，它对应于窗体的标题栏的高度。

返回：
此容器的 inset。
从以下版本开始：
JDK1.1
 */