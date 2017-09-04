package J_9_3_01;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author cmx
 */
public class mouseComponent1
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->
        {
            JFrame frame=new MouseFrame();
            frame.setTitle("鼠标点击测试...");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setBackground(Color.BLUE);
        });
    }

}

class MouseFrame  extends JFrame
{
    public MouseFrame()
    {
        setSize(500,600);
        add(new MouseComponent());

       // pack();

    }
}

class MouseComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;  //边界长度
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent()
    {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());


    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (Rectangle2D r : squares)
        {
            g2.draw(r);
        }
    }

    public Rectangle2D find(Point2D p)
    {
        for (Rectangle2D r : squares)
            if (r.contains(p))
                return r;
        return null;
    }

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
    /*    if (s == null)
            return;
        if (s == current)
            current = null;
    */
        squares.remove(s);
        repaint();
    }

    public class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)
        {
            current = find(event.getPoint());
            if (current == null)
                add(event.getPoint());   //?
        }


        public void mouseClicked(MouseEvent event)
        {
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            if (find(event.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }


        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}
/*

弄清了事件处理的工作过程后，总结一下AWT事件处理的体系架构。
前面已经提到，Java事件处理采用的是面向对象的方法
有些swing组件会生成其他类型事件的对象，它们都直接扩展与EventObject，而不是AWTEvent
事件对象封装了事件源于监听器彼此通信的事件信息。在必要的时候，可以对传递给监听器对象的事件进行分析。
在按钮例子中，是借助getSourse（）和getActionCommand（）方法实现对象分析的。
AWT(Abstract Window Toolkit)，中文译为抽象窗口工具包
AWT将事件分为底层事件和语义事件。语义事件是表示用户动作的时间。
ActionEvent是一个语义事件。底层事件时形成那些事件的事件
调节滚动条是一个语义事件，但是拖动鼠标时一个底层事件。
对于有些AWT事件类型，java程序员并不实际使用，比如paintEvent对象不会传递给监听器，java程序员不监听绘图事件，如果需要重新绘图，
就需要覆盖paintComponent方法，AWT还生成许多只对系统程序员有用的事件，用于提供表义语言的输入系统以及自动检测机器人等
下面是java.awt.event包中最常用的语义事件类
ActionEvent 按钮点击，菜单选择，选择列表，在文本框中ENTER
AdjustmentEvent 用户调节滚动条
ItemEvent 用户从复选框或者列表中选择一项
常用的5个底层事件是；
KeyEvent 一个按键按下或者释放
MouseEvent 鼠标键被按下，释放，移动或者拖动
MouseWheelEvent鼠标滚轮被转动
FocusEvent 某个组件获得焦点或者失去焦点
WindowEvent 窗口状态被改变
下列接口将监听这些事件
ActionListener
AdjustmentListener
FocusListener
IntemListener
KeyListener
MouseListener
MouseMotionListener
MouseWheelListener'
WindowListener
WindowFocusListener
WindowStateListener
有几个AWT
监听器接口包含多个方法，特们都有一个适配器，在这个类中实现了响应接口中的所有方法，但每一个方法都没有做任何事情（有的接口只有一个方法
，所以就没有必要定义适配器了
适配器类：
FocusAdapter
KeyAdapter
MouseAdapter
MouseMotionAdapter
WindowAdapter
javax.swing.event包中包含了许多专门用于Swing组建的附加事件。

对于大多数组件来说，模型类将实现一个名字以Model结尾的接口，例如，按钮就实现了ButtonModel接口。
实现了此接口的类可以定义各种按钮的状态。实际上，按钮并不复杂，在Swing库中有一个名为DefaultButtonModel的类就实现了这个接口。
每一个JButton对象都存储了一个按钮模型对象，可以用下列方式来得到他的信用。
JButton button=new JButton（"h"）;
ButtonModel model=button.getModel();
下面来看ButtonModel不包含的信息，模型不存储按钮标签或者图标，对于一个按钮来说，仅凭模型无法知道它的外观。
需要注意的是，同样的模型（即DefaultButtonModel）可以用于下压按钮，单选按钮，复选框，甚至菜单项。当然，这些按钮都各自有不同的视图和控制器
，当使用Metal观感时候，JButton类用BasicButtonUI类作为视图，用ButtonUIListener作为其控制器。通常，每一个swing组件都有一个相关的后缀
为UI的视图对象，但并不是所有的Swing组件都有专门的控制器对象。
通常，组件放在容器中，布局管理器决定容器中的组件具体放置位置和大小。
按钮，文本域和其他的用户界面元素都继承与Component类，组件可以放置在面板这样的容器中。JPanel继承于Component（组件）中。
由于Container类继承于Component类，所以容器也可以放在另外一个容器中。
JFrame这样的顶层窗口是Container的子类，所以也是Component的子类。但是却不能放置在其他的容器中。另外，JComponent是Component
的子类，但是不直接继承Component，因此，可以将其他组件增加到JButton中。但是无论如何，这些组件无法显示出来
每个容器都有一个默认的布局管理器，但是可以重新进行设置。例如，使用下面语句：
panel.setLayout(new GridLayout(4,4));
GridLayout 网格布局
GridLayout
public GridLayout(int rows,
                  int cols,
                  int hgap,
                  int vgap)
创建具有指定行数和列数的网格布局。给布局中的所有组件分配相等的大小。
此外，将水平和垂直间距设置为指定值。水平间距将置于列与列之间。将垂直间距将置于行与行之间。

rows 和 cols 中的一个可以为零（但不能两者同时为零），这表示可以将任何数目的对象置于行或列中。

所有 GridLayout 构造方法都服从这一规定。
参数：
rows - 该 rows 具有表示任意行数的值零
cols - 该 cols 具有表示任意列数的值零
hgap - 水平间距
vgap - 垂直间距

这个面板将用GridLayout类布局组件，可以往容器中添加组件。容器中的add方法将把组件和放置的方位传递给布局管理器
java.awt.Container
    void SetLayout(LayoutManager m)
    为容器设计布局管理器
    Component add（Component c）
    Component add（Component c，Object constraints）
    将组件添加到容器中，并返回组件的引用
    c 要添加的组件
    constrains 布局管理器理解的标识符
java.awt.FlowLayout()
    流布局管理器
    FlowLayout（）
    FlowLayout（int align）
    FlowLayout（int align，int hgap，int vgap）
    align LEFT，CENTER，或者RIGHT
边框布局
    边框布局管理器（border layout manager）是每个JFrame的内容窗格的默认布局管理器，流布局管理器完全控制每个组件的放置位置
边关管理器则不然，它允许为每个组件选择一个放置位置。可以选择把组件放在内容窗格的中部，东西南北部。
例如：
    frame.add(component,BorderLayout.SOUTH);
    先放置边缘组件，剩余的可用空间由中建组件占据。当容器被缩放时，边缘组件的尺寸不会改变，而中部组建的大小会发生变化。在添加组件时可以指定BorderLayout
    类中的CENTER，NORTH，SOUTH，EAST，和WEST常量。并不是需要占用所有的位置，如果没有提供任何值，系统默认为CENTER
BoderLayout的常量定义为字符串，对于BoderLayout.SOUTH,可以直接写为"SOUTH"
与流布局不同，边框布局会扩展所有组件的尺寸以便填满可用空间（流布局将维持每个组件的最佳尺寸）。当将一个按钮添加到容器中时会出现问题：
frame.add(yellowButton,BorderLayout.SOUTH);
按钮会扩展至填满框架的整个南部区域。而且如果再将另外一个按钮添加到南部区域，就回去带第一个按钮。
解决这个问题的常见方法时使用另外一个面板Panel，屏幕底部的三个按钮全部包含在一个面板中，这个面板被放置在内容窗格的南部。
要想得到这种配置效果，首先需要创建一个新的JPanel对象，然后逐一的将按钮添加到面板中。面板的默认布局管理器是流布局管理器（FlowLayoutManager）
（框架的默认布局管理器是边界布局管理器BorderLayoutManager）
这恰好符合我们的要求。随后使用在前面已经看到的add方法将每个按钮添加到面板中。每个按钮放置的位置和尺寸完全处于FlowLayout布局管理器的控制之下。
这意味着这些按钮将置于面板的中央，而且不会扩展至填满整个面板区域。最后，将这个面板添加到框架的内容窗格中。
JPanel panel=new JPanel();
panel.add(yellowButton);
panel.add(blueButton);
panel.add(redButton);
frame.add(panel,BorderLayout.SOUTH);
边界布局管理器会扩展面板大小，直至填满整个南部区域
java.awt.BorderLayout
    BorderLayout();
    BorderLayout(int hgap,int vgap);
    构造一个新的BorderLayout对象
网格布局
    网格布局性电子数据表一样，按行列排列所有的组件。每个单元的大小都是一样的。缩放窗口时，所有按钮尺寸的比例保持一致。
    在网格布局对象的构造器中，需要制定行数和列数
    panel.setLayout(new GridLayout(3,3));
    添加组件，从第一行的第一列开始，然后是第一行的第二列
    panel.add(new JButton("1"));
    panel.add(new JButton("2"));
实际上，在组织窗口布局时一行或者一列的小网比较有用，如果想纺织一行尺寸都一样的按钮，就可以将这些按钮放置在一个面板内，这个面板只有一行的网络布局进行管理





 */